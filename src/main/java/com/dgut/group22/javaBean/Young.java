package com.dgut.group22.javaBean;
//Ning
public class Young {
    private String young_id;
    private String teacher_id;
    private String content;

    public String getYoung_id() {
        return young_id;
    }

    public void setYoung_id(String young_id) {
        this.young_id = young_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Young(String young_id, String teacher_id, String content) {
        this.young_id = young_id;
        this.teacher_id = teacher_id;
        this.content = content;
    }
}
