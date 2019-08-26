package com.dgut.jsonBean;

import org.apache.ibatis.annotations.Param;

public class IdReturnBean {
    private String type;
    private String name;
    private String url;
    public IdReturnBean(){}

    public IdReturnBean(String type, String name, String url) {
        this.type = type;
        this.name = name;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
