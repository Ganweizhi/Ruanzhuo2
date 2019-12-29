package com.dgut.group33.javaBean;

public class AddEditContent {
    private int measure_id;
    private String measure_title;
    private String measure_time;
    private int content_id;
    private String content;
    private String content_author;

    @Override
    public String toString() {
        return "AddEditContent{" +
                "measure_id=" + measure_id +
                ", measure_title='" + measure_title + '\'' +
                ", measure_time='" + measure_time + '\'' +
                ", content_id=" + content_id +
                ", Content='" + content + '\'' +
                ", Content_author='" + content_author + '\'' +
                '}';
    }

    public int getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(int measure_id) {
        this.measure_id = measure_id;
    }

    public String getMeasure_title() {
        return measure_title;
    }

    public void setMeasure_title(String measure_title) {
        this.measure_title = measure_title;
    }

    public String getMeasure_time() {
        return measure_time;
    }

    public void setMeasure_time(String measure_time) {
        this.measure_time = measure_time;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_author() {
        return content_author;
    }

    public void setContent_author(String content_author) {
        this.content_author = content_author;
    }
}
