package com.springbootlearning.uploadfile.storage;

/**
 * @author zhaoyanhai
 * @description 设置上传文件失败时自定义异常
 * @date 2019/10/3
 **/

public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
