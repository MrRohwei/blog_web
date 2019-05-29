package com.looveh.blog_web.distic;

/**
 * Author：looveh
 * Date：2019/5/29
 * Desc: This is Enum
 */
public enum CommonEnum {

    /**
     * 否定
     */
    NO(0,"否"),
    /**
     * 确定
     */
    YES(1, "是")
    ;

    int code;
    String value;
    CommonEnum(int code, String value){
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
