package com.bijian.bookmanage.controller;

import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.response.Analyse;
import com.bijian.bookmanage.response.BookList;
import com.bijian.bookmanage.response.ResponseResult;
import com.bijian.bookmanage.service.HomeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/23
 * @Content:  小程序展示controller
 */
@RestController
@CrossOrigin
@ApiOperation("首页管理")
@RequestMapping("/home")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(BookManageController.class);

    @Autowired
    private HomeService homeService;

    /**
     * 图书分析
     * @return
     */
    @RequestMapping("/analyse")
    public ResponseResult<Analyse> analyse() {
        logger.info("图书分析 start");
        try {
            Analyse analyse = homeService.analyse();
            logger.info("图书分析 success, 响应结果=【{}】", analyse);
            return new ResponseResult().success(analyse);
        } catch (Exception e) {
            logger.info("图书分析 error", e);
            return new ResponseResult().error();
        }
    }

    /**
     * 按照类别分类获取图书列表
     * @return
     */
    @RequestMapping("/getBookListGroupCategory")
    public ResponseResult<List<BookList>> getBookListGroupCategory() {
        logger.info("按照类别分类获取图书列表 start");
        try {
            List<BookList> bookLists = homeService.getBookListGroupCategory();
            logger.info("按照类别分类获取图书列表 success, 响应结果=【{}】", bookLists);
            return new ResponseResult().success(bookLists);
        } catch (Exception e) {
            logger.info("按照类别分类获取图书列表 error", e);
            return new ResponseResult().error();
        }
    }

    /**
     * 根据类别名称查询图书列表
     * @return
     */
    @RequestMapping("/getBookListByCategoryName/{categoryName}")
    public ResponseResult<List<Book>> getBookListByCategoryName(@PathVariable String categoryName) {
        logger.info("根据类别名称查询图书列表 start, categoryName={}", categoryName);
        try {
            List<Book> bookLists = homeService.getBookListByCategoryName(categoryName);
            logger.info("根据类别名称查询图书列表 success, 响应结果=【{}】", bookLists);
            return new ResponseResult().success(bookLists);
        } catch (Exception e) {
            logger.info("根据类别名称查询图书列表 error", e);
            return new ResponseResult().error();
        }
    }

    /**
     * 根据图书名称获取图书详情信息
     * @return
     */
    @RequestMapping("/getBookByTitle/{title}")
    public ResponseResult<Book> getBookByTitle(@PathVariable String title) {
        logger.info("根据图书名称获取图书详情信息 start, title={}", title);
        try {
            Book book = homeService.getBookByTitle(title);
            logger.info("根据图书名称获取图书详情信息 success, 响应结果=【{}】", book);
            return new ResponseResult().success(book);
        } catch (Exception e) {
            logger.info("根据图书名称获取图书详情信息 error", e);
            return new ResponseResult().error();
        }
    }

    /**
     * 按照出版社名称分类获取图书列表
     * @return
     */
    @RequestMapping("/getBookListGroupPress")
    public ResponseResult<List<BookList>> getBookListGroupPress() {
        logger.info("按照出版社名称分类获取图书列表 start");
        try {
            List<BookList> bookLists = homeService.getBookListGroupPress();
            logger.info("按照出版社名称分类获取图书列表 success, 响应结果=【{}】", bookLists);
            return new ResponseResult().success(bookLists);
        } catch (Exception e) {
            logger.info("按照出版社名称分类获取图书列表 error", e);
            return new ResponseResult().error();
        }
    }

    /**
     * 按照图书名称模糊匹配查询图书列表
     * @param title
     * @return
     */
    @RequestMapping("/getBookListMatchingTitle/{title}")
    public ResponseResult<List<Book>> getBookListMatchingTitle(@PathVariable String title) {
        logger.info("按照图书名称模糊匹配查询图书列表 start");
        try {
            List<Book> bookLists = homeService.getBookListMatchingTitle(title);
            logger.info("按照图书名称模糊匹配查询图书列表 success, 响应结果=【{}】", bookLists);
            return new ResponseResult().success(bookLists);
        } catch (Exception e) {
            logger.info("按照图书名称模糊匹配查询图书列表 error", e);
            return new ResponseResult().error();
        }
    }
}
