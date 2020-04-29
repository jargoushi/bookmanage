package com.bijian.bookmanage.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
@Data
@ToString
public class PageBaseInfo<T> {

    //当前页
    private long page;

    //总记录数
    private long totalNum;

    //总页数
    private long totalPage;

    //反馈信息
    private List<T> data;


    public PageBaseInfo(long page, long totalNum, long totalPage, List<T> data) {
        this.page = page;//当前页
        this.data = data;//查询记录
        this.totalNum = totalNum;//总记录数
        this.totalPage = totalPage;//总页数
    }

}
