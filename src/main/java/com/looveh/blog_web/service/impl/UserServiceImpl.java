package com.looveh.blog_web.service.impl;

import com.looveh.blog_web.dao.BlogUserMapper;
import com.looveh.blog_web.entity.BlogUser;
import com.looveh.blog_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Looveh
 * @Date 2019/5/18/018 15:00
 * @Version 1.0
 * @Desc TODO
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<BlogUser> findByTUser(BlogUser user) {
        return null;
    }

    @Override
    public int createUser(BlogUser user) {
        return 0;
    }

    @Override
    public int updateUser(BlogUser user) {
        return 0;
    }

    @Override
    public int deleteUser(Integer id) {
        return 0;
    }

    @Override
    public BlogUser findByUserName(String userName) {
        return null;
    }

    @Autowired
    BlogUserMapper blogUserMapper;

    @Override
    public BlogUser findById(Integer id) {
        return blogUserMapper.selectByPrimaryKey(id);
    }
}