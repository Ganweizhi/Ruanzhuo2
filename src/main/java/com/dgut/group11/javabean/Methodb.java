package com.dgut.group11.javabean;

public class Methodb {

    private int methodb_id ;
    private String methodb_title;
    private String methodb_content ;
    private int success_id;

    public Methodb(int methodb_id, String methodb_title, String methodb_content, int success_id) {
        this.methodb_id = methodb_id;
        this.methodb_title = methodb_title;
        this.methodb_content = methodb_content;
        this.success_id = success_id;
    }

    public Methodb() {
    }

    @Override
    public String toString() {
        return "Methodb{" +
                "methodb_id=" + methodb_id +
                ", methodb_title='" + methodb_title + '\'' +
                ", methodb_content='" + methodb_content + '\'' +
                ", success_id=" + success_id +
                '}';
    }

    public int getMethodb_id() {
        return methodb_id;
    }

    public void setMethodb_id(int methodb_id) {
        this.methodb_id = methodb_id;
    }

    public String getMethodb_title() {
        return methodb_title;
    }

    public void setMethodb_title(String methodb_title) {
        this.methodb_title = methodb_title;
    }

    public String getMethodb_content() {
        return methodb_content;
    }

    public void setMethodb_content(String methodb_content) {
        this.methodb_content = methodb_content;
    }

    public int getSuccess_id() {
        return success_id;
    }

    public void setSuccess_id(int success_id) {
        this.success_id = success_id;
    }
}
