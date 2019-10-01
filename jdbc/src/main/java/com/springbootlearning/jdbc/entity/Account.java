package com.springbootlearning.jdbc.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoyanhai
 * @date 2019-10-01
 */
@Data
public class Account {
    private int id;
    private String name;
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
