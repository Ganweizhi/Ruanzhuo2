package com.dgut.group11.javabean;

public class Planb {
    private int planb_id ;
    private String planb_title;
    private String planb_content ;
    private String success_id;
    private String course_name;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Planb(int planb_id, String planb_title, String planb_content, String success_id, String course_name) {
        this.planb_id = planb_id;
        this.planb_title = planb_title;
        this.planb_content = planb_content;
        this.success_id = success_id;
        this.course_name = course_name;
    }

    public Planb() {
    }

    public Planb(int planb_id, String planb_title, String planb_content, String success_id) {
        this.planb_id = planb_id;
        this.planb_title = planb_title;
        this.planb_content = planb_content;
        this.success_id = success_id;
    }

    @Override
    public String toString() {
        return "Planb{" +
                "planb_id=" + planb_id +
                ", planb_title='" + planb_title + '\'' +
                ", planb_content='" + planb_content + '\'' +
                ", success_id='" + success_id + '\'' +
                '}';
    }

    public int getPlanb_id() {
        return planb_id;
    }

    public void setPlanb_id(int planb_id) {
        this.planb_id = planb_id;
    }

    public String getPlanb_title() {
        return planb_title;
    }

    public void setPlanb_title(String planb_title) {
        this.planb_title = planb_title;
    }

    public String getPlanb_content() {
        return planb_content;
    }

    public void setPlanb_content(String planb_content) {
        this.planb_content = planb_content;
    }

    public String getSuccess_id() {
        return success_id;
    }

    public void setSuccess_id(String success_id) {
        this.success_id = success_id;
    }
}
