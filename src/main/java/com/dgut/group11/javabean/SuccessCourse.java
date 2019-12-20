package com.dgut.group11.javabean;
/*
lgc
 */
public class SuccessCourse {

    private int success_id;
    private int course_id;
    private int teacher_id;
    private String time;
    private String success_myself;
    private String success_student;
    private String success_society;
    private String success_evaluation;
    private String success_wechat;
    private String success_QQ;
    private String success_port;

    public SuccessCourse() {
    }

    public SuccessCourse(int success_id, int course_id, int teacher_id, String time, String success_myself, String success_student, String success_society, String success_evaluation, String success_wechat, String success_QQ, String success_port) {
        this.success_id = success_id;
        this.course_id = course_id;
        this.teacher_id = teacher_id;
        this.time = time;
        this.success_myself = success_myself;
        this.success_student = success_student;
        this.success_society = success_society;
        this.success_evaluation = success_evaluation;
        this.success_wechat = success_wechat;
        this.success_QQ = success_QQ;
        this.success_port = success_port;
    }

    public int getSuccess_id() {
        return success_id;
    }

    public void setSuccess_id(int success_id) {
        this.success_id = success_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSuccess_myself() {
        return success_myself;
    }

    public void setSuccess_myself(String success_myself) {
        this.success_myself = success_myself;
    }

    public String getSuccess_student() {
        return success_student;
    }

    public void setSuccess_student(String success_student) {
        this.success_student = success_student;
    }

    public String getSuccess_society() {
        return success_society;
    }

    public void setSuccess_society(String success_society) {
        this.success_society = success_society;
    }

    public String getSuccess_evaluation() {
        return success_evaluation;
    }

    public void setSuccess_evaluation(String success_evaluation) {
        this.success_evaluation = success_evaluation;
    }

    public String getSuccess_wechat() {
        return success_wechat;
    }

    public void setSuccess_wechat(String success_wechat) {
        this.success_wechat = success_wechat;
    }

    public String getSuccess_QQ() {
        return success_QQ;
    }

    public void setSuccess_QQ(String success_QQ) {
        this.success_QQ = success_QQ;
    }

    public String getSuccess_port() {
        return success_port;
    }

    @Override
    public String toString() {
        return "SuccessCourse{" +
                "success_id=" + success_id +
                ", course_id=" + course_id +
                ", teacher_id=" + teacher_id +
                ", time='" + time + '\'' +
                ", success_myself='" + success_myself + '\'' +
                ", success_student='" + success_student + '\'' +
                ", success_society='" + success_society + '\'' +
                ", success_evaluation='" + success_evaluation + '\'' +
                ", success_wechat='" + success_wechat + '\'' +
                ", success_QQ='" + success_QQ + '\'' +
                ", success_port='" + success_port + '\'' +
                '}';
    }

    public void setSuccess_port(String success_port) {
        this.success_port = success_port;
    }
}
