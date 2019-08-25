package com.dgut.jsonBean;

import java.util.List;

/**
 * @author Wujiewei
 */
public class RoleListBeanPage {
    List<RoleListBean> roleListBeanList;
    Integer totalPage;

    public RoleListBeanPage() {

    }

    public RoleListBeanPage(List<RoleListBean> roleListBeans, Integer totalPage) {
        this.roleListBeanList = roleListBeans;
        this.totalPage = totalPage;
    }

    public List<RoleListBean> getRoleListBeanList() {
        return roleListBeanList;
    }

    public void setRoleListBeanList(List<RoleListBean> roleListBeanList) {
        this.roleListBeanList = roleListBeanList;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "RoleListBeanPage{" +
                "roleListBeanList=" + roleListBeanList +
                ", totalPage=" + totalPage +
                '}';
    }
}
