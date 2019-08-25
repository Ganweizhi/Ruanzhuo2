package com.dgut.jsonBean;

import java.io.Serializable;

public class addWageBean implements Serializable {
    private String wid;
    private String baseWage;
    private String bankName;
    private String bankId;

    public addWageBean() {
    }

    public addWageBean(String wid, String baseWage, String bankName, String bankId) {
        this.wid = wid;
        this.baseWage = baseWage;
        this.bankName = bankName;
        this.bankId = bankId;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
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

    @Override
    public String toString() {
        return "addWageBean{" +
                "wid='" + wid + '\'' +
                ", baseWage='" + baseWage + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankId='" + bankId + '\'' +
                '}';
    }
}
