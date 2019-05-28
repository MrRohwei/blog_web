package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogArticleImg;

/**
 * Author：looveh
 * Date：2019/5/28
 * Desc: This is Interface
 */
public interface BlogArticleImgMapper {

    int delete(Integer id);

    int insert(BlogArticleImg blogArticleImg);

    int insertDynamic(BlogArticleImg blogArticleImg);

    int updateDynamic(BlogArticleImg blogArticleImg);

    int update(BlogArticleImg blogArticleImg);

    BlogArticleImg selectById(Integer id);

}
