package com.looveh.blog_web.response;

import com.looveh.blog_web.distic.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author Looveh
 * @Date 2019/5/18/018 15:09
 * @Version 1.0
 * @Desc TODO
 **/
@Data
@ToString
@EqualsAndHashCode
public class Response<T> {

    private int code;
    private String msg;
    private T data;

    private Response(int code) {
        this.code = code;
    }

    private Response(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response(ResponseCode.SUCCESS.getKey(), data);
    }

    public static Response fail() {
        return new Response(ResponseCode.FAIL.getKey(), ResponseCode.FAIL.getValue());
    }

    public static Response fail(String msg) {
        return new Response(ResponseCode.FAIL.getKey(), msg);
    }

    public Response fail(int code, String msg) {
        return new Response(code, msg);
    }
}
