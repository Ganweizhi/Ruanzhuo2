package com.dgut.group11.javabean;

import java.util.List;

public class CourseRiLi {

    private SuccessCourse successCourse;
    private List<RiLi> riLiList;

    public CourseRiLi(SuccessCourse successCourse, List<RiLi> riLiList) {
        this.successCourse = successCourse;
        this.riLiList = riLiList;
    }

    public CourseRiLi() {
    }

    @Override
    public String toString() {
        return "CourseRiLi{" +
                "successCourse=" + successCourse +
                ", riLiList=" + riLiList +
                '}';
    }

    public SuccessCourse getSuccessCourse() {
        return successCourse;
    }

    public void setSuccessCourse(SuccessCourse successCourse) {
        this.successCourse = successCourse;
    }

    public List<RiLi> getRiLiList() {
        return riLiList;
    }

    public void setRiLiList(List<RiLi> riLiList) {
        this.riLiList = riLiList;
    }
}
