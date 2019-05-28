package com.looveh.blog_web.controller;

import com.looveh.blog_web.annotation.OperateLog;
import com.looveh.blog_web.entity.BlogNavigation;
import com.looveh.blog_web.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author：looveh
 * Date：2019/5/28
 * Desc: 导航栏
 */
@RequestMapping("/blogNavigation")
@Controller
public class BlogNavigationController {

    @RequestMapping("/add")
    @ResponseBody
    @OperateLog("新增导航栏")
    public Response add(BlogNavigation blogNavigation){

        return Response.fail();
    }

    @RequestMapping("/update")
    @ResponseBody
    @OperateLog("修改导航栏")
    public Response update(BlogNavigation blogNavigation){

        return Response.fail();
    }

    @RequestMapping("/getById")
    @ResponseBody
    @OperateLog("获取导航栏")
    public Response getById(Integer id){

        return Response.fail();
    }

    @RequestMapping("/getList")
    @ResponseBody
    @OperateLog("获取导航栏列表")
    public Response getList(BlogNavigation blogNavigation){

        return Response.fail();
    }

}
