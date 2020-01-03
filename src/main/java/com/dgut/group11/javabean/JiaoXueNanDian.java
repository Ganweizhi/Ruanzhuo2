package com.dgut.group11.javabean;

import java.util.List;

public class JiaoXueNanDian {
    private SuccessCourse successCourse;
    private List<Problemb> nanDianList;

    public JiaoXueNanDian(SuccessCourse successCourse, List<Problemb> nanDianList) {
        this.successCourse = successCourse;
        this.nanDianList = nanDianList;
    }

    public JiaoXueNanDian() {
    }

    @Override
    public String toString() {
        return "JiaoXueNanDian{" +
                "successCourse=" + successCourse +
                ", nanDianList=" + nanDianList +
                '}';
    }

    public SuccessCourse getSuccessCourse() {
        return successCourse;
    }

    public void setSuccessCourse(SuccessCourse successCourse) {
        this.successCourse = successCourse;
    }

    public List<Problemb> getNanDianList() {
        return nanDianList;
    }

    public void setNanDianList(List<Problemb> nanDianList) {
        this.nanDianList = nanDianList;
    }
}
