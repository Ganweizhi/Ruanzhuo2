package com.dgut.jsonBean;

//用于接收莞工登录返回的数据
public class Manager {

    private String faculty_title;
    private String wx_openid;
    private String openid;
    private String name;
    private String username;
    private String faculty;
    private String group;

    @Override
    public String toString() {
        return "Manager{" +
                "faculty_title='" + faculty_title + '\'' +
                ", wx_openid='" + wx_openid + '\'' +
                ", openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", faculty='" + faculty + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public Manager() {
    }

    public String getFaculty_title() {
        return faculty_title;
    }

    public void setFaculty_title(String faculty_title) {
        this.faculty_title = faculty_title;
    }

    public String getWx_openid() {
        return wx_openid;
    }

    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Manager(String faculty_title, String wx_openid, String openid, String name, String username, String faculty, String group) {
        this.faculty_title = faculty_title;
        this.wx_openid = wx_openid;
        this.openid = openid;
        this.name = name;
        this.username = username;
        this.faculty = faculty;
        this.group = group;
    }
}
