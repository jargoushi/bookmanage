package com.bijian.bookmanage.domain;

import lombok.Data;
import lombok.ToString;

/**
 * 目录
 */
@Data
@ToString
public class Contents {
    private Integer id;

    private Integer bookId;

    private String name;
}