package com.looveh.blog_web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class BlogTags {

    private Integer id;

    private String name;

    private Date createTim;

    private Boolean isDeleted;

    private Date deletedTime;

}