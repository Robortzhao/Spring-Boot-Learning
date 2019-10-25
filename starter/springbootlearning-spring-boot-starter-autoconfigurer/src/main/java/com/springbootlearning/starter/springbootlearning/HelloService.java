package com.springbootlearning.starter.springbootlearning;

/**
 * @author zhaoyanhai
 * @description TODO
 * @date 2019/10/25
 **/

public class HelloService {

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    HelloProperties helloProperties;

    public String sayHelloSpringBootLearnig(String name) {
        return helloProperties.getPrefix() + "-" + name + "-" + helloProperties.getSuffix();
    }
}
