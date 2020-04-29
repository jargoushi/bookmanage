package com.bijian.bookmanage.controller;

import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.response.ResponseResult;
import com.bijian.bookmanage.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/22
 * @Content:
 */
@ApiOperation("巡检人员管理")
@RequestMapping("/bookmanage")
@Controller
@CrossOrigin
public class BookManageController {

    private static final Logger logger = LoggerFactory.getLogger(BookManageController.class);

    @Autowired
    private BookService bookService;

    @ApiOperation("新增图书")
    @PostMapping("/addBook")
    @ResponseBody
    public ResponseResult<Boolean> addBook(Book book) {
        logger.info("新增图书 start, book=【{}】", book);
        try {
            Boolean flag = bookService.addBook(book);
            logger.info("新增图书 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("新增图书 error", e);
            return new ResponseResult().error();
        }
    }

    @ApiOperation("修改图书")
    @PostMapping("/modify")
    @ResponseBody
    public ResponseResult<Boolean> modifyBook(Book book) {
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
    @ResponseBody
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

    @ApiOperation("查询图书列表")
    @GetMapping("/list")
    @ResponseBody
    public ResponseResult<List<Book>> queryBookList() {
        logger.info("查询图书列表 start");
        try {
            List<Book> books = bookService.queryBookList();
            logger.info("查询图书列表 success, 响应结果=【{}】", books);
            Map<String, Object> map = new HashMap<>();
            map.put("data", books);
            if (books == null || books.size() == 0) {
                map.put("totalNum", 0);
            } else {
                map.put("totalNum", books.size());
            }
            return new ResponseResult().success(map);
        } catch (Exception e) {
            logger.info("查询图书列表 error", e);
            return new ResponseResult().error();
        }
    }

    @ApiOperation("携带图书信息跳转修改页")
    @GetMapping("/toModifyView/{id}")
    public String toModifyView(@PathVariable Integer id, Model model) {
        logger.info("携带图书信息跳转修改页 start");
        try {
            Book book = bookService.queryBookById(id);
            model.addAttribute("book", book);
            logger.info("携带图书信息跳转修改页 success, 响应结果=【{}】", book);

        } catch (Exception e) {
            logger.info("携带图书信息跳转修改页 error", e);
            model.addAttribute("book", null);
        }
        return "/admin/user/form";
    }

    @ApiOperation("跳转新增图书页面")
    @GetMapping("/toAddView")
    public String toAddView() {
        return "/admin/user/add";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
