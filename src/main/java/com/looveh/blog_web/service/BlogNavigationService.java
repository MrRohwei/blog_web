package com.looveh.blog_web.service;

import com.looveh.blog_web.entity.BlogNavigation;

import java.util.List;

/**
 * Author：looveh
 * Date：2019/5/30
 * Desc: 导航栏service
 */
public interface BlogNavigationService {

    /**
     * 新增导航栏
     * @param blogNavigation
     * @return
     */
    int addNavigation(BlogNavigation blogNavigation);

    /**
     * 编辑导航栏
     * @param blogNavigation
     * @return
     */
    int editNavigation(BlogNavigation blogNavigation);

    /**
     * 修改状态 上线、下线
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Integer id, Integer status);

    /**
     * 导航栏列表
     * @param blogNavigation
     * @return
     */
    List<BlogNavigation> findList(BlogNavigation blogNavigation);

    /**
     * 根据id查询导航栏
     * @param id
     * @return
     */
    BlogNavigation findById(Integer id);
}
