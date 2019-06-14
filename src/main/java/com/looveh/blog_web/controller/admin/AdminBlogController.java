package com.looveh.blog_web.controller.admin;

import com.looveh.blog_web.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Looveh
 * @Date 2019/6/14/014 11:53
 * @Version 1.0
 * @Desc 后台管理博客管理
 **/
@Controller
public class AdminBlogController {

    @RequestMapping("blogList")
    @ResponseBody
    public Response blogList(String name){

        return Response.success();
    }
}
