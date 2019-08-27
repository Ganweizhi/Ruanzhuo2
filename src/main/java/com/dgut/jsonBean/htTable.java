package com.dgut.jsonBean;

import org.apache.ibatis.annotations.Select;

public class htTable {
    private String hid;
    private String htName;
    private String signingTime;
    private String useTime;
    private String htUrl;

    public htTable(){

    }

    public htTable(String hid, String htName, String signingTime, String useTime, String htUrl) {
        this.hid = hid;
        this.htName = htName;
        this.signingTime = signingTime;
        this.useTime = useTime;
        this.htUrl = htUrl;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getHtName() {
        return htName;
    }

    public void setHtName(String htName) {
        this.htName = htName;
    }

    public String getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(String signingTime) {
        this.signingTime = signingTime;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getHtUrl() {
        return htUrl;
    }

    public void setHtUrl(String htUrl) {
        this.htUrl = htUrl;
    }
}
