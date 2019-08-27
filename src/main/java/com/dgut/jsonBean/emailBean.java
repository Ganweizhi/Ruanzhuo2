package com.dgut.jsonBean;

import java.io.Serializable;

public class emailBean  implements Serializable {

    private String wid;
    private String hid;
    private String useTime;
    private String signingTime;

    public emailBean() {
    }

    public emailBean(String wid, String hid, String useTime, String signingTime) {
        this.wid = wid;
        this.hid = hid;
        this.useTime = useTime;
        this.signingTime = signingTime;
    }

    @Override
    public String toString() {
        return "emailBean{" +
                "wid='" + wid + '\'' +
                ", hid='" + hid + '\'' +
                ", useTime='" + useTime + '\'' +
                ", signingTime='" + signingTime + '\'' +
                '}';
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

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(String signingTime) {
        this.signingTime = signingTime;
    }
}
