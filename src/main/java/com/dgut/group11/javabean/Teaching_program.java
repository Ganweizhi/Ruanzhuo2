package com.dgut.group11.javabean;

public class Teaching_program {

    private int teaching_program_id ;
    private String teaching_program_title;
    private String teaching_program_content;
    private int success_id;

    public Teaching_program() {
    }

    public Teaching_program(int teaching_program_id, String teaching_program_title, String teaching_program_content, int success_id) {
        this.teaching_program_id = teaching_program_id;
        this.teaching_program_title = teaching_program_title;
        this.teaching_program_content = teaching_program_content;
        this.success_id = success_id;
    }

    @Override
    public String toString() {
        return "Teaching_program{" +
                "teaching_program_id=" + teaching_program_id +
                ", teaching_program_title='" + teaching_program_title + '\'' +
                ", teaching_program_content='" + teaching_program_content + '\'' +
                ", success_id=" + success_id +
                '}';
    }

    public int getTeaching_program_id() {
        return teaching_program_id;
    }

    public void setTeaching_program_id(int teaching_program_id) {
        this.teaching_program_id = teaching_program_id;
    }

    public String getTeaching_program_title() {
        return teaching_program_title;
    }

    public void setTeaching_program_title(String teaching_program_title) {
        this.teaching_program_title = teaching_program_title;
    }

    public String getTeaching_program_content() {
        return teaching_program_content;
    }

    public void setTeaching_program_content(String teaching_program_content) {
        this.teaching_program_content = teaching_program_content;
    }

    public int getSuccess_id() {
        return success_id;
    }

    public void setSuccess_id(int success_id) {
        this.success_id = success_id;
    }
}
