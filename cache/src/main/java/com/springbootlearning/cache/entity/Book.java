package com.springbootlearning.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhaoyanhai
 * 2019-10-02
 */

@Data
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;

    @Override
    public String toString() {
        return "Book{" + "isbn='" + isbn + '\'' + ", title='" + title + '\'' + '}';
    }
}
