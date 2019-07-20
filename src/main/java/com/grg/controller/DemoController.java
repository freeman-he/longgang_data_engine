package com.grg.controller;

import com.google.gson.Gson;
import com.grg.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/o")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);
    private static Gson gson = new Gson();

    @Autowired
    private BookService bookService;

    @RequestMapping("/getBook/{id}")
    String bookInfo(@PathVariable("id") Integer id) {
        return gson.toJson(bookService.getById(id));

    }@RequestMapping("/setBook/{id}")
    String setBookInfo(@PathVariable("id") Integer id) {
        bookService.createBookAndSave();
        return gson.toJson(bookService.getById(id));
    }

}
