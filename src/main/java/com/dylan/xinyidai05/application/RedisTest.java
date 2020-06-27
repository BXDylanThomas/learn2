package com.dylan.xinyidai05.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 0:50
 */
@Service
public class RedisTest {

	@Autowired
	private RedisTemplate redisTemplate;

	public Object set(String key,String value){
		redisTemplate.opsForValue().set(key,value);
		return true;
	}

	@Cacheable(cacheNames = "test1",key = "#id")
	public Object cacheTest(String id){
		System.out.println("查询库");
		return "缓存测试";
	}


	@Cacheable(cacheNames = "test2",key = "#id")
	public Object cacheTest2(String id){
		System.out.println("查询库");
		return "缓存测试2";
	}
}
