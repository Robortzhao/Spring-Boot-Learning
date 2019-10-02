package com.springbootlearning.asynchronous.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Description 用于接收restTemplate请求返回的参数
 * @Author zhaoyanhai
 * @Date 2019/10/3
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String blog;

    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }
}
