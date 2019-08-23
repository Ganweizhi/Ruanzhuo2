package com.dgut.jsonBean;

import java.io.Serializable;

public class htlistBean implements Serializable {
  private String wid;
  private String name;
  private String sex;
  private String degree;
  private String department;
  private int htSum;

  public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "htlistBean{" +
                "wid='" + wid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", degree='" + degree + '\'' +
                ", department='" + department + '\'' +
                ", htSum=" + htSum +
                '}';
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

    public int getHtSum() {
        return htSum;
    }

    public void setHtSum(int htSum) {
        this.htSum = htSum;
    }


    public htlistBean()
    {

    }

    public htlistBean(String wid, String name, String sex, String degree, String department, int htSum) {
        this.wid = wid;
        this.name = name;
        this.sex = sex;
        this.degree = degree;
        this.department = department;
        this.htSum = htSum;
    }


}
