package com.dgut.jsonBean;

public class gldelBean {
    private String gid;
    private String name;
    public gldelBean(){

    }

    public gldelBean(String gid, String name) {
        this.gid = gid;
        this.name = name;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
