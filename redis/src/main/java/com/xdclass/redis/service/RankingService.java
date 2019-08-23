package com.xdclass.redis.service;

import com.xdclass.redis.RedisService;
import com.xdclass.redis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 **/
public class RankingService {

    private static final String RANKNAME="user_score";

    private static final String SALESCORE="sale_score_rank:";

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserMapper userMapper;

    public void rankAdd(String uid,Integer score)
    {
        redisService.zAdd(RANKNAME,uid,score);
    }

    public Map<String,Object> userRank(String uid,String name)
    {
        Map<String, Object> retMap = new LinkedHashMap<>();
        String key = uid + ":" + name;
        int rank = redisService.zRank(SALESCORE, key).intValue();
        long score = redisService.zSetScore(SALESCORE, key).longValue();
        retMap.put("userId",uid);
        retMap.put("score",score);
        retMap.put("rank",rank);

        return retMap;
    }

    public List<Map<String,Object>> reverseZRankWithRank(long start,long end)
    {
        Set<ZSetOperations.TypedTuple<Object>> setObj = redisService.reverseZRankWithRank(SALESCORE, start, end);
        List<Map<String, Object>> collect = setObj.stream().map(objectTypedTuple -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("userId", objectTypedTuple.getValue().toString().split(":")[0]);
            map.put("userName", objectTypedTuple.getValue().toString().split(":")[1]);
            map.put("score", objectTypedTuple.getScore());
            return map;
        }).collect(Collectors.toList());

        return collect;
    }

    public List<Map<String,Object>> saleRankWithScore(Integer start,Integer end)
    {
        Set<ZSetOperations.TypedTuple<Object>> setObj = redisService.reverseZRankWithRank(SALESCORE, start, end);
        List<Map<String, Object>> mapList = setObj.stream().map(objectTypedTuple -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("userId", objectTypedTuple.getValue().toString().split(":")[0]);
            map.put("userName", objectTypedTuple.getValue().toString().split(":")[1]);
            map.put("score", objectTypedTuple.getScore());
            return map;
        }).collect(Collectors.toList());
        return mapList;
    }


}
