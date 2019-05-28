package com.looveh.blog_web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class BlogImg {

    private Integer id;

    private String imgUrl;

    private Integer type;

    private String imgDesc;

    private Date createTime;

    private Boolean isDeleted;

    private Date deletedTime;

}