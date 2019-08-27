package com.dgut.jsonBean;

import org.apache.ibatis.annotations.Select;

public class htTable {
   private String hid;
   private String hName;
   private String hUrl;
   private String useTime;
   private String signingTime;
   public htTable(){

   }

    public htTable(String hid, String hName, String hUrl, String useTime, String signingTime) {
        this.hid = hid;
        this.hName = hName;
        this.hUrl = hUrl;
        this.useTime = useTime;
        this.signingTime = signingTime;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String gethUrl() {
        return hUrl;
    }

    public void sethUrl(String hUrl) {
        this.hUrl = hUrl;
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
