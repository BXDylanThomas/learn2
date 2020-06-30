package com.dylan.xinyidai05.interfaces.facade;

import com.dylan.xinyidai05.application.RedisTest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 0:52
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

	@Autowired
	private RedisTest redisTest;

	@RequestMapping("/save")
	public Object save(@RequestBody RedisModel redisModel){
		return redisTest.set(redisModel.getKey(),redisModel.getValue());
	}

	@GetMapping("test1")
	public Object test1(String id){
		return redisTest.cacheTest(id);
	}


	@GetMapping("test2")
	public Object test2(String id){
		return redisTest.cacheTest2(id);
	}


	@GetMapping("test3")
	public Object test3(String id){
		return redisTest.cacheTest2(id);
	}

	@GetMapping("/format")
	public LocalDateTime format(){
		return LocalDateTime.now();
	}

	@GetMapping("/format2")
	public LocalDateTime format2(LocalDateTime localDateTime){
		log.info("{}",localDateTime);
		return LocalDateTime.now();
	}

	@Data
	public static class RedisModel implements Serializable {
		private String key;
		private String value;
	}

}
