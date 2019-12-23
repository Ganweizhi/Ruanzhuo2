package com.dgut.group33.javaBean;

public class CoursePlan {
    private int course_plan_id;
    private int speciality_id;
    private Speciality speciality;
    private int grade;

    @Override
    public String toString() {
        return "CoursePlan{" +
                "course_plan_id=" + course_plan_id +
                ", speciality_id=" + speciality_id +
                ", speciality=" + speciality +
                ", grade=" + grade +
                '}';
    }

    public int getCourse_plan_id() {
        return course_plan_id;
    }

    public void setCourse_plan_id(int course_plan_id) {
        this.course_plan_id = course_plan_id;
    }

    public int getSpeciality_id() {
        return speciality_id;
    }

    public void setSpeciality_id(int speciality_id) {
        this.speciality_id = speciality_id;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
