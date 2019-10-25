package com.springbootlearning.starter.springbootlearning;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhaoyanhai
 * @description TODO
 * @date 2019/10/25
 **/
@ConfigurationProperties(prefix = "springbootlearning.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
