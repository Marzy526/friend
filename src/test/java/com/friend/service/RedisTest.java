package com.friend.service;

import com.friend.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("mzyString", "dog");
        valueOperations.set("mzyInt", 1);
        valueOperations.set("mzyDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("mzy");
        valueOperations.set("mzyUser", user);
        // 查
        Object mzy = valueOperations.get("mzyString");
        Assertions.assertTrue("dog".equals((String) mzy));
        mzy = valueOperations.get("mzyInt");
        Assertions.assertTrue(1 == (Integer) mzy);
        mzy = valueOperations.get("mzyDouble");
        Assertions.assertTrue(2.0 == (Double) mzy);
        System.out.println(valueOperations.get("mzyUser"));
        valueOperations.set("mzyString", "dog");
        redisTemplate.delete("mzyString");
    }
}
