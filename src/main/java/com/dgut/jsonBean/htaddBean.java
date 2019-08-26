package com.dgut.jsonBean;

public class htaddBean {
    private String wid;
    private String htName;
    private String useTime;
    public  htaddBean(){

    }
    public htaddBean(String wid, String htName, String useTime) {
        this.wid = wid;
        this.htName = htName;
        this.useTime = useTime;
    }

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

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }


}