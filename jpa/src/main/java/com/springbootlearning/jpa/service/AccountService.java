package com.springbootlearning.jpa.service;

import com.springbootlearning.jpa.entity.Account;

import java.util.List;

/**
 * @author zhaoyanhai
 * @date 2019-10-01
 */
public interface AccountService {

    Account add(Account account);

    Account update(Account account);

    void delete(int id);

    Account selectAccountById(int id);

    List<Account> selectAccountList();
}

