package com.crm.comm.service.impl;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.crm.comm.service.RedisService;

import java.util.concurrent.TimeUnit;*/


//@Service
public class RedisServiceImpl {//implements RedisService{

/*
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void setObject(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    @Override
    public void delete(String key){
        redisTemplate.delete(key);
    }*/

}
