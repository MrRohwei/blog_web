package com.looveh.blog_web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class BlogLogs {

    private Integer id;

    private String ipno;

    private String level;

    private String className;

    private String methodName;

    private String info;

    private Date createTime;

    private String param;

    private Integer duration;

    private String remark;

}