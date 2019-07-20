package com.grg.service;

import com.grg.dao.BookMapper;
import com.grg.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("bookService")
public class BookService {

    private Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {
        return bookMapper.selectAll();
    }

    @Cacheable(key="#id",value="myCache")
    public Book getById(Integer id) {
        logger.error("缓存里没有"+id+",所以这边没有走缓存，从数据库拿数据");
        return bookMapper.getById(id);
    }

    public void createBookAndSave(){
        int id = bookMapper.selectMaxId();
        Book book = new Book();
        book.setId(id+1);
        book.setName("编程珠玑"+id);
        book.setAuthor("json");
        book.setPrice(100.0);
        bookMapper.insert(book);
    }
}
