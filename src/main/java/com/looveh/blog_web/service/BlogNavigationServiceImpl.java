package com.looveh.blog_web.service;

import com.looveh.blog_web.dao.BlogNavigationMapper;
import com.looveh.blog_web.entity.BlogNavigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author：looveh
 * Date：2019/5/30
 * Desc: This is Class
 */
@Service
public class BlogNavigationServiceImpl implements BlogNavigationService {

    @Autowired
    BlogNavigationMapper blogNavigationMapper;

    @Override
    public int addNavigation(BlogNavigation blogNavigation) {
        return blogNavigationMapper.insert(blogNavigation);
    }

    @Override
    public int editNavigation(BlogNavigation blogNavigation) {
        return blogNavigationMapper.update(blogNavigation);
    }

    @Override
    public int updateStatus(Integer id, Integer status) {
        BlogNavigation blogNavigation = new BlogNavigation();
        blogNavigation.setId(id);
        blogNavigation.setStatus(status);
        return blogNavigationMapper.update(blogNavigation);
    }

    @Override
    public List<BlogNavigation> findList(BlogNavigation blogNavigation) {
        return blogNavigationMapper.selectList(blogNavigation);
    }

    @Override
    public BlogNavigation findById(Integer id) {
        return blogNavigationMapper.selectById(id);
    }
}
