package com.springbootlearning.mybatis.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoyanhai
 * @date 2019-10-02
 */
@Repository
public interface AccountMapperTx {

    int update(@Param("money") double money, @Param("id") int  id);

}
