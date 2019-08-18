package com.xdclass.redis.controller;

import com.xdclass.redis.RedisService;
import com.xdclass.redis.domain.User;
import com.xdclass.redis.mapper.UserMapper;
import com.xdclass.redis.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 **/
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final String key = "userCache_";

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;

    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(String id) {
        User user = userMapper.find(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/getUserCache")
    public User getUserCache(String id) {
        User user = (User) redisService.get(key + id);

        if (user == null) {
            User dbUser = userMapper.find(id);
            System.out.println("fresh value from DB id:" + id);
            if (dbUser != null) {
                redisService.set(key + id, dbUser);
                return dbUser;
            }
        }
        return user;
    }

    @ResponseBody
    @RequestMapping("/getByCache")
    public User getByCache(String id) {
        User user = userService.findById(id);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/getexpire", method = RequestMethod.GET)
    public User findByTtl(String id) {
        User user = new User();
        try {

            user = userService.findByTtl(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

}
