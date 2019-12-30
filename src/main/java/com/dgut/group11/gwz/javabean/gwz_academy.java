package com.dgut.group11.gwz.javabean;

import java.util.List;

public class gwz_academy {
    private int academy_id;
    private String academy_name;
    private List<gwz_teacher> gwz_teacherList;

    public gwz_academy(){}

    public gwz_academy(int academy_id, String academy_name, List<gwz_teacher> gwz_teacherList) {
        this.academy_id = academy_id;
        this.academy_name = academy_name;
        this.gwz_teacherList = gwz_teacherList;
    }

    public int getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(int academy_id) {
        this.academy_id = academy_id;
    }

    public String getAcademy_name() {
        return academy_name;
    }

    public void setAcademy_name(String academy_name) {
        this.academy_name = academy_name;
    }

    public List<gwz_teacher> getGwz_teacherList() {
        return gwz_teacherList;
    }

    public void setGwz_teacherList(List<gwz_teacher> gwz_teacherList) {
        this.gwz_teacherList = gwz_teacherList;
    }

    @Override
    public String toString() {
        return "gwz_academy{" +
                "academy_id=" + academy_id +
                ", academy_name='" + academy_name + '\'' +
                ", gwz_teacherList=" + gwz_teacherList +
                '}';
    }
}
