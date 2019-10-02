package com.springbootlearning.redis;

import com.springbootlearning.redis.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    public static Logger logger = LoggerFactory.getLogger(RedisApplicationTests.class);

    public void contextLoads() {
    }

    @Autowired
    RedisDao redisDao;

    @Test
    public void testRedis() {
        redisDao.setKey("name", "zhaoyanhai");
        redisDao.setKey("age", "24");
        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));
    }

}
