package com.dgut.jsonBean;

public class baseWages {
    private String time;
    private String baseWage;
    public baseWages()
    {

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBaseWage() {
        return baseWage;
    }

    public void setBaseWage(String baseWage) {
        this.baseWage = baseWage;
    }

    public baseWages(String time, String baseWage) {
        this.time = time;
        this.baseWage = baseWage;
    }
}
