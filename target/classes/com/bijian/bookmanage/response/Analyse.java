package com.bijian.bookmanage.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/23
 * @Content:    图书分析响应对象
 */
@Data
@ToString
public class Analyse implements Serializable {

    // 图书总数
    private int totalCount;

    // 总价格
    private BigDecimal totalAmount;

    // 最贵的图书名称
    private String mostExpensiveName;

    // 最早出版的图书名称
    private String earliestName;
}
