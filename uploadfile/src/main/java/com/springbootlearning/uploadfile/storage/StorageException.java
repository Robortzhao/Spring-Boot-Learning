package com.springbootlearning.uploadfile.storage;

/**
 * @author zhaoyanhai
 * @description 设置文件存储自定义异常信息
 * @date 2019/10/3
 **/

public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
