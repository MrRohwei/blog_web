package com.looveh.blog_web.dto;

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
public class BlogLogParam {

    private String paramName;

    private String paramValue;
}
