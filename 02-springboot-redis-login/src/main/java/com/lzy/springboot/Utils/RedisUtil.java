package com.lzy.springboot.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private  RedisTemplate redisTemplate;

    public  void set(String key,String value,Long expire){
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key,expire, TimeUnit.MINUTES);
    }

    public  Object get(String key){

        return redisTemplate.opsForValue().get(key);
    }
}
