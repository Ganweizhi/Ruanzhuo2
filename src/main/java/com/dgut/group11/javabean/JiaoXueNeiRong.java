package com.dgut.group11.javabean;

import java.util.List;

public class JiaoXueNeiRong {

    SuccessCourse successCourse;
    List<Contentb> neiRongList;

    @Override
    public String toString() {
        return "JiaoXueNeiRong{" +
                "successCourse=" + successCourse +
                ", neiRongList=" + neiRongList +
                '}';
    }

    public JiaoXueNeiRong() {
    }

    public JiaoXueNeiRong(SuccessCourse successCourse, List<Contentb> neiRongList) {
        this.successCourse = successCourse;
        this.neiRongList = neiRongList;
    }

    public SuccessCourse getSuccessCourse() {
        return successCourse;
    }

    public void setSuccessCourse(SuccessCourse successCourse) {
        this.successCourse = successCourse;
    }

    public List<Contentb> getNeiRongList() {
        return neiRongList;
    }

    public void setNeiRongList(List<Contentb> neiRongList) {
        this.neiRongList = neiRongList;
    }
}
