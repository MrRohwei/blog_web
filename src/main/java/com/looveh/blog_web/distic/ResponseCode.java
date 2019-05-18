package com.looveh.blog_web.distic;

import lombok.Data;

/**
 * @Author Looveh
 * @Date 2019/5/18/018 15:17
 * @Version 1.0
 * @Desc 响应码
 **/
public enum ResponseCode {

    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    SERVER_ERROR(500, "服务器异常"),
    SYSTEM_ERROR(707, "系统异常"),
    INTERNET_ERROR(10000, "网络异常"),
    ;

    private int key;
    private String value;

    private ResponseCode(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }
}
