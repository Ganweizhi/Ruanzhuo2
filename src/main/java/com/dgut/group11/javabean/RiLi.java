package com.dgut.group11.javabean;
/*
lgc
 */
public class RiLi {

    private int calendar_id;
    private String calendar_title;
    private String calendar_content;
    private int success_id;
    private String course_name;

    public int getSuccess_id() {
        return success_id;
    }

    public void setSuccess_id(int success_id) {
        this.success_id = success_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public RiLi(int calendar_id, String calendar_title, String calendar_content, int success_id, String course_name) {
        this.calendar_id = calendar_id;
        this.calendar_title = calendar_title;
        this.calendar_content = calendar_content;
        this.success_id = success_id;
        this.course_name = course_name;
    }

    public RiLi() {
    }

    public RiLi(int calendar_id, String calendar_title, String calendar_content) {
        this.calendar_id = calendar_id;
        this.calendar_title = calendar_title;
        this.calendar_content = calendar_content;
    }

    @Override
    public String toString() {
        return "RiLi{" +
                "calendar_id=" + calendar_id +
                ", calendar_title='" + calendar_title + '\'' +
                ", calendar_content='" + calendar_content + '\'' +
                '}';
    }

    public int getCalendar_id() {
        return calendar_id;
    }

    public void setCalendar_id(int calendar_id) {
        this.calendar_id = calendar_id;
    }

    public String getCalendar_title() {
        return calendar_title;
    }

    public void setCalendar_title(String calendar_title) {
        this.calendar_title = calendar_title;
    }

    public String getCalendar_content() {
        return calendar_content;
    }

    public void setCalendar_content(String calendar_content) {
        this.calendar_content = calendar_content;
    }
}
