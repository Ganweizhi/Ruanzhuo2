package com.dgut.group11.javabean;

import java.util.List;

public class JiaoXueJiHua {
    private SuccessCourse course;
    private List<Planb> jiaoHuaList;

    public JiaoXueJiHua(SuccessCourse course, List<Planb> jiaoHuaList) {
        this.course = course;
        this.jiaoHuaList = jiaoHuaList;
    }

    @Override
    public String toString() {
        return "JiaoXueJiHua{" +
                "course=" + course +
                ", jiaoHuaList=" + jiaoHuaList +
                '}';
    }

    public JiaoXueJiHua() {
    }

    public SuccessCourse getCourse() {
        return course;
    }

    public void setCourse(SuccessCourse course) {
        this.course = course;
    }

    public List<Planb> getJiaoHuaList() {
        return jiaoHuaList;
    }

    public void setJiaoHuaList(List<Planb> jiaoHuaList) {
        this.jiaoHuaList = jiaoHuaList;
    }
}
