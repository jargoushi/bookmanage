package com.bijian.bookmanage.service;

import com.bijian.bookmanage.domain.Book;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/22
 * @Content:
 */
public interface BookService {
    Boolean addBook(Book book, MultipartFile file, String contentNames);

    Boolean modifyBook(Book book);

    Boolean deleteBook(Integer id);
}
