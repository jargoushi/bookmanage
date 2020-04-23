package com.bijian.bookmanage.controller;

import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.response.ResponseResult;
import com.bijian.bookmanage.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/22
 * @Content:
 */
@ApiOperation("巡检人员管理")
@RestController
@RequestMapping("/bookmanage")
@CrossOrigin
public class BookManageController {

    private static final Logger logger = LoggerFactory.getLogger(BookManageController.class);

    @Autowired
    private BookService bookService;

    @ApiOperation("新增图书")
    @PostMapping("/addBook")
    public ResponseResult<Boolean> addBook(@RequestBody Book book, MultipartFile file, String contentNames) {
        logger.info("新增图书 start, book=【{}】", book);
        try {
            Boolean flag = bookService.addBook(book, file, contentNames);
            logger.info("新增图书 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("新增图书 error", e);
            return new ResponseResult().error();
        }
    }

    @ApiOperation("修改图书")
    @PostMapping("/modify")
    public ResponseResult<Boolean> modifyBook(@RequestBody Book book) {
        logger.info("修改图书 start, book=【{}】", book);
        try {
            Boolean flag = bookService.modifyBook(book);
            logger.info("修改图书 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("修改图书 error", e);
            return new ResponseResult().error();
        }
    }

    @ApiOperation("删除图书")
    @GetMapping("/delete/{Id}")
    public ResponseResult<Boolean> deleteBook(@PathVariable Integer Id) {
        logger.info("删除图书 start, id=【{}】", Id);
        try {
            Boolean flag = bookService.deleteBook(Id);
            logger.info("删除图书 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("删除图书 error", e);
            return new ResponseResult().error();
        }
    }

}
