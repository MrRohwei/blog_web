//package com.looveh.blog_web.controller.admin;
//
//import com.looveh.blog_web.annotation.OperateLog;
//import com.looveh.blog_web.distic.CommonConstant;
//import com.looveh.blog_web.response.Response;
//import com.looveh.blog_web.utils.MD5Utils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.subject.Subject;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * Author：looveh
// * Date：2019/5/28
// * Desc: This is Class
// */
//@Controller
//@RequestMapping
//public class LoginController {
//
//    @RequestMapping("/loginPage")
//    public String login(){
//        return "login";
//    }
//
//
//    @RequestMapping("/loginSubmit")
//    @ResponseBody
//    @OperateLog(value = "登录接口", desc = CommonConstant.LOGIN_IN, userType = CommonConstant.USERTYPE_ADMIN)
//    public Response login(String username,String password){
//
//        password = MD5Utils.encrypt(password);
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(token);
//            return Response.success();
//        } catch (UnknownAccountException e){
//            return Response.fail(e.getMessage());
//        }  catch (IncorrectCredentialsException e) {
//            return Response.fail(e.getMessage());
//        } catch (LockedAccountException e) {
//            return Response.fail(e.getMessage());
//        } catch (AuthenticationException e) {
//            return Response.fail("认证失败！");
//        }
//    }
//}
