package com.dgut.group33.javaBean;

public class Speciality {
    private int speciality_id;
    private String speciality_name;
    private int academy_id;
    private Academy academy;

    @Override
    public String toString() {
        return "Speciality{" +
                "speciality_id=" + speciality_id +
                ", speciality_name='" + speciality_name + '\'' +
                ", academy_id=" + academy_id +
                ", academy=" + academy +
                '}';
    }

    public int getSpeciality_id() {
        return speciality_id;
    }

    public void setSpeciality_id(int speciality_id) {
        this.speciality_id = speciality_id;
    }

    public String getSpeciality_name() {
        return speciality_name;
    }

    public void setSpeciality_name(String speciality_name) {
        this.speciality_name = speciality_name;
    }

    public int getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(int academy_id) {
        this.academy_id = academy_id;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}
