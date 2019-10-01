package com.springbootlearning.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author zhaoyanhai
 * @date 2019-10-01
 */
@Data
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Account implements Serializable {
    @Id
    @GeneratedValue
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
