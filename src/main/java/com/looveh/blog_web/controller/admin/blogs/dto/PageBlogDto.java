package com.looveh.blog_web.controller.admin.blogs.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @Author Looveh
 * @Date 2019/6/14/014 18:08
 * @Version 1.0
 * @Desc TODO
 **/
@Data
@ToString
@EqualsAndHashCode
public class PageBlogDto {

    List<BlogListDto> blogListDtos;

    private Long total;


}
