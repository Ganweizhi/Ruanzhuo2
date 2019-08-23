package com.dgut.jsonBean;

import java.io.Serializable;

public class addBean  implements Serializable {
    private String wid;
    private String name;
    private String sex;
    private String nation;
    private String nationality;
    private String origin;
    private String idType;
    private String idNumber;
    private String education;
    private String degree;
    private String department;
    private String job;
    private String title;
    private String lPhone;
    private String sPhone;
    private String email;

    public addBean() {
    }

    public addBean(String wid, String name, String sex, String nation, String nationality, String origin, String idType, String idNumber, String education, String degree, String department, String job, String title, String lPhone, String sPhone, String email) {
        this.wid = wid;
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.nationality = nationality;
        this.origin = origin;
        this.idType = idType;
        this.idNumber = idNumber;
        this.education = education;
        this.degree = degree;
        this.department = department;
        this.job = job;
        this.title = title;
        this.lPhone = lPhone;
        this.sPhone = sPhone;
        this.email = email;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getlPhone() {
        return lPhone;
    }

    public void setlPhone(String lPhone) {
        this.lPhone = lPhone;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "addBean{" +
                "wid='" + wid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", nationality='" + nationality + '\'' +
                ", origin='" + origin + '\'' +
                ", idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", education='" + education + '\'' +
                ", degree='" + degree + '\'' +
                ", department='" + department + '\'' +
                ", job='" + job + '\'' +
                ", title='" + title + '\'' +
                ", lPhone='" + lPhone + '\'' +
                ", sPhone='" + sPhone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
