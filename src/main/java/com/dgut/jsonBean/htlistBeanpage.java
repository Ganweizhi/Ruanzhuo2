package com.dgut.jsonBean;

import java.io.Serializable;
import java.util.List;

public class htlistBeanpage implements Serializable {
    List<htlistBean> data;
    int totalPage;
    public htlistBeanpage()
    {

    }
    public htlistBeanpage(List<htlistBean> data,int totalPage)
    {
        this.data=data;
        this.totalPage = totalPage;
    }

    public List<htlistBean> getData() {
        return data;
    }

    public void setData(List<htlistBean> data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    @Override
    public String  toString()
    {
        return "htListBenePage{"+
                "data='"+data+
                "totalPage='"+totalPage+
                '}';
    }
}
