package com.springbootlearning.cache.dao;


import com.springbootlearning.cache.entity.Book;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoyanhai
 * 2019-10-02
 */

@Repository
public interface BookRepository {
    Book getByIsbn(String isbn);
}
