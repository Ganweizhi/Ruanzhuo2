package com.dgut.controller;
import com.dgut.jsonBean.addBean;
import com.dgut.jsonBean.listBean;
import com.dgut.jsonBean.listBeanPage;
import com.dgut.model.staff;
import com.dgut.service.listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class ListController {

    @Autowired
    private listService listservice;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody addBean msgForm){
        int state = listservice.add(msgForm);
        System.out.println(msgForm.toString());
        if(state==1)
            return "{\"success\":1}";
        else
            return "{\"success\":0}";
    }

    @RequestMapping(value = "/delete")
    public String deleteByWid(String wid){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        listservice.deleteByWid(wid,df.format(new Date()));
        return "{\"success\":1}";
    }

    @RequestMapping(value = "/outlist")
    @ResponseBody
    public List<staff> getOutlist(String department, String education, String stime, String etime, String search) {
        if(department.equals("")) {
            department = null;
        }
        if(education.equals("")) {
            education = null;
        }
        if(search.equals("")) {
            search = null;
        }

        List<staff> data = listservice.findOutlist(department, education, stime, etime, search);
        if(!stime.equals("")) {
            String[] split = stime.split(",");
            data = data.stream().filter(bean -> bean.getSigningTime().compareTo(split[0]) >= 0 && bean.getSigningTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }

        if(!etime.equals("")) {
            String[] split = etime.split(",");
            data = data.stream().filter(bean -> bean.getDepartureTime().compareTo(split[0]) >= 0 && bean.getDepartureTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }
        for (staff datum : data) {
            datum.setDepartment(listservice.getDepartmentNameByID(datum.getDepartment()));
        }
        return data;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public listBeanPage getList(String department, String education, String stime, String etime, String search ,String currentPage) {
        //System.out.println(stime + " " + etime);
        if(department.equals("")) {
            department = null;
        }
        if(education.equals("")) {
            education = null;
        }
        if(search.equals("")) {
            search = null;
        }

        List<listBean> data = listservice.findList(department, education, stime, etime, search, currentPage);
        if(!stime.equals("")) {
            String[] split = stime.split(",");
            data = data.stream().filter(bean -> bean.getSigningTime().compareTo(split[0]) >= 0 && bean.getSigningTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }

        if(!etime.equals("")) {
            String[] split = etime.split(",");
            data = data.stream().filter(bean -> bean.getDepartureTime().compareTo(split[0]) >= 0 && bean.getDepartureTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }
        for (listBean datum : data) {
            datum.setDepartment(listservice.getDepartmentNameByID(datum.getDepartment()));
        }
        int start = (Integer.parseInt(currentPage)-1)*7;
        int end = start+7>data.size()?data.size():start+7;
        List<listBean> datas = data.subList(start,end);
        listBeanPage listBeanPage = new listBeanPage(datas,data.size());
        return listBeanPage;
    }

    @RequestMapping(value = "/edit")
    public String add(String index){
        return "{\"success\":1}";

    }

    @RequestMapping(value = "/ryadd")
    public String add(){
        return "{\"success\":1}";

    }
}
