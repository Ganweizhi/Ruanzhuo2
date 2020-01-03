package com.dgut.group11.javabean;

import java.util.List;

public class JiaoXueFangFa {
    private SuccessCourse successCourse;
    private List<Methodb> fangFaList;

    public JiaoXueFangFa(SuccessCourse successCourse, List<Methodb> fangFaList) {
        this.successCourse = successCourse;
        this.fangFaList = fangFaList;
    }

    @Override
    public String toString() {
        return "JiaoXueFangFa{" +
                "successCourse=" + successCourse +
                ", fangFaList=" + fangFaList +
                '}';
    }

    public JiaoXueFangFa() {
    }

    public SuccessCourse getSuccessCourse() {
        return successCourse;
    }

    public void setSuccessCourse(SuccessCourse successCourse) {
        this.successCourse = successCourse;
    }

    public List<Methodb> getFangFaList() {
        return fangFaList;
    }

    public void setFangFaList(List<Methodb> fangFaList) {
        this.fangFaList = fangFaList;
    }
}
