package com.springbootlearning.uploadfile.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

/**
 * @author zhaoyanhai
 * @description 上传文件接口StorageService的实现类
 * @date 2019/10/3
 **/
@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    /**
     * @return void
     * @throws StorageException
     * @Description 初始化文件路径/创建文件保存的位置
     * @author zhaoyanhai
     * @date 2019/10/3
     **/
    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    /**
     * @param file
     * @return void
     * @throws StorageException
     * @Description 保存文件file到指定的路径
     * @author zhaoyanhai
     * @date 2019/10/3
     **/
    @Override
    public void store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to storage empty file " + fileName);
            }
            if (fileName.contains("..")) {
                throw new StorageException("Cannot store file with relative path outside current directory" + fileName);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    /**
     * @return java.util.stream.Stream<java.nio.file.Path>
     * @throws StorageException
     * @Description 获取所有的文件
     * @author zhaoyanhai
     * @date 2019/10/3
     **/
    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files!", e);
        }
    }

    /**
     * @param filename
     * @return java.nio.file.Path
     * @throws
     * @Description 加载指定文件名的文件
     * @author zhaoyanhai
     * @date 2019/10/3
     **/
    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    /**
     * @param filename
     * @return org.springframework.core.io.Resource
     * @throws StorageFileNotFoundException
     * @Description 加载指定文件名的文件作为资源
     * @author zhaoyanhai
     * @date 2019/10/3
     **/
    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file:" + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    /**
     * @return void
     * @throws
     * @Description 删除所有的文件
     * @author zhaoyanhai
     * @date 2019/10/3
     **/
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
