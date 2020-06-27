package com.dylan.xinyidai05.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 23:10
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
	//缓存管理器
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
		return RedisCacheManager
				.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
				.cacheDefaults(redisCacheConfiguration).build();
	}

//	@Bean
//	@Override
//	public KeyGenerator keyGenerator() {
//		return (target, method, params) -> {
//			StringBuffer sb = new StringBuffer();
//			sb.append(target.getClass().getName());
//			sb.append(method.getName());
//			for(Object obj:params){
//				sb.append(obj.toString());
//			}
//			System.out.println("调用Redis生成key："+sb.toString());
//			return sb.toString();
//		};
//	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
		StringRedisTemplate template = new StringRedisTemplate(factory);
		setSerializer(template);//设置序列化工具
//		template.afterPropertiesSet();
		return template;
	}

	private void setSerializer(StringRedisTemplate template){
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		RedisSerializer stringSerializer = new StringRedisSerializer();
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(stringSerializer);

		template.setKeySerializer(stringSerializer);
		template.setValueSerializer(stringSerializer);
		template.setHashKeySerializer(stringSerializer);
		template.setHashValueSerializer(stringSerializer);
	}


	/**
	 * 实例化 RedisTemplate - 没事务 - Protostuff序列化方式, 用于存储大多数的表对象和分页缓存
	 */
	@Bean(name = "redisTemplate4Protostuff")
	public RedisTemplate redisTemplate4Protostuff(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		setSerializer(template);//设置序列化工具
		template.afterPropertiesSet();
		return template;
	}

	/**
	 * 实例化 RedisTemplate - 有事务 - Protostuff序列化方式, 用于存储大多数的表对象和分页缓存
	 */
	@Bean(name = "transRedisTemplate4Protostuff")
	public RedisTemplate transRedisTemplate4Protostuff(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		setSerializer(template);//设置序列化工具
		template.afterPropertiesSet();
		return template;
	}
}
