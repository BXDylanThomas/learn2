package com.dylan.xinyidai05;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @author baoxiang
 * @create 2020-07-10 9:31
 */
@SpringBootTest
public class RestTemplateTest {

    private RestTemplate restTemplate;

    @Test
    public void test(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate.getRequestFactory();
    }
}
 