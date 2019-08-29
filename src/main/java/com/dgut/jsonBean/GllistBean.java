package com.dgut.jsonBean;

import java.io.Serializable;

/**
 * @author WuJiewei
 * 这个类是为了和数据库吻合，与前端的json有一点不同
 * 管理员对象 类的命名采用了拼音首字母缩写，顾名思义
 * 查询数据库中所有的管理员，并封装到管理员对象
 */
public class GllistBean implements Serializable {
    private String gid;  // 管理员莞工账号
    private String name;  // 管理员名称
    private String role;  // 管理员的角色名称
    private Integer state;  // 账号是否停用，0 或 1

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "GllistBean{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                '}';
    }
}
