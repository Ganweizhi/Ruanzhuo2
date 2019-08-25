package com.dgut.jsonBean;

import java.io.Serializable;
import java.sql.Date;

public class listBean implements Serializable {

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
    private String baseWage;
    private String bankName;
    private String bankId;
    private String htSum;
    private String signingTime;
    private String departureTime;
    private String state;
    private String img;
    private String sfzz;
    private String sfzf;
    private String yhkz;
    private String yhkf;

    public listBean() {
    }

    public listBean(String wid, String name, String sex, String nation, String nationality, String origin, String idType, String idNumber, String education, String degree, String department, String job, String title, String lPhone, String sPhone, String email, String baseWage, String bankName, String bankId, String htSum, String signingTime, String departureTime, String state, String img, String sfzz, String sfzf, String yhkz, String yhkf) {
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
        this.baseWage = baseWage;
        this.bankName = bankName;
        this.bankId = bankId;
        this.htSum = htSum;
        this.signingTime = signingTime;
        this.departureTime = departureTime;
        this.state = state;
        this.img = img;
        this.sfzz = sfzz;
        this.sfzf = sfzf;
        this.yhkz = yhkz;
        this.yhkf = yhkf;
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

    public String getHtSum() {
        return htSum;
    }

    public void setHtSum(String htSum) {
        this.htSum = htSum;
    }

    public String getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(String signingTime) {
        this.signingTime = signingTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSfzz() {
        return sfzz;
    }

    public void setSfzz(String sfzz) {
        this.sfzz = sfzz;
    }

    public String getSfzf() {
        return sfzf;
    }

    public void setSfzf(String sfzf) {
        this.sfzf = sfzf;
    }

    public String getYhkz() {
        return yhkz;
    }

    public void setYhkz(String yhkz) {
        this.yhkz = yhkz;
    }

    public String getYhkf() {
        return yhkf;
    }

    public void setYhkf(String yhkf) {
        this.yhkf = yhkf;
    }

    @Override
    public String toString() {
        return "listBean{" +
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
                ", baseWage='" + baseWage + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankId='" + bankId + '\'' +
                ", htSum='" + htSum + '\'' +
                ", signingTime='" + signingTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", state='" + state + '\'' +
                ", img='" + img + '\'' +
                ", sfzz='" + sfzz + '\'' +
                ", sfzf='" + sfzf + '\'' +
                ", yhkz='" + yhkz + '\'' +
                ", yhkf='" + yhkf + '\'' +
                '}';
    }
}
