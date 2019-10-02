package com.springbootlearning.mybatis.service;

import com.springbootlearning.mybatis.dao.AccountMapper;
import com.springbootlearning.mybatis.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaoyanhai
 * @date 2019-10-02
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public int add(String name,double money){
        return accountMapper.add(name,money);
    }

    public int update(String name,double money,int id){
        return accountMapper.update(name,money,id);
    }

    public int delete(int id){
        return accountMapper.delete(id);
    }

    public Account selectAccountById(int id){
        return accountMapper.selectAccountById(id);
    }

    public List<Account> selectAccountList(){
        return accountMapper.selectAccountList();
    }
}
