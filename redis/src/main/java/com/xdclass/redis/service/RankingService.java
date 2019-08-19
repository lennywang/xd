package com.xdclass.redis.service;

import com.xdclass.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 **/
public class RankingService {

    private static final String RANKNAME="user_score";

    private static final String SALESCORE="sale_score_rank:";

    @Autowired
    private RedisService redisService;

    public void rankAdd(String uid,Integer score)
    {
        redisService.zAdd(RANKNAME,uid,score);
    }


}
