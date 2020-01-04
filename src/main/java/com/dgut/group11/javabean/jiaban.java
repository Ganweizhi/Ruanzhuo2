package com.dgut.group11.javabean;

public class jiaban {
    private int success_id;
    private int course_id;
    private String str;

    public jiaban(int success_id, int course_id, String str) {
        this.success_id = success_id;
        this.course_id = course_id;
        this.str = str;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public jiaban(int success_id, String str) {
        this.success_id = success_id;
        this.str = str;
    }

    public jiaban() {
    }

    public int getSuccess_id() {
        return success_id;
    }

    public void setSuccess_id(int success_id) {
        this.success_id = success_id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
