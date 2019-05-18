package com.looveh.blog_web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogWebApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {

        String sql = "select * from t_user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        System.out.println(maps);
    }

}
