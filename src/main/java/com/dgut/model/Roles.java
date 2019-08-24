package com.dgut.model;

import java.io.Serializable;

/**
 * @author WuJiewei
 * 角色实体
 */
public class Roles implements Serializable {

    private Integer id;  // 主键，从零递增
    private String name;  // 角色名称
    private String pagePower;  // 页面权限
    private String departmentPower;  // 部门权限

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

    public String getPagePower() {
        return pagePower;
    }

    public void setPagePower(String pagePower) {
        this.pagePower = pagePower;
    }

    public String getDepartmentPower() {
        return departmentPower;
    }

    public void setDepartmentPower(String departmentPower) {
        this.departmentPower = departmentPower;
    }

    @Override
    public String toString() {
        return "roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pagePower='" + pagePower + '\'' +
                ", departmentPower='" + departmentPower + '\'' +
                '}';
    }
}
