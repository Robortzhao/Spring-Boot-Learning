package com.springbootlearning.uploadfile.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhaoyanhai
 * @description 设置文件存储位置
 * @date 2019/10/3
 **/

@ConfigurationProperties("storage")
public class StorageProperties {

    private String location = "upload-dir";


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
