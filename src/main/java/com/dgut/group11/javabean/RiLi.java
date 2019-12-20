package com.dgut.group11.javabean;

public class RiLi {

    private int calendar_id;
    private String calendar_title;
    private String calendar_content;

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
