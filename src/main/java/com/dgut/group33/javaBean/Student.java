package com.dgut.group33.javaBean;

public class Student {
    private int student_id;
    private String student_name;
    private String student_grade;
    private int class_id;
    private String student_sex;
    private String student_birth;
    private String student_natplace;
    private String student_email;
    private String student_phone;

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_grade='" + student_grade + '\'' +
                ", class_id=" + class_id +
                ", student_sex='" + student_sex + '\'' +
                ", student_birth='" + student_birth + '\'' +
                ", student_natplace='" + student_natplace + '\'' +
                ", student_email='" + student_email + '\'' +
                ", student_phone='" + student_phone + '\'' +
                '}';
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_grade() {
        return student_grade;
    }

    public void setStudent_grade(String student_grade) {
        this.student_grade = student_grade;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getStudent_birth() {
        return student_birth;
    }

    public void setStudent_birth(String student_birth) {
        this.student_birth = student_birth;
    }

    public String getStudent_natplace() {
        return student_natplace;
    }

    public void setStudent_natplace(String student_natplace) {
        this.student_natplace = student_natplace;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }
}
