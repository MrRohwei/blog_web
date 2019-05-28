package com.looveh.blog_web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class BlogArticles {
    private Integer id;

    private String title;

    private String tagIds;

    private Integer userId;

    private Integer articleId;

    private Date createTime;

    private Boolean isDeleted;

    private Date deletedTime;

}