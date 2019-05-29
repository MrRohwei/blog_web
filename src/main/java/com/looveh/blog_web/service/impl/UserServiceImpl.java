package com.looveh.blog_web.service.impl;

import com.looveh.blog_web.dao.TUserMapper;
import com.looveh.blog_web.entity.BlogUser;
import com.looveh.blog_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author Looveh
 * @Date 2019/5/18/018 15:00
 * @Version 1.0
 * @Desc TODO
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public BlogUser findById(Integer id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BlogUser> findByTUser(BlogUser user) {
        return tUserMapper.selectByTUser(user);
    }

    @Override
    public int createUser(BlogUser user) {
        return tUserMapper.insertSelective(user);
    }

    @Override
    public int updateUser(BlogUser user) {
        return tUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return tUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public BlogUser findByUserName(String userName) {
        BlogUser blogUser = new BlogUser();
        blogUser.setUsername(userName);
        List<BlogUser> blogUsers = tUserMapper.selectByTUser(blogUser);
        if(!CollectionUtils.isEmpty(blogUsers)){
            return blogUsers.get(0);
        }
        return null;
    }
}
