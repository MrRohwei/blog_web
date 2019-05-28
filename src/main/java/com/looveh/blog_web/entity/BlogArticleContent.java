package com.looveh.blog_web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * Author：looveh
 * Date：2019/5/28
 * Desc: This is Class
 */
@Data
@ToString
@EqualsAndHashCode
public class BlogArticleContent {

    private Integer id;

    /**
     * 文章正文
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;
}
