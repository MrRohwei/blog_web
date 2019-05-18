package com.looveh.blog_web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class TUser {
    private Integer id;

    private String username;

    private String password;

    private Integer sex;

    private String imgpath;

    private String mobile;

    private String email;

    private Boolean status;

    private String description;

    private String intro;

    private Date createtime;

    private Date updatetime;

    private Boolean isdeleted;

    private Date deletetime;

}