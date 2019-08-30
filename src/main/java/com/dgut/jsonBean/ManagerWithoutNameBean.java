package com.dgut.jsonBean;

import java.io.Serializable;
import java.util.List;

public class ManagerWithoutNameBean implements Serializable {
    private String gid;  // 管理员莞工账号
    private List<String> role;  // 管理员的角色名称列表
    private String state;  // 账号是否停用，0 或 1

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ManagerWithoutNameBean{" +
                "gid='" + gid + '\'' +
                ", role=" + role +
                ", state='" + state + '\'' +
                '}';
    }
}
