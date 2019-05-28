package com.looveh.blog_web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class BlogNavigation {

    private Integer id;

    private String title;

    private Integer orderNum;

    private Integer status;

    private Date createTime;

    private Boolean isDeleted;

    private Date deletedTime;

}