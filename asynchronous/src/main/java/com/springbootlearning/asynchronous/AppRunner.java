package com.springbootlearning.asynchronous;

import com.springbootlearning.asynchronous.entity.User;
import com.springbootlearning.asynchronous.service.GitHubLookUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author zhaoyanhai
 * @description 异步方法测试
 * @date 2019/10/3
 **/
@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private final GitHubLookUpService gitHubLookUpService;

    public AppRunner(GitHubLookUpService gitHubLookUpService) {
        this.gitHubLookUpService = gitHubLookUpService;
    }

    @Override
    public void run(String... args) throws Exception {
        Long start = System.currentTimeMillis();

        Future<User> page1 = gitHubLookUpService.findUser("PivotalSoftware");
        Future<User> page2 = gitHubLookUpService.findUser("CloudFoundry");
        Future<User> page3 = gitHubLookUpService.findUser("Spring-Projects");

        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
            Thread.sleep(10);
        }

        LOGGER.info("Elapsed time: " + (System.currentTimeMillis() - start));
        LOGGER.info("--> " + page1.get());
        LOGGER.info("--> " + page2.get());
        LOGGER.info("--> " + page3.get());
    }
}
