package com.dgut.jsonBean;

import java.io.Serializable;

public class wageBean implements Serializable {
    private String wid;
    private String name;
    private String sex;
    private String degree;
    private String department;
    private String baseWage;

    public wageBean() {
    }

    public wageBean(String wid, String name, String sex, String degree, String department, String baseWage) {
        this.wid = wid;
        this.name = name;
        this.sex = sex;
        this.degree = degree;
        this.department = department;
        this.baseWage = baseWage;
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

    public String getBaseWage() {
        return baseWage;
    }

    public void setBaseWage(String baseWage) {
        this.baseWage = baseWage;
    }

    @Override
    public String toString() {
        return "wageBean{" +
                "wid='" + wid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", degree='" + degree + '\'' +
                ", department='" + department + '\'' +
                ", baseWage='" + baseWage + '\'' +
                '}';
    }
}
