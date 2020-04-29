package com.bijian.bookmanage.response;

import com.bijian.bookmanage.domain.Book;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/23
 * @Content:    按照类别分组图书列表
 */
@Data
@ToString
public class BookList implements Serializable {

    // 类别分组图书总数
    private List<Book> books;

    // 该类别下的图书总数
    private int totalCount;
}
