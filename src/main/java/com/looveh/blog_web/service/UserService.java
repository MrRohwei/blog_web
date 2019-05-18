package com.looveh.blog_web.service;

import com.looveh.blog_web.entity.TUser;

import java.util.List;

/**
 * @Author Looveh
 * @Date 2019/5/18/018 15:00
 * @Version 1.0
 * @Desc TODO
 **/
public interface UserService {

    TUser findById(Integer id);

    List<TUser> findByTUser(TUser user);

    int createUser(TUser user);

    int updateUser(TUser user);

    int deleteUser(Integer id);
}
