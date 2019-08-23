package com.xdclass.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;

/**
 *
 **/
@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(final String key,Object value)
    {
        boolean result = false;

        try {
            ValueOperations<Serializable,Object> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public void zAdd(String key,Object value,double score)
    {
        SetOperations zset = redisTemplate.opsForSet();
        zset.add(key,value,score);
    }

    /**
     * 有序集合获取排名
     *
     * @param key 集合名称
     * @param value 值
     */
    public Long zRank(String key, Object value) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rank(key,value);
    }

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     */
    public Double zSetScore(String key, Object value) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.score(key,value);
    }

    public void incrementScore(String key,Object value,double score)
    {
        ZSetOperations zSet = redisTemplate.opsForZSet();
        zSet.incrementScore(key,value,score);
    }

    public Set<ZSetOperations.TypedTuple<Object>> reverseZRankWithRank(String key,long start,long end)
    {
        ZSetOperations zset = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> set = zset.reverseRangeWithScores(key, start, end);
        return set;
    }
}
