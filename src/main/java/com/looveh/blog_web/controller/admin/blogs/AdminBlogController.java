package com.looveh.blog_web.controller.admin.blogs;

import com.alibaba.fastjson.JSONObject;
import com.looveh.blog_web.controller.admin.blogs.dto.BlogListDto;
import com.looveh.blog_web.controller.admin.blogs.dto.PageBlogDto;
import com.looveh.blog_web.distic.CommonStatus;
import com.looveh.blog_web.entity.Blogs;
import com.looveh.blog_web.response.Response;
import com.looveh.blog_web.service.BlogsService;
import com.looveh.blog_web.service.UserService;
import com.looveh.blog_web.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Looveh
 * @Date 2019/6/14/014 11:53
 * @Version 1.0
 * @Desc 后台管理博客管理
 **/
@Controller
@RequestMapping("/admin/blog")
public class AdminBlogController {

    @Autowired
    BlogsService blogsService;

    @Autowired
    UserService userService;

    /**
     * 博客列表
     * @param param
     * @return
     */
    @RequestMapping("/blogList")
    @ResponseBody
    public Response blogList(BlogListDto param) {
        PageBlogDto pageBlogDto = new PageBlogDto();
        List<BlogListDto> dtoList = new ArrayList<>();

        Blogs blogs = new Blogs();
        if (StringUtils.isNotBlank(param.getTitle())) {
            blogs.setTitle(param.getTitle());
        }
        List<Blogs> list = blogsService.findList(blogs);
        if (!CollectionUtils.isEmpty(list)) {
            for (Blogs o : list) {
                BlogListDto dto = new BlogListDto();
                BeanUtils.copyProperties(o, dto);
//                BlogUser byId = userService.findById(o.getUserId());
//                if(byId != null) {
//                    dto.setUserName(byId.getUsername());
//                }
                dto.setStatusName(CommonStatus.getByStatus(o.getStatus()).getStatusName());
                dto.setCreatedTime(DateUtil.formatDate(o.getCreatedTime()));
                dtoList.add(dto);
            }
        }
        return Response.success(dtoList);
    }

    @RequestMapping("/blogAdd")
    @ResponseBody
    public Response blogAdd(BlogListDto dto){
        System.out.println(JSONObject.toJSONString(dto));
        Blogs blogs = new Blogs();
        BeanUtils.copyProperties(dto, blogs);
        blogs.setStatus(CommonStatus.DISABLE.getStatus());
        blogs.setUserId(1);//todo 登录之后的用户
        blogs.setLikeNum(0);
        blogs.setCommentNum(0);
        blogs.setLookNum(0);
        blogs.setContent(dto.getContent().toString());
        blogs.setCreatedTime(new Date());
        Integer blogId = blogsService.createBlog(blogs);
        return Response.success(blogId);
    }
}
