package com.xdclass.redis.service;

import com.xdclass.redis.domain.User;
import com.xdclass.redis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.util.annotation.Nullable;

/**
 *
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Nullable
    @Cacheable(key = "#p0")
    public User findById(String id)
    {
        System.out.println("根据id="+id+"获取用户对象，从数据库中获取");
        Assert.notNull(id,"id不能为空");
        return this.userMapper.find(id);
    }

    @Nullable
    @Cacheable(value = "UserInfoList",keyGenerator = "simpleKeyGenerator")
    public User findByTtl(String id)
    {
        System.err.println("根据id="+id+"获取用户对象，从数据库中获取");
        Assert.notNull(id,"id不能为空");
        return this.userMapper.find(id);
    }
}
