package com.bijian.bookmanage.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.domain.Contents;
import com.bijian.bookmanage.mapper.BookMapper;
import com.bijian.bookmanage.mapper.ContentsMapper;
import com.bijian.bookmanage.response.Analyse;
import com.bijian.bookmanage.response.BookList;
import com.bijian.bookmanage.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    @Autowired
    private ContentsMapper contentsMapper;

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
    public JSONArray getBookListGroupCategory() {
        JSONArray jsonArray = new JSONArray();
        List<String> categorys = bookMapper.groupByCategory();
        categorys.forEach(category -> {
            JSONObject jsonObject = new JSONObject();
            List<Book> books = bookMapper.queryBooksByCategory(category);
            if (books == null || books.size() == 0) {
                return;
            }
            jsonObject.put(category, books);
            jsonArray.add(jsonObject);
        });

        return jsonArray;
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
    public JSONArray getBookListGroupPress() {
        JSONArray jsonArray = new JSONArray();
        List<String> presss = bookMapper.groupByPress();
        presss.forEach(press -> {
            JSONObject jsonObject = new JSONObject();
            List<Book> books = bookMapper.queryBooksByPress(press);
            if (books == null || books.size() == 0) {
                return;
            }
            jsonObject.put(press, books);
            jsonArray.add(jsonObject);
        });

        return jsonArray;
    }

    @Override
    public List<Book> getBookListMatchingTitle(String title) {
        return bookMapper.getBookListMatchingTitle(title);
    }

    @Override
    public Contents getBookContentNamesByBookId(String bookId) {
        return contentsMapper.selectByBookId(bookId);
    }
}
