package com.dgut.group22.javaBean;

public class Video {

    int resource_id;
    Course course;
    String course_id;

    @Override
    public String toString() {
        return "Video{" +
                "resource_id=" + resource_id +
                ", course=" + course +
                ", course_id='" + course_id + '\'' +
                '}';
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
