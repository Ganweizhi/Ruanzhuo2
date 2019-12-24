package com.dgut.group11.javabean;

import java.util.List;

public class JiaoXueDaGang {
    SuccessCourse successCourse;
    List<Teaching_program> daGangList;

    @Override
    public String toString() {
        return "JiaoXueDaGang{" +
                "successCourse=" + successCourse +
                ", daGangList=" + daGangList +
                '}';
    }

    public JiaoXueDaGang() {
    }

    public JiaoXueDaGang(SuccessCourse successCourse, List<Teaching_program> daGangList) {
        this.successCourse = successCourse;
        this.daGangList = daGangList;
    }

    public SuccessCourse getSuccessCourse() {
        return successCourse;
    }

    public void setSuccessCourse(SuccessCourse successCourse) {
        this.successCourse = successCourse;
    }

    public List<Teaching_program> getDaGangList() {
        return daGangList;
    }

    public void setDaGangList(List<Teaching_program> daGangList) {
        this.daGangList = daGangList;
    }
}
