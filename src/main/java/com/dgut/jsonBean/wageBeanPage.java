package com.dgut.jsonBean;

import java.io.Serializable;
import java.util.List;

public class wageBeanPage  implements Serializable {
    List<wageBean> data;
    int totalPage;

    public wageBeanPage() {
    }

    public wageBeanPage(List<wageBean> data, int totalPage) {
        this.data = data;
        this.totalPage = totalPage;
    }

    public List<wageBean> getData() {
        return data;
    }

    public void setData(List<wageBean> data) {
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
        return "wageBeanPage{" +
                "data=" + data +
                ", totalPage=" + totalPage +
                '}';
    }
}
