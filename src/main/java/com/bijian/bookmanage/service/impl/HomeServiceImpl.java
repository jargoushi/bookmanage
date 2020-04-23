package com.bijian.bookmanage.service.impl;

import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.mapper.BookMapper;
import com.bijian.bookmanage.response.Analyse;
import com.bijian.bookmanage.response.BookList;
import com.bijian.bookmanage.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/23
 * @Content: 小程序首页展示service
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Analyse analyse() {
        // 1. 查询最贵的图书名
        String mostExpensiveName = bookMapper.queryMostExpensiveName();
        // 2. 查询最早出版的图书名
        String earliestName = bookMapper.queryEarliestName();
        // 3. 汇总图书总数及金额
        Analyse analyse = bookMapper.summaryAmountAndCount();
        analyse.setEarliestName(earliestName);
        analyse.setMostExpensiveName(mostExpensiveName);
        return analyse;
    }

    @Override
    public List<BookList> getBookListGroupCategory() {
        Map<String, List<Book>> map = bookMapper.getBookListGroupCategory();
        return null;
    }

    @Override
    public List<Book> getBookListByCategoryName(String categoryName) {
        return bookMapper.getBookListByCategoryName(categoryName);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookMapper.getBookByTitle(title);
    }

    @Override
    public List<BookList> getBookListGroupPress() {
        return null;
    }

    @Override
    public List<Book> getBookListMatchingTitle(String title) {
        return bookMapper.getBookListMatchingTitle(title);
    }
}
