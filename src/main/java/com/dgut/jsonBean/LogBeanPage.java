package com.dgut.jsonBean;

import java.util.List;

public class LogBeanPage {
    List<LogBean> data;
    int totalPage;

    public List<LogBean> getData() {
        return data;
    }

    public void setData(List<LogBean> data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public LogBeanPage(List<LogBean> data, int totalPage) {
        this.data = data;
        this.totalPage = totalPage;
    }

    public LogBeanPage() {
    }
}
