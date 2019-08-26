package com.dgut.jsonBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuJiewei
 * 对GllistBean的改进，与前端的json格式吻合
 */
public class GllistChangeBean implements Serializable {

    private Integer gid;  // 管理员莞工账号
    private String name;  // 管理员名称
    private List<String> roles;  // 管理员的角色名称列表
    private Integer state;  // 账号是否停用，0 或 1

    public GllistChangeBean (Integer gid, String name, List<String> roles, Integer state) {
        this.gid = gid;
        this.name = name;
        this.roles = roles;
        this.state = state;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "GllistChangeBean{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                ", state=" + state +
                '}';
    }
}
