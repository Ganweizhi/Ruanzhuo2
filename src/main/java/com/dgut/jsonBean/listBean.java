package com.dgut.jsonBean;

import java.io.Serializable;
import java.sql.Date;

public class listBean implements Serializable {

    private String wid;
    private String name;
    private String sex;
    private String degree;
    private String department;
    private String lphone;
    private String state;
    private Date signingTime;
    private Date departureTime;

    public listBean() {
    }

    public listBean(String wid, String name, String sex, String degree, String department, String lphone, String state, Date signingTime, Date departureTime) {
        this.wid = wid;
        this.name = name;
        this.sex = sex;
        this.degree = degree;
        this.department = department;
        this.lphone = lphone;
        this.state = state;
        this.signingTime = signingTime;
        this.departureTime = departureTime;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLphone() {
        return lphone;
    }

    public void setLphone(String lphone) {
        this.lphone = lphone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "listBean{" +
                "wid='" + wid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", degree='" + degree + '\'' +
                ", department='" + department + '\'' +
                ", lphone='" + lphone + '\'' +
                ", state='" + state + '\'' +
                ", signingTime=" + signingTime +
                ", departureTime=" + departureTime +
                '}';
    }
}
