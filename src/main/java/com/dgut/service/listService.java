package com.dgut.service;

import com.dgut.jsonBean.addBean;
import com.dgut.jsonBean.listBean;
import com.dgut.jsonBean.wageBean;
import com.dgut.mapper.staffMapper;
import com.dgut.model.staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class listService {
    @Autowired
    private staffMapper staffmapper;

    public List<staff> findOutlist(String department, String degree, String stime, String etime, String search){
        return staffmapper.findOutlist(department,  degree,  stime,  etime,  search);
    }

    public List<listBean> findList(String department, String degree, String stime, String etime, String search, String currentPage) {
        return staffmapper.findList( department,  degree,  stime,  etime,  search,  currentPage);
    }

    public void deleteByWid(String wid, String time) {
        staffmapper.deleteByWid(wid,time);
    }

    public int add(addBean bean) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = df.format(new Date());
        return staffmapper.add(bean,time);
    }

    public List<wageBean> findXclist(String department, String degree, String search) {
        return staffmapper.findXclist( department,  degree,  search);
    }
}
