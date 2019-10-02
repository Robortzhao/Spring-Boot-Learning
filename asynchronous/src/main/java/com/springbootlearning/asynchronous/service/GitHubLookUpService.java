package com.springbootlearning.asynchronous.service;

import com.springbootlearning.asynchronous.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class GitHubLookUpService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubLookUpService.class);

    private final RestTemplate restTemplate;

    public GitHubLookUpService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * @param user
     * @return java.util.concurrent.Future<com.springbootlearning.asynchronous.entity.User>
     * @throws
     * @Description 获取githubAPI的方法
     * @author zhaoyanhai
     * @date 2019/10/3
     **/
    @Async
    public Future<User> findUser(String user) throws InterruptedException {
        LOGGER.info("Look up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        Thread.sleep(1000L);
        return new AsyncResult<>(results);
    }


}
