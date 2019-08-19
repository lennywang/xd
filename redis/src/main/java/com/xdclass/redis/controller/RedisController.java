package com.xdclass.redis.controller;

import com.xdclass.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.invoke.MethodHandles;

/**
 *
 **/
@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {
    private Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisService redisService;

    @RequestMapping("/set_and_get")
    @ResponseBody
    public String setAndGet(String name,String key){
        logger.info("开始执行setAndGet方法");
        redisTemplate.opsForValue().set(name,key);
        String result= (String) redisTemplate.opsForValue().get(name);
        System.out.println(result);
        logger.info("结束执行setAndGet方法");
        return result;
    }

    @RequestMapping("/set_and_get_by_service")
    public String setAndGetByService(String name,String key){
        redisService.set(name,key);
        return (String) redisService.get(name);
    }

}
