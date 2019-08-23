package com.dgut.model;

import java.io.Serializable;

public class UserFileModel implements Serializable {
    private int wid;       //职工id
    private String fileClass; //文件格式
    private String fileName;  //文件名
    private String fileId;    //文件id
    private int    fileSize;  //文件大小
    private String sex;
    private String name;
    private String degree;
    private String department;
    private int htsum;

    public UserFileModel(){

    }


    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getFileClass() {
        return fileClass;
    }

    public void setFileClass(String fileClass) {
        this.fileClass = fileClass;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getHtsum() {
        return htsum;
    }

    public void setHtsum(int htsum) {
        this.htsum = htsum;
    }


    @Override
    public String toString()
    {
        return "UserModel{" +
                "wid=" + wid +
                ", fileClass='" + fileClass + '\'' +
                ", fileName=" + fileName +'\''+
                ", fileId=" + fileId +'\''+
                ", fileSize=" + fileSize +
                '}';
    }
}
