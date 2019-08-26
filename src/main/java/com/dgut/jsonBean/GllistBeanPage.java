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
    List<GllistChangeBean> data;  // 数据域
    Integer totalPage;  // 数据总条数

    public GllistBeanPage()
    {

    }
    public GllistBeanPage(Map<Integer,GllistChangeBean> datas, int totalPage)
    {
        List<GllistChangeBean> data = new ArrayList<GllistChangeBean>(datas.values());  // Collection转List， 比较容易犯错

        this.data = data;
        this.totalPage = totalPage;
    }

    public List<GllistChangeBean> getData() {
        return data;
    }

    public void setData(List<GllistChangeBean> data) {
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
        return "GllistBeanPage{" +
                "data=" + data +
                ", totalPage=" + totalPage +
                '}';
    }
}
