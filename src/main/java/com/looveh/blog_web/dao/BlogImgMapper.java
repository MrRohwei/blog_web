package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogImgMapper {

    int insert(BlogImg record);

    int insertSelective(BlogImg record);

}