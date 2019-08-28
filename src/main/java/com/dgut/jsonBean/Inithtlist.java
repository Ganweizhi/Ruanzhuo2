package com.dgut.jsonBean;

import java.io.Serializable;


public class Inithtlist implements Serializable {
  private String wid;
  private  String htName;
  private  String signingTime;
  private  String useTime;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
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

    public Inithtlist(String wid, String htName, String signingTime, String useTime) {
        this.wid = wid;
        this.htName = htName;
        this.signingTime = signingTime;
        this.useTime = useTime;
    }

    @Override
    public String toString() {
        return "Inithtlist{" +
                "wid='" + wid + '\'' +
                ", htName='" + htName + '\'' +
                ", signingTime='" + signingTime + '\'' +
                ", useTime='" + useTime + '\'' +
                '}';
    }

    public Inithtlist() {
    }
}
