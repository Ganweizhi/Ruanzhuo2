package com.dgut.jsonBean;

import java.io.Serializable;
import java.util.List;

public class Inithtlist implements Serializable {
  private String wid;
  private  String Htname;
  private  String signingTime;
  private  String useTime;

  public Inithtlist(){

  }

    public Inithtlist(String wid, String htname, String signingTime, String useTime) {
        this.wid = wid;
        Htname = htname;
        this.signingTime = signingTime;
        this.useTime = useTime;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getHtname() {
        return Htname;
    }

    public void setHtname(String htname) {
        Htname = htname;
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
}
