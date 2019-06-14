package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogSiteInfo;

public interface BlogSiteInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BlogSiteInfo record);

    int insertSelective(BlogSiteInfo record);

    BlogSiteInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogSiteInfo record);

    int updateByPrimaryKeyWithBLOBs(BlogSiteInfo record);

    int updateByPrimaryKey(BlogSiteInfo record);
}