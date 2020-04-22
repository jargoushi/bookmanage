package com.bijian.bookmanage.service;

import com.bijian.bookmanage.domain.Book;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/22
 * @Content:
 */
public interface BookService {
    Boolean addBook(Book book);

    Boolean modifyBook(Book book);

    Boolean deleteBook(Integer id);
}
