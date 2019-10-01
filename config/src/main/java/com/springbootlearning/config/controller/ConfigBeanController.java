package com.springbootlearning.config.controller;

import com.springbootlearning.config.bean.ConfigBean;
import com.springbootlearning.config.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class ConfigBeanController {

    @Autowired
    private ConfigBean configBean;
    @Autowired
    private User user;

    @RequestMapping(value = "/getConfigBean")
    public String getConfigBean() {
        return configBean.getGreeting() + ":" + configBean.getName() + ":" + configBean.getUuid() + ":" + configBean.getMax();
    }

    @RequestMapping(value = "/getUser")
    public String getUser() {
        return user.getName() + ":" + user.getAge();
    }
}

