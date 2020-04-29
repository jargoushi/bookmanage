package com.bijian.bookmanage.service.impl;

import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.domain.Contents;
import com.bijian.bookmanage.mapper.BookMapper;
import com.bijian.bookmanage.mapper.ContentsMapper;
import com.bijian.bookmanage.service.BookService;
import com.bijian.bookmanage.service.FileService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private ContentsMapper contentsMapper;

    @Autowired
    private FileService fileService;


    @Override
    public Boolean addBook(Book book) {
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        int insertFlag = 0;
        // 上传图片到OSS
        String path = fileService.upload(book.getImgFile());
        book.setPath(path);
        if ((insertFlag = bookMapper.insert(book)) > 0) {
            // 插入目录表
            Contents contents = new Contents();
            contents.setBookId(book.getId());
            contents.setName(book.getContentNames());
            insertFlag = contentsMapper.insert(contents);
        }
        return insertFlag > 0;
    }

    @Override
    public Boolean modifyBook(Book book) {
        book.setUpdateTime(new Date());
        return bookMapper.updateByPrimaryKey(book) > 0;
    }

    @Override
    public Boolean deleteBook(Integer id) {
        return bookMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Book> queryBookList() {
        return bookMapper.selectAll();
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }
}
