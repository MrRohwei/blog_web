package com.looveh.blog_web.controller.admin;

import com.looveh.blog_web.annotation.OperateLog;
import com.looveh.blog_web.entity.BlogNavigation;
import com.looveh.blog_web.response.Response;
import com.looveh.blog_web.service.BlogNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author：looveh
 * Date：2019/5/28
 * Desc: 导航栏
 */
@RequestMapping("/blogNavigation")
@Controller
public class BlogNavigationController {

    @Autowired
    BlogNavigationService blogNavigationService;

    @RequestMapping("/add")
    @ResponseBody
    @OperateLog("新增导航栏")
    public Response add(BlogNavigation blogNavigation){
        blogNavigation.setStatus(0);
        int row = blogNavigationService.addNavigation(blogNavigation);
        if(row > 0){
            return Response.success(blogNavigation.getId());
        }
        return Response.fail();
    }

    @RequestMapping("/update")
    @ResponseBody
    @OperateLog("修改导航栏")
    public Response update(BlogNavigation blogNavigation){

        return Response.success();
    }

    @RequestMapping("/getById")
    @ResponseBody
    @OperateLog("获取导航栏")
    public Response getById(Integer id){

        return Response.success();
    }

    @RequestMapping("/getList")
    @ResponseBody
    @OperateLog("获取导航栏列表")
    public Response getList(BlogNavigation blogNavigation){
        List<BlogNavigation> blogNavigationList = blogNavigationService.findList(blogNavigation);
        return Response.success(blogNavigationList);
    }

}
