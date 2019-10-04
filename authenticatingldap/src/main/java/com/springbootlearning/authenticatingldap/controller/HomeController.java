package com.springbootlearning.authenticatingldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyanhai
 * @description TODO
 * @date 2019/10/4
 **/
@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
}
