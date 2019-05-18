package com.looveh.blog_web.controller;

import com.looveh.blog_web.entity.TUser;
import com.looveh.blog_web.response.Response;
import com.looveh.blog_web.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Looveh
 * @Date 2019/5/18/018 15:04
 * @Version 1.0
 * @Desc TODO
 **/
@Controller
@RequestMapping("/user")
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "/html/index.html";
    }

    @RequestMapping("/register")
    public void register(TUser tUser) {

    }

    @RequestMapping("/login")
    @ResponseBody
    public Response login(String username, String password) {
        log.info("登录参数：username={},password={}", username, password);
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Response.fail("用户名或密码为空");
        }

        TUser user = new TUser();
        user.setUsername(username);
        user.setPassword(password);
        List<TUser> tUserList = userService.findByTUser(user);
        if (CollectionUtils.isEmpty(tUserList)) {
            return Response.fail("用户名或密码错误");
        }

        return Response.success(tUserList);
    }
}
