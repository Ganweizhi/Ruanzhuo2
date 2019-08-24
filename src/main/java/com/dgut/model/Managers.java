package com.dgut.model;

import java.io.Serializable;

/**
 * @author WuJiewei
 * 管理员实体
 */
public class Managers implements Serializable {

    private Integer id;  // 莞工账号
    private String name; // 姓名
    private Integer state; // 登录状态，取值为0或1

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "managers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
