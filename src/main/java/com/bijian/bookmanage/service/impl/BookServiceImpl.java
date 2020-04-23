package com.bijian.bookmanage.service.impl;

import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.mapper.BookMapper;
import com.bijian.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/22
 * @Content:
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Boolean addBook(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean modifyBook(Book book) {
        return null;
    }

    @Override
    public Boolean deleteBook(Integer id) {
        return null;
    }
}
