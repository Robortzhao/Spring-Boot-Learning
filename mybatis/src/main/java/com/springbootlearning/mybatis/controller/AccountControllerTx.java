package com.springbootlearning.mybatis.controller;

import com.springbootlearning.mybatis.service.AccountServiceTx;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyanhai
 * @date 2019-10-02
 */
@RestController
@RequestMapping("/account")
@MapperScan("com.springbootlearning.mybatis.dao")
public class AccountControllerTx {

    @Autowired
    AccountServiceTx accountServiceTx;

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public void transfer(){
        accountServiceTx.transfer();
    }
}
