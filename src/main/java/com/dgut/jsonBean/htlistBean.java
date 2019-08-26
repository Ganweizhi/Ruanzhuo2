package com.dgut.jsonBean;

import java.io.Serializable;

public class htlistBean implements Serializable {
    private String wid;
    private String hid;
    private String hname;
    private String hurl;
    private String usetime;  //有效期
    private String signingtime; //签约日期

    public htlistBean()
    {

    }

    public htlistBean(String wid, String hid, String hname, String hurl, String usetime, String signingtime) {
        this.wid = wid;
        this.hid = hid;
        this.hname = hname;
        this.hurl = hurl;
        this.usetime = usetime;
        this.signingtime = signingtime;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHurl() {
        return hurl;
    }

    public void setHurl(String hurl) {
        this.hurl = hurl;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    public String getSigningtime() {
        return signingtime;
    }

    public void setSigningtime(String signingtime) {
        this.signingtime = signingtime;
    }
}

