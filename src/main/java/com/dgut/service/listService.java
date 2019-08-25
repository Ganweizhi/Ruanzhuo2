package com.dgut.service;

import com.dgut.jsonBean.addBean;
import com.dgut.jsonBean.addWageBean;
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

    public String getDepartmentNameByID(String department){
        return staffmapper.getDepartmentNameByID(department);
    }

    public List<staff> findOutlist(String department, String education, String stime, String etime, String search){
        return staffmapper.findOutlist(department,  education,  stime,  etime,  search);
    }

    public List<listBean> findList(String department, String education, String search) {
        return staffmapper.findList( department,  education,  search);
    }

    public void deleteByWid(String wid, String time) {
        staffmapper.deleteByWid(wid,time);
    }

    public int add(addBean bean) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = df.format(new Date());
        return staffmapper.add(bean,time);
    }

    public List<wageBean> findXclist(String department, String education, String search) {
        return staffmapper.findXclist( department,  education,  search);
    }

    public void Xcedit(addWageBean xcForm) {
        staffmapper.Xcedit(xcForm);
    }
}
