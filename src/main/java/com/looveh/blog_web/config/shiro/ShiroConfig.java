//package com.looveh.blog_web.config.shiro;
//
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * Author：looveh
// * Date：2019/5/29
// * Desc: shiro 权限
// */
//@Configuration
//public class ShiroConfig {
//
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        shiroFilterFactoryBean.setLoginUrl("/loginPage");//登录页面/user
//        shiroFilterFactoryBean.setSuccessUrl("/index");//登录成功跳转页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");//未授权
//
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//
//        //匿名访问
//        filterChainDefinitionMap.put("/css/**", "anon");
//        filterChainDefinitionMap.put("/js/**", "anon");
//        filterChainDefinitionMap.put("/images/**", "anon");
//        filterChainDefinitionMap.put("/getVerifyCode", "anon");///user
//        filterChainDefinitionMap.put("/loginSubmit", "anon");///user
//        filterChainDefinitionMap.put("/forgotPassword", "anon");//忘记密码页面/user
//        filterChainDefinitionMap.put("/logout", "logout");
//        filterChainDefinitionMap.put("/loginPage", "anon");
//
//        filterChainDefinitionMap.put("/**", "authc");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 配置核心安全事务管理器
//     * @return
//     */
//    @Bean
//    public SecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(shiroRealm());
//        return securityManager;
//    }
//
//    /**
//     * 自定义权限登录器
//     * @return
//     */
//    @Bean
//    public ShiroRealm shiroRealm(){
//        ShiroRealm shiroRealm = new ShiroRealm();
//        shiroRealm.setCredentialsMatcher(credentialsMatcher());
//        return shiroRealm;
//    }
//
//    /**
//     * 配置自定义密码比较器
//     * @return
//     */
//    @Bean
//    public CredentialsMatcher credentialsMatcher(){
//        return new CredentialsMatcher();
//    }
//}
