package com.dgut.group22.javaBean;

//Ning
public class Team {
    int team_id;
    String team_name;
    int course_id;
    String photo_team;
    Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getPhoto_team() {
        return photo_team;
    }

    public void setPhoto_team(String photo_team) {
        this.photo_team = photo_team;
    }
}
