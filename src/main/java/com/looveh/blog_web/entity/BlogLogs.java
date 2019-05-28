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

    private String userType;

    private String ip;

    private String desc;

    private String param;

    private Integer duration;

    private String remark;

    private Date createTime;


}