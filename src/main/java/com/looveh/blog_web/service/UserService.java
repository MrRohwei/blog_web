package com.looveh.blog_web.service;

import com.looveh.blog_web.entity.BlogUser;

import java.util.List;

/**
 * @Author Looveh
 * @Date 2019/5/18/018 15:00
 * @Version 1.0
 * @Desc TODO
 **/
public interface UserService {

    BlogUser findById(Integer id);

    List<BlogUser> findByTUser(BlogUser user);

    int createUser(BlogUser user);

    int updateUser(BlogUser user);

    int deleteUser(Integer id);

    BlogUser findByUserName(String userName);
}
