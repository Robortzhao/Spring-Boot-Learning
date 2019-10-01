package com.springbootlearning.jdbc.service.impl;

import com.springbootlearning.jdbc.dao.AccountDao;
import com.springbootlearning.jdbc.entity.Account;
import com.springbootlearning.jdbc.service.AccountService;
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
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public Account selectAccountById(int id) {
        return accountDao.selectAccountById(id);
    }

    @Override
    public List<Account> selectAccountList() {
        return accountDao.selectAccountList();
    }
}
