package com.dylan.xinyidai05;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author baoxiang
 * @create 2020-07-10 13:45
 */
@SpringBootTest
public class RedisTemplateTest {

    private RedisTemplate   redisTemplate;


    @CacheEvict
    @Test
    public void test(){
        redisTemplate.opsForValue();

        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps("");

    }


}
 