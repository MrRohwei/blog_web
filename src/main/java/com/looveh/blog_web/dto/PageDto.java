package com.looveh.blog_web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author Looveh
 * @Date 2019/6/14/014 18:09
 * @Version 1.0
 * @Desc TODO
 **/
@Data
@ToString
@EqualsAndHashCode
public class PageDto {

    private boolean usePage = false;

    private Integer pageIndex = 1;

    private Integer pageSize = 10;

    private boolean hashNext = false;

    private Integer offset;

    public void setOffset(){
        this.offset =  (pageIndex - 1) * pageSize;
    }
}
