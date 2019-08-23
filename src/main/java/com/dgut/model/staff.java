package com.dgut.model;

import java.io.Serializable;

public class staff implements Serializable {
    private String wid; //工号
    private String name; //姓名
    private String sex; //性别
    private String nation; //民族
    private String nationality; //国籍
    private String origin; //籍贯
    private String idType; //证件类型
    private String idNumber; //证件号
    private String education; //学历
    private String degree; //学位
    private String department; //部门
    private String job; //岗位
    private String title; //职称
    private String lPhone; //手机长号
    private String sPhone; //短号
    private String gPhone; //固定电话
    private String email; //邮箱
    private String img; //头像
    private String state; //状态
    private String baseWage; //基本工资
    private String bankName; //银行名称
    private String bankId; //银行账号
    private String htName; //合同名称
    private String signingTime; //签约时间
    private String useTime; //合同有效期
    private String departureTime; //离职时间

    public staff() {
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

    public String getgPhone() {
        return gPhone;
    }

    public void setgPhone(String gPhone) {
        this.gPhone = gPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBaseWage() {
        return baseWage;
    }

    public void setBaseWage(String baseWage) {
        this.baseWage = baseWage;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "staff{" +
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
                ", gPhone='" + gPhone + '\'' +
                ", email='" + email + '\'' +
                ", img='" + img + '\'' +
                ", state='" + state + '\'' +
                ", baseWage='" + baseWage + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankId='" + bankId + '\'' +
                ", htName='" + htName + '\'' +
                ", signingTime=" + signingTime +
                ", useTime=" + useTime +
                ", departureTime=" + departureTime +
                '}';
    }
}
