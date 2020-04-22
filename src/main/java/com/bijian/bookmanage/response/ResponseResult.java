package com.bijian.bookmanage.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
@Data
@ToString
public class ResponseResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public ResponseResult() {
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult success(T data) {
        return new ResponseResult(200, "成功", data);
    }

    public ResponseResult error() {
        return new ResponseResult(9999, "失败", null);
    }
}
