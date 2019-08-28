package com.dgut.jsonBean;

public class LogBean {

    private int lid;
    private String date;
    private String gid;
    private String name;
    private String ip;
    private String action;

    @Override
    public String toString() {
        return "LogBean{" +
                "lid=" + lid +
                ", date='" + date + '\'' +
                ", gid='" + gid + '\'' +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", action='" + action + '\'' +
                '}';
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LogBean(int lid, String date, String gid, String name, String ip, String action) {
        this.lid = lid;
        this.date = date;
        this.gid = gid;
        this.name = name;
        this.ip = ip;
        this.action = action;
    }

    public LogBean() {
    }
}
