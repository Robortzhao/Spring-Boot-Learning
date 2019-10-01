package com.springbootlearning.jpa.service.impl;

import com.springbootlearning.jpa.dao.AccountDao;
import com.springbootlearning.jpa.entity.Account;
import com.springbootlearning.jpa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaoyanhai
 * @date 2019-10-01
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account add(Account account) {
        return accountDao.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountDao.saveAndFlush(account);
    }

    @Override
    public void delete(int id) {
        accountDao.deleteById(id);
    }

    @Override
    public Account selectAccountById(int id) {
        return accountDao.getOne(id);
    }

    @Override
    public List<Account> selectAccountList() {
        return accountDao.findAll();
    }
}
