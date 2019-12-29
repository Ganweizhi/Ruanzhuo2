package com.dgut.group33.javaBean;

public class Content {
    private Integer content_id;
    private String content;

    @Override
    public String toString() {
        return "Content{" +
                "content_id=" + content_id +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getContent_id() {
        return content_id;
    }

    public void setContent_id(Integer content_id) {
        this.content_id = content_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
