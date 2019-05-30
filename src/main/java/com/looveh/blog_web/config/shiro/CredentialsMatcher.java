package com.looveh.blog_web.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Author：looveh
 * Date：2019/5/30
 * Desc: 自定义密码比较器
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());//用户输入的密码
        String dbPassword = (String) info.getCredentials();//数据库的密码
        //对比两个面膜
        return password.equals(dbPassword);
    }
}
