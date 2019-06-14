package com.looveh.blog_web.controller.admin.blogs.dto;

import com.looveh.blog_web.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * @Author Looveh
 * @Date 2019/6/14/014 15:00
 * @Version 1.0
 * @Desc TODO
 **/
@Data
@ToString
@EqualsAndHashCode
public class BlogListDto extends PageDto {

    private Integer id;

    private String title;

    private String status;

    private Integer userId;

    private String author;

    private Integer likeNum;

    private Integer commentNum;

    private Integer lookNum;

    private Date deletedTime;

    private String content;

    private String userName;

    private String statusName;

    private String createdTime;

}
