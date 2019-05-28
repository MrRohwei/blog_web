package com.looveh.blog_web.controller.admin;

import com.looveh.blog_web.annotation.OperateLog;
import com.looveh.blog_web.distic.CommonConstant;
import com.looveh.blog_web.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author：looveh
 * Date：2019/5/28
 * Desc: This is Class
 */
@Controller
@RequestMapping
public class LoginController {


    @RequestMapping("/login")
    @ResponseBody
    @OperateLog(desc = CommonConstant.LOGIN_IN, userType = CommonConstant.USERTYPE_ADMIN)
    public Response login(String username,String password){

        return Response.fail();
    }
}
