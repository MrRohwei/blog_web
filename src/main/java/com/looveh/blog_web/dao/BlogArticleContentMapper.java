package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogArticleContent;

/**
 * Author：looveh
 * Date：2019/5/28
 * Desc: This is Interface
 */
public interface BlogArticleContentMapper {

    int delete(Integer id);

    int insert(BlogArticleContent blogArticleContent);

    int insertDynamic(BlogArticleContent blogArticleContent);

    int updateDynamic(BlogArticleContent blogArticleContent);

    int update(BlogArticleContent blogArticleContent);

    BlogArticleContent selectById(Integer id);

}
