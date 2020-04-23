package com.bijian.bookmanage.service;

import com.alibaba.fastjson.JSONArray;
import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.domain.Contents;
import com.bijian.bookmanage.response.Analyse;
import com.bijian.bookmanage.response.BookList;

import java.util.List;
import java.util.Map;

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
    JSONArray getBookListGroupCategory();

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
    JSONArray getBookListGroupPress();

    /**
     * 根据图书名称模糊匹配查询图书列表
     * @param title
     * @return
     */
    List<Book> getBookListMatchingTitle(String title);

    /**
     * 根据图书id查询图书目录
     * @param bookId
     * @return
     */
    Contents getBookContentNamesByBookId(String bookId);
}
