package com.springbootlearning.beatsql.dao;

import com.springbootlearning.beatsql.entity.Account;
import org.beetl.sql.core.annotatoin.SqlStatement;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoyanhai
 * @date 2019-10-01
 */
@Repository
public interface AccountDao extends BaseMapper<Account> {

    @SqlStatement(params = "name")
    Account selectAccountByName(String name);
}
