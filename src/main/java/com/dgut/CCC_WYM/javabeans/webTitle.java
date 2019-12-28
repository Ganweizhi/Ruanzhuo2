package com.dgut.CCC_WYM.javabeans;

import org.apache.ibatis.annotations.Select;

public class webTitle {
    private String question_name;
    private String title;
    private String times;
    webTitle(){}

    public String getQuestion_name() {
        return question_name;
    }

    public void setQuestion_name(String question_name) {
        this.question_name = question_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
