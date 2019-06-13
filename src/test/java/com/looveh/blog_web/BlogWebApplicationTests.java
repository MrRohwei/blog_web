package com.looveh.blog_web;

import com.looveh.blog_web.entity.BlogNavigation;
import com.looveh.blog_web.service.BlogNavigationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogWebApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BlogNavigationService blogNavigationService;

    @Test
    public void contextLoads() {

//        String sql = "select * from t_user";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//
//        System.out.println(maps);
    }

    @Test
    public void testNavigation(){
        BlogNavigation navigation = new BlogNavigation();
        navigation.setTitle("首页");
        navigation.setOrderNum(1);
        navigation.setStatus(0);
        blogNavigationService.addNavigation(navigation);
    }

}
