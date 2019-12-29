package com.dgut.group33.javaBean;

public class Title {
    private String title;
    private String date;
    private Integer content_id;

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", content_id=" + content_id +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getContent_id() {
        return content_id;
    }

    public void setContent_id(Integer content_id) {
        this.content_id = content_id;
    }
}
