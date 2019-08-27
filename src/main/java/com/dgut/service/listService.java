package com.dgut.service;

import com.dgut.jsonBean.*;
import com.dgut.mapper.staffMapper;
import com.dgut.model.staff;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class listService {
    @Autowired
    private staffMapper staffmapper;

    public String getDepartmentNameByID(String department){
        return staffmapper.getDepartmentNameByID(department);
    }

    public List<outlistBean> findOutlist(String department, String education, String search){
        return staffmapper.findOutlist(department,  education,search);
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

    public String findSigningTimeByWid(String wid) {
        return staffmapper.findSigningTimeByWid(wid);
    }

    public void addInList(outlistBean bean) {
        staffmapper.addInList(bean);
    }

    public int getNewWid() {
        return staffmapper.getNewWid();
    }

    public String getDepartmentIDByName(String name) {
        return staffmapper.getDepartmentIDByName(name);
    }


    public String getStateByWid(String wid) throws ParseException {
        List<emailBean> data = staffmapper.getHtsByWid(wid);
        String departureTime = staffmapper.getDepartureTimeByWid(wid);
        if(departureTime!=null)
            return "0";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        for (emailBean bean : data) {
            Date dt=sdf.parse(bean.getSigningTime());
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.MONTH,Integer.parseInt(bean.getUseTime()));
            Date dt1=rightNow.getTime();
            long days=(today.getTime()-dt1.getTime())/(1000*3600*24);
            if(days<0)
                return "1";
        }
        return "0";
    }


}
