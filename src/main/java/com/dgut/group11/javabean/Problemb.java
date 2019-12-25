package com.dgut.group11.javabean;

public class Problemb {

    private int problemb_id ;
    private String problemb_title ;
    private String problemb_content ;
    private int success_id;

    public Problemb(int problemb_id, String problemb_title, String problemb_content, int success_id) {
        this.problemb_id = problemb_id;
        this.problemb_title = problemb_title;
        this.problemb_content = problemb_content;
        this.success_id = success_id;
    }

    @Override
    public String toString() {
        return "Problemb{" +
                "problemb_id=" + problemb_id +
                ", problemb_title='" + problemb_title + '\'' +
                ", problemb_content='" + problemb_content + '\'' +
                ", success_id=" + success_id +
                '}';
    }

    public Problemb() {
    }

    public int getProblemb_id() {
        return problemb_id;
    }

    public void setProblemb_id(int problemb_id) {
        this.problemb_id = problemb_id;
    }

    public String getProblemb_title() {
        return problemb_title;
    }

    public void setProblemb_title(String problemb_title) {
        this.problemb_title = problemb_title;
    }

    public String getProblemb_content() {
        return problemb_content;
    }

    public void setProblemb_content(String problemb_content) {
        this.problemb_content = problemb_content;
    }

    public int getSuccess_id() {
        return success_id;
    }

    public void setSuccess_id(int success_id) {
        this.success_id = success_id;
    }
}
