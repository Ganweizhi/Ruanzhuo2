package com.dgut.jsonBean;

import java.util.List;

/**
 * @author Wujiewei
 */
public class RoleListBeanPage {
    List<RoleListBean> data;
    Integer totalPage;

    public RoleListBeanPage() {

    }

    public RoleListBeanPage(List<RoleListBean> data, Integer totalPage) {
        this.data = data;
        this.totalPage = totalPage;
    }

    public List<RoleListBean> getRoleListBeanList() {
        return data;
    }

    public void setRoleListBeanList(List<RoleListBean> data) {
        this.data = data;
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
                "data=" + data +
                ", totalPage=" + totalPage +
                '}';
    }
}
