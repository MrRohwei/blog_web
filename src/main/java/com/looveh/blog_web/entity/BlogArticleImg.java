package com.looveh.blog_web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Author：looveh
 * Date：2019/5/28
 * Desc: This is Class
 */
@Data
@ToString
@EqualsAndHashCode
public class BlogArticleImg {
    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 图片id
     */
    private Integer imgId;

    /**
     * 图片在文章中的排序
     */
    private Integer orderNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}