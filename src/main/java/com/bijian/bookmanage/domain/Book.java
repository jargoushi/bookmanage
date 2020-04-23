package com.bijian.bookmanage.domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 图书
 */
@Data
@ToString
public class Book {
    private Integer id;

    private String title;

    private String path;

    private String press;

    private BigDecimal score;

    private String author;

    private String category;

    private String price;

    private Date publisTime;

    private String content;

    private String remarks;

    private Date createTime;

    private Date updateTime;
}