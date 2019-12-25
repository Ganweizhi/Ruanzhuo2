package com.dgut.group11.javabean;

public class Contentb {

    private int contentb_id ;
    private String contentb_title ;
    private String contentb_content;
    private int success_id;

    public Contentb() {
    }

    @Override
    public String toString() {
        return "Contentb{" +
                "contentb_id=" + contentb_id +
                ", contentb_title='" + contentb_title + '\'' +
                ", contentb_content='" + contentb_content + '\'' +
                ", success_id=" + success_id +
                '}';
    }

    public int getContentb_id() {
        return contentb_id;
    }

    public void setContentb_id(int contentb_id) {
        this.contentb_id = contentb_id;
    }

    public String getContentb_title() {
        return contentb_title;
    }

    public void setContentb_title(String contentb_title) {
        this.contentb_title = contentb_title;
    }

    public String getContentb_content() {
        return contentb_content;
    }

    public void setContentb_content(String contentb_content) {
        this.contentb_content = contentb_content;
    }

    public int getSuccess_id() {
        return success_id;
    }

    public void setSuccess_id(int success_id) {
        this.success_id = success_id;
    }

    public Contentb(int contentb_id, String contentb_title, String contentb_content, int success_id) {
        this.contentb_id = contentb_id;
        this.contentb_title = contentb_title;
        this.contentb_content = contentb_content;
        this.success_id = success_id;
    }
}
