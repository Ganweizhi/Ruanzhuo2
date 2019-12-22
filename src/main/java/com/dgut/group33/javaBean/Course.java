package com.dgut.group33.javaBean;

public class Course {
    private int course_id;
    private String course_period;
    private String course_name;
    private int course_credit;
    private String course_type;
    private String course_method;
    private int course_time;
    private int course_plan_id;

    @Override
    public String toString() {
        return "CoursePlan{" +
                "course_id=" + course_id +
                ", course_period='" + course_period + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_credit=" + course_credit +
                ", course_type='" + course_type + '\'' +
                ", course_method='" + course_method + '\'' +
                ", course_time=" + course_time +
                ", course_plan_id=" + course_plan_id +
                '}';
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_period() {
        return course_period;
    }

    public void setCourse_period(String course_period) {
        this.course_period = course_period;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_credit() {
        return course_credit;
    }

    public void setCourse_credit(int course_credit) {
        this.course_credit = course_credit;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public String getCourse_method() {
        return course_method;
    }

    public void setCourse_method(String course_method) {
        this.course_method = course_method;
    }

    public int getCourse_time() {
        return course_time;
    }

    public void setCourse_time(int course_time) {
        this.course_time = course_time;
    }

    public int getCourse_plan_id() {
        return course_plan_id;
    }

    public void setCourse_plan_id(int course_plan_id) {
        this.course_plan_id = course_plan_id;
    }
}
