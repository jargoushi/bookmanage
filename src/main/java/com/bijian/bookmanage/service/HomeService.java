package com.bijian.bookmanage.service;

import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.response.Analyse;
import com.bijian.bookmanage.response.BookList;

import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/23
 * @Content:
 */
public interface HomeService {

    /**
     * 图书分析
     * @return
     */
    Analyse analyse();

    /**
     * 按照类目分组查询图书列表
     * @return
     */
    List<BookList> getBookListGroupCategory();

    /**
     * 根据类目名称查询图书列表
     * @param categoryName
     * @return
     */
    List<Book> getBookListByCategoryName(String categoryName);

    /**
     * 根据图书标题查询图书详情
     * @param title
     * @return
     */
    Book getBookByTitle(String title);

    /**
     * 按照出版社分组查询图书列表
     * @return
     */
    List<BookList> getBookListGroupPress();

    /**
     * 根据图书名称模糊匹配查询图书列表
     * @param title
     * @return
     */
    List<Book> getBookListMatchingTitle(String title);
}
