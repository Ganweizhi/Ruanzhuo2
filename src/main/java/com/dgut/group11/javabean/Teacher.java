package com.dgut.group11.javabean;

import java.sql.Date;

public class Teacher {
    private int teacher_id;
    private String teacher_name;
    private int academy_id ;
    private Date teacher_birth;
    private String teacher_sex ;
    private String teacher_rank;
    private int teacher_phone;
    private String teacher_email;
    private String teacher_qualification;
    private String teacher_domain;
    private String teacher_job;
    private String teacher_address;
    private String teacher_resdire;
    private String teacher_resume;
    private String teacher_photo ;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", academy_id=" + academy_id +
                ", teacher_birth=" + teacher_birth +
                ", teacher_sex='" + teacher_sex + '\'' +
                ", teacher_rank='" + teacher_rank + '\'' +
                ", teacher_phone=" + teacher_phone +
                ", teacher_email='" + teacher_email + '\'' +
                ", teacher_qualification='" + teacher_qualification + '\'' +
                ", teacher_domain='" + teacher_domain + '\'' +
                ", teacher_job='" + teacher_job + '\'' +
                ", teacher_address='" + teacher_address + '\'' +
                ", teacher_resdire='" + teacher_resdire + '\'' +
                ", teacher_resume='" + teacher_resume + '\'' +
                ", teacher_photo='" + teacher_photo + '\'' +
                '}';
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(int academy_id) {
        this.academy_id = academy_id;
    }

    public Date getTeacher_birth() {
        return teacher_birth;
    }

    public void setTeacher_birth(Date teacher_birth) {
        this.teacher_birth = teacher_birth;
    }

    public String getTeacher_sex() {
        return teacher_sex;
    }

    public void setTeacher_sex(String teacher_sex) {
        this.teacher_sex = teacher_sex;
    }

    public String getTeacher_rank() {
        return teacher_rank;
    }

    public void setTeacher_rank(String teacher_rank) {
        this.teacher_rank = teacher_rank;
    }

    public int getTeacher_phone() {
        return teacher_phone;
    }

    public void setTeacher_phone(int teacher_phone) {
        this.teacher_phone = teacher_phone;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getTeacher_qualification() {
        return teacher_qualification;
    }

    public void setTeacher_qualification(String teacher_qualification) {
        this.teacher_qualification = teacher_qualification;
    }

    public String getTeacher_domain() {
        return teacher_domain;
    }

    public void setTeacher_domain(String teacher_domain) {
        this.teacher_domain = teacher_domain;
    }

    public String getTeacher_job() {
        return teacher_job;
    }

    public void setTeacher_job(String teacher_job) {
        this.teacher_job = teacher_job;
    }

    public String getTeacher_address() {
        return teacher_address;
    }

    public void setTeacher_address(String teacher_address) {
        this.teacher_address = teacher_address;
    }

    public String getTeacher_resdire() {
        return teacher_resdire;
    }

    public void setTeacher_resdire(String teacher_resdire) {
        this.teacher_resdire = teacher_resdire;
    }

    public String getTeacher_resume() {
        return teacher_resume;
    }

    public void setTeacher_resume(String teacher_resume) {
        this.teacher_resume = teacher_resume;
    }

    public String getTeacher_photo() {
        return teacher_photo;
    }

    public void setTeacher_photo(String teacher_photo) {
        this.teacher_photo = teacher_photo;
    }

    public Teacher() {
    }

    public Teacher(int teacher_id, String teacher_name, int academy_id, Date teacher_birth, String teacher_sex, String teacher_rank, int teacher_phone, String teacher_email, String teacher_qualification, String teacher_domain, String teacher_job, String teacher_address, String teacher_resdire, String teacher_resume, String teacher_photo) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.academy_id = academy_id;
        this.teacher_birth = teacher_birth;
        this.teacher_sex = teacher_sex;
        this.teacher_rank = teacher_rank;
        this.teacher_phone = teacher_phone;
        this.teacher_email = teacher_email;
        this.teacher_qualification = teacher_qualification;
        this.teacher_domain = teacher_domain;
        this.teacher_job = teacher_job;
        this.teacher_address = teacher_address;
        this.teacher_resdire = teacher_resdire;
        this.teacher_resume = teacher_resume;
        this.teacher_photo = teacher_photo;
    }
}
