package com.springbootlearning.mybatis.entity;


import lombok.Data;

/**
 * @author zhaoyanhai
 * @date 2019-10-02
 */
@Data
public class Account {

    private int id ;
    private String name ;
    private double money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
