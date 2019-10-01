package com.springbootlearning.jpa.dao;

import com.springbootlearning.jpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhaoyanhai
 * @date 2019-10-01
 */
public interface AccountDao extends JpaRepository<Account, Integer> {

}
