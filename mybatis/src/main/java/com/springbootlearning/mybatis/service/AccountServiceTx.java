package com.springbootlearning.mybatis.service;


import com.springbootlearning.mybatis.dao.AccountMapperTx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaoyanhai
 * @date 2019-10-02
 */
@Service
public class AccountServiceTx {
    @Autowired
    AccountMapperTx accountMapperTx;

    @Transactional
    public void transfer() throws RuntimeException{
        accountMapperTx.update(90,1);//用户1减10块 用户2加10块
        int i=1/0;
        accountMapperTx.update(110,2);
    }
}
