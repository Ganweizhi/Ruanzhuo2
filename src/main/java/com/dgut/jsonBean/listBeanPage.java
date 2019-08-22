package com.dgut.jsonBean;

import java.io.Serializable;
import java.util.List;

public class listBeanPage implements Serializable {
    List<listBean> data;
    int totalPage;

    public listBeanPage() {
    }

    public listBeanPage(List<listBean> data, int totalPage) {
        this.data = data;
        this.totalPage = totalPage;
    }

    public List<listBean> getData() {
        return data;
    }

    public void setData(List<listBean> data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "listBeanPage{" +
                "data=" + data +
                ", totalPage=" + totalPage +
                '}';
    }
}
