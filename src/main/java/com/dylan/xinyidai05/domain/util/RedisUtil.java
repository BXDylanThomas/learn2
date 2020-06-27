package com.dylan.xinyidai05.domain.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.types.Expiration;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 *
 * Redis工具类
 * @Aouthor: shixianchao
 * @name: RedisUtil
 * @projectName metroplex
 * @create 2019-09-03 下午1:53
 */
@Slf4j
public class RedisUtil {

    public static final Long LOCK_SUCCESS = 1L;
    public static final Integer LOCK_RETRYTIMES = 3;
    public static final Long LOCK_EXPIRED_TIME = 300000L;//五分钟

    //定义获取锁的脚本
    private final static DefaultRedisScript<Long> LOCK_LUA_SCRIPT = new DefaultRedisScript<>(
            "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then return redis.call('pexpire', KEYS[1], ARGV[2]) else return 0 end"
            , Long.class);

    //定义释放锁的脚本
    private final static DefaultRedisScript<Long> UNLOCK_LUA_SCRIPT = new DefaultRedisScript<>(
            "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return -1 end"
            , Long.class);

    @SuppressWarnings("unchecked")
    private static RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtil
            .getBean("redisTemplate");

    public static Long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }


    public static void put(String key, String value, int expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    public static void put(String key, Object value, int expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    public static void put(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public static void put(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public static String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key, Class<T> clazz) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getList(String key, Class<T> clazz) {
        return (List<T>) redisTemplate.opsForValue().get(key);
    }

    public static boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public static void delete(String key) {
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        redisConnection.del(key.getBytes());
    }

    public static boolean setIfAbsent(String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public static void updateExpireTime(String key, final long timeout, final TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    public static boolean lock(String key) {
        return lock(key, UUID.randomUUID().toString(),LOCK_EXPIRED_TIME,LOCK_RETRYTIMES);
    }

    public static boolean lock(String key,String value) {
        return lock(key,value,LOCK_EXPIRED_TIME,LOCK_RETRYTIMES);
    }

    public static boolean lock(String key,String value ,long timeout) {
        return lock(key,value,timeout,LOCK_RETRYTIMES);
    }

    /**
     * 加锁
     * @param key redis键值对 的 key
     * @param value redis键值对 的 value  随机串作为值
     * @param timeout redis键值对 的 过期时间   pexpire 以毫秒为单位
     * @param retryTimes 重试次数   即加锁失败之后的重试次数，根据业务设置大小，默认为3
     * @return
     */
    public static boolean lock(String key,String value ,long timeout, int retryTimes) {
        log.info("加锁信息：key：{} :: value：{} :: timeout：{} :: retryTimes：{}",key,value,timeout,retryTimes);
        try {
            if(retryTimes <= 0) retryTimes = LOCK_RETRYTIMES;
            if(timeout <= 0) timeout = LOCK_EXPIRED_TIME;

            Object result = redisTemplate.execute(LOCK_LUA_SCRIPT, Collections.singletonList(key),value,timeout);
            if(LOCK_SUCCESS.equals(result)) {
                log.info("线程：{}加锁成功：key：{} :: value：{} :: timeout：{} :: retryTimes：{}",Thread.currentThread().getName(),key,value,timeout,retryTimes);
                return true;
            } else {
                log.info("线程：{}重试加锁：key：{} :: value：{} :: timeout：{} :: retryTimes：{}",Thread.currentThread().getName(),key,value,timeout,retryTimes);
                int count = 0;
                while(true) {
                    try {
                        Thread.sleep(200);
//                        result = redisTemplate.execute(LOCK_LUA_SCRIPT, Collections.singletonList(key));
                        result = redisTemplate.execute(LOCK_LUA_SCRIPT, Collections.singletonList(key),value,timeout);
                        if(LOCK_SUCCESS.equals(result)) {
                            log.info("线程：{}重试加锁成功：key：{} :: value：{} :: timeout：{} :: retryTimes：{}",Thread.currentThread().getName(),key,value,timeout,retryTimes);
                            return true;
                        } else {
                            count++;
                            if (retryTimes == count) {
                                log.info("线程：{}重试加锁失败：key：{} :: value：{}",Thread.currentThread().getName(),key,value);
                                return false;
                            } else {
                                log.warn("线程：{}重试加锁，key：{}，次数：{}",Thread.currentThread().getName(),key,count);
                                continue;
                            }
                        }
                    } catch (Exception e) {
                        log.error("线程：{}重试加锁异常：",Thread.currentThread().getName(), e);
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            log.error("加锁异常：",ex);
        }
        return false;
    }


    /**
     * 释放锁
     * @param key   释放本请求对应的锁的key
     * @param value 释放本请求对应的锁的value  是不重复随即串 用于比较，以免释放别的线程的锁
     * @return
     */
    public static boolean unlock(String key,String value) {
        log.info("解锁信息：key：{} :: value：{}",key,value);
        try {
            //返回-1 说明获取到的KEY值与requestId不一致或者KEY不存在，可能已经过期或被其他线程加锁
            //返回0 其他情况，一般是删除KEY失败
            Object result = redisTemplate.execute(UNLOCK_LUA_SCRIPT, Collections.singletonList(key), value);
            //如果这里抛异常，后续锁无法释放
            if (LOCK_SUCCESS.equals(result)) {
                log.info("线程：{}解锁成功：key：{} :: value：{}",Thread.currentThread().getName(),key,value);
                return true;
            }
            log.info("线程：{}解锁失败：key：{} :: value：{}，result：{}",Thread.currentThread().getName(),key,value,result);
        } catch (Exception e) {
            log.error("解锁异常：",e);
        }

        return false;
    }

    /**
     * 设置缓存中的值
     * 设置成功，返回true，如果key已经存在，返回false
     * 设置值请使用put方法
     * @param key
     * @param value
     * @param expire 毫秒
     * @return
     */
    public static boolean set(String key, String value,long expire) {
        try {
            RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
            return redisConnection.set(key.getBytes(), value.getBytes(), Expiration.seconds(expire) , RedisStringCommands.SetOption.ifAbsent());
        } catch (Exception e) {
            log.error("set redis occured an exception", e);
        }
        return false;
    }

}
