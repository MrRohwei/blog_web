package com.looveh.blog_web.entity;

import com.looveh.blog_web.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Blogs extends PageDto {
    private Integer id;

    private String title;

    private String status;

    private Integer userId;

    private String author;

    private Integer likeNum;

    private Integer commentNum;

    private Integer lookNum;

    private Date createdTime;

    private Date deletedTime;

    private String content;


}