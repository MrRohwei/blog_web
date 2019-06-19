package com.looveh.blog_web.config.shiro;

import com.looveh.blog_web.entity.BlogUser;
import com.looveh.blog_web.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author：looveh
 * Date：2019/5/29
 * Desc: This is Class
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 获取用户角色和权限
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 登录认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        BlogUser blogUser = userService.findByUserName(userName);
        if (blogUser == null) {
            throw new UnknownAccountException("用户名或密码错误");
        }
        if (!password.equalsIgnoreCase(blogUser.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误");
        }
        if (blogUser.getStatus() != "1") {
            throw new LockedAccountException("用户被锁定，请联系管理员");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, password, getName());
        return info;
    }
}
