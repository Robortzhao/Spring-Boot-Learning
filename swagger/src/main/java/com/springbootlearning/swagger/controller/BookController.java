package com.springbootlearning.swagger.controller;


import com.springbootlearning.swagger.eneity.Book;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * @author zhaoyanhai
 * @date 2019-10-02
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());

    @ApiOperation(value = "获取图书列表", notes = "获取图书列表")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Book> getBooks() {
        List<Book> book = new ArrayList<>(books.values());
        return book;
    }

    @ApiOperation(value = "创建图书", notes = "创建图书")
    @ApiImplicitParam(name = "book", value = "图书详细实体", required = true, dataType = "Book")
    @RequestMapping(value = "/postBook", method = RequestMethod.POST)
    public String postBook(@RequestBody Book book) {
        books.put(book.getId(), book);
        return "success!";
    }

    @ApiOperation(value = "获取图书详细信息", notes = "根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value = "/getBook", method = RequestMethod.GET)
    public Book getBook(@RequestParam(value = "id") Long id) {
        return books.get(id);
    }

    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新图书信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "book", value = "图书实体book", required = true, dataType = "Book")
    })
    @RequestMapping(value = "/updateBook", method = RequestMethod.PUT)
    public String updateBook(@RequestParam(value = "id") Long id, @RequestBody Book book) {
        Book bookTemp = books.get(id);
        bookTemp.setName(book.getName());
        bookTemp.setPrice(book.getPrice());
        books.put(id, bookTemp);
        return "success";
    }

    @ApiOperation(value = "删除图书", notes = "根据url的id来指定删除图书")
    @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long")
    @RequestMapping(value = "/deleteBook", method = RequestMethod.DELETE)
    public String deleteBook(@RequestParam(value = "id") Long id) {
        books.remove(id);
        return "success";
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String jsonTest() {
        return " hi you!";
    }


}
