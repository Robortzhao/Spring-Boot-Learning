package com.springbootlearning.jdbc.dao;

import com.springbootlearning.jdbc.entity.Account;

import java.util.List;

/**
 * @author zhaoyanhai
 * @date 2019-10-01
 */

public interface AccountDao {

    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account selectAccountById(int id);

    List<Account> selectAccountList();

}
