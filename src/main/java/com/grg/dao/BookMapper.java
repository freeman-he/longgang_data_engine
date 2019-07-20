package com.grg.dao;

import com.grg.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
// 该注解为解决IDEA mapper注入时出现"could not autowired, no beans of 'bookMapper' found"
@Component("bookMapper")
public interface BookMapper {

    int insert(Book record);

    int selectMaxId();

    List<Book> selectAll();

    Book getById(@Param(value = "id") Integer id);
}
