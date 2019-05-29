package com.looveh.blog_web.controller;

import com.looveh.blog_web.annotation.OperateLog;
import com.looveh.blog_web.distic.CommonConstant;
import com.looveh.blog_web.entity.BlogUser;
import com.looveh.blog_web.response.Response;
import com.looveh.blog_web.service.UserService;
import com.looveh.blog_web.utils.MD5Utils;
import com.looveh.blog_web.utils.VerifyCodeUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    @ResponseBody
    public Response register(BlogUser blogUser) {
        return Response.fail("aaaa");
    }

    @RequestMapping("/loginSubmit")
    @OperateLog(value = "登录接口", desc = CommonConstant.LOGIN_IN, userType = CommonConstant.USERTYPE_ADMIN)
    @ResponseBody
    public Response<Boolean> login(HttpServletRequest request, String username, String password, String verifyCode) {
//        log.info("登录参数：username={},password={},verifyCode={}", username, password,verifyCode);
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Response.fail("用户名或密码为空");
        }
        if(StringUtils.isBlank(verifyCode)){
            return Response.fail("请输入验证码");
        }
        if (!checkVerifyCode(request, verifyCode)) {
            return Response.fail("验证码错误");
        }

        password = MD5Utils.encrypt(password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return Response.success(true);
        } catch (UnknownAccountException e){
            return Response.fail(e.getMessage());
        }  catch (IncorrectCredentialsException e) {
            return Response.fail(e.getMessage());
        } catch (LockedAccountException e) {
            return Response.fail(e.getMessage());
        } catch (AuthenticationException e) {
            return Response.fail("认证失败！");
        }
    }

    private boolean checkVerifyCode(HttpServletRequest request, String verifyCode) {
        HttpSession session = request.getSession();
        String sessionVerify = (String) session.getAttribute(VerifyCodeUtil.VERIFY_SESSION_KEY);
        if(verifyCode.equalsIgnoreCase(sessionVerify)){
            return true;
        }
        return false;
    }

    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("image/jpeg");//设置相应类型，告诉浏览器这是图片
            response.setHeader("Pragma", "no-cache");//设置相应头，告诉浏览器不要缓存
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            VerifyCodeUtil util = new VerifyCodeUtil();
            util.getRandomCode(request, response);
        } catch (Exception e){
            log.error("获取验证码失败>>>>{}", e);
        }
    }

    /**
     * 忘记密码
     * @return
     */
    @RequestMapping("/forgotPassword")
    public String forgotPassword(){
        return "updatePassword";
    }
}
