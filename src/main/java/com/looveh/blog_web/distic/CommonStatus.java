package com.looveh.blog_web.distic;

import java.util.HashMap;
import java.util.Map;

public enum CommonStatus {

    ENABLE("1", "启用"),
    DISABLE("0", "禁用");

    private String status;
    private String statusName;
    CommonStatus(String status, String statusName){
        this.status = status;
        this.statusName = statusName;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusName() {
        return statusName;
    }

    private static final Map<String, CommonStatus> commonStatusMap = new HashMap<>();

    private static void init(){
        CommonStatus[] values = CommonStatus.values();
        for (CommonStatus value : values) {
            commonStatusMap.put(value.getStatus(), value);
        }
    }

    public static CommonStatus getByStatus(String status){
        CommonStatus commonStatus = commonStatusMap.get(status);
        if(null == commonStatus){
            init();
            commonStatus = commonStatusMap.get(status);
        }
        return commonStatus;
    }
}
