package com.looveh.blog_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author：looveh
 * Date：2019/5/30
 * Desc: 博客
 */
@Controller
public class BlogController {

    @RequestMapping("/blogManager")
    public String blogManager(){
        return "news/newsList";
    }
}
