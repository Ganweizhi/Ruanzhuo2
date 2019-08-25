package com.dgut.jsonBean;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WuJiewei
 * 组合了GllistBean和总数目，是返回的json的封装
 */
public class GllistBeanPage implements Serializable {
    List<GllistBean> data;  // 数据域
    Integer totalPage;  // 数据总条数

    public GllistBeanPage()
    {

    }
    public GllistBeanPage(Map<Integer,GllistBean> data, int totalPage)
    {
        List<GllistBean> gllistBeans = new ArrayList<GllistBean>(data.values());  // Collection转List， 比较容易犯错

        this.data = gllistBeans;
//        System.out.println(data.values());  // 调试用
        this.totalPage = totalPage;
    }

    public List<GllistBean> getData() {
        return data;
    }

    public void setData(List<GllistBean> data) {
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
        return "GllistAndNumBean{" +
                "data=" + data +
                ", totalPage=" + totalPage +
                '}';
    }
}
