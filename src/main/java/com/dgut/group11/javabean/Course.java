package com.dgut.group11.javabean;
/*
 *By 李大师
 */
public class Course {

    private int course_id;
    private String course_name;
    private String course_introduction;
    private String course_feature;
    private String course_material;
    private String course_history;
    private String course_principal;
    private String course_credit;
    private String course_period;

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", course_introduction='" + course_introduction + '\'' +
                ", course_feature='" + course_feature + '\'' +
                ", course_material='" + course_material + '\'' +
                ", course_history='" + course_history + '\'' +
                ", course_principal='" + course_principal + '\'' +
                ", course_credit='" + course_credit + '\'' +
                ", course_period='" + course_period + '\'' +
                '}';
    }

    public Course() {
    }

    public Course(int course_id, String course_name, String course_introduction, String course_feature, String course_material, String course_history, String course_principal, String course_credit, String course_period) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_introduction = course_introduction;
        this.course_feature = course_feature;
        this.course_material = course_material;
        this.course_history = course_history;
        this.course_principal = course_principal;
        this.course_credit = course_credit;
        this.course_period = course_period;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_introduction() {
        return course_introduction;
    }

    public void setCourse_introduction(String course_introduction) {
        this.course_introduction = course_introduction;
    }

    public String getCourse_feature() {
        return course_feature;
    }

    public void setCourse_feature(String course_feature) {
        this.course_feature = course_feature;
    }

    public String getCourse_material() {
        return course_material;
    }

    public void setCourse_material(String course_material) {
        this.course_material = course_material;
    }

    public String getCourse_history() {
        return course_history;
    }

    public void setCourse_history(String course_history) {
        this.course_history = course_history;
    }

    public String getCourse_principal() {
        return course_principal;
    }

    public void setCourse_principal(String course_principal) {
        this.course_principal = course_principal;
    }

    public String getCourse_credit() {
        return course_credit;
    }

    public void setCourse_credit(String course_credit) {
        this.course_credit = course_credit;
    }

    public String getCourse_period() {
        return course_period;
    }

    public void setCourse_period(String course_period) {
        this.course_period = course_period;
    }
}
