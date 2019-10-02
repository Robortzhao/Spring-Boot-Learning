package com.springbootlearning.redis.message;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * 创建一个消息接收者,需要注入到springboot中
 *
 * @author zhaoyanhai
 * @data 2019-10-02
 */

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Receiver<" + message + ">");
        latch.countDown();
    }

}
