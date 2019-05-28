package com.looveh.blog_web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class BlogPersonalInfo {
    private Integer id;

    private String name;

    private Integer age;

    private Boolean sex;

    private Date birthday;

    private String wechat;

    private String qq;

    private String intro;

    private String address;

    private Date createTime;

}