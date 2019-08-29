package com.dgut.controller;
import com.dgut.jsonBean.*;
import com.dgut.service.LogService;
import com.dgut.service.UserFileService;
import com.dgut.service.listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class ListController {

    @Autowired
    private LogService logservice;
    @Autowired
    private listService listservice;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserFileService userFileService;
    @RequestMapping(value = "/init")
    public String getNewWid(){
        int wid = listservice.getNewWid()+2019500;
        return "{\"wid\":"+wid+"}";
    }

    @RequestMapping(value = "/inlist", method = RequestMethod.POST)
    public String add(@RequestBody List<outlistBean> msgForm){
        System.out.println(msgForm);
        for (outlistBean bean : msgForm) {
            bean.setDepartment(listservice.getDepartmentIDByName(bean.getDepartment()));
            listservice.addInList(bean);
        }
        return "{\"success\":1}";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody addBean msgForm){
        String name = listservice.getNameByWid(msgForm.getWid());
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(msgForm.getDepartment());
        if( !isNum.matches() ){
            msgForm.setDepartment(listservice.getDepartmentIDByName(msgForm.getDepartment()));
        }
        int state;
        if(name!=null){
            state = listservice.updateMessage(msgForm);
        }else {
            state = listservice.add(msgForm);
        }
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
    public List<outlistBean> getOutlist(String department, String education, String search, String stime, String etime) {
        if(department.equals("")) {
            department = null;
        }
        if(education.equals("")) {
            education = null;
        }
        if(search.equals("")) {
            search = null;
        }

        List<outlistBean> data = listservice.findOutlist(department, education,search);
        for (outlistBean datum : data) {
            List<String> list = listservice.findSigningTimeByWid(datum.getWid());
            if(list.size()!=0) {
                Collections.sort(list);
                datum.setSigningTime(list.get(list.size() - 1));
            }
            datum.setDepartment(listservice.getDepartmentNameByID(datum.getDepartment()));
        }
        if(!stime.equals("")) {
            String[] split = stime.split(",");
            data = data.stream().filter(bean -> bean.getSigningTime()!=null).collect(Collectors.toList());
            data = data.stream().filter(bean -> bean.getSigningTime().compareTo(split[0]) >= 0 && bean.getSigningTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }

        if(!etime.equals("")) {
            String[] split = etime.split(",");
            data = data.stream().filter(bean -> bean.getDepartureTime()!=null).collect(Collectors.toList());
            data = data.stream().filter(bean -> bean.getDepartureTime().compareTo(split[0]) >= 0 && bean.getDepartureTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }
        return data;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public listBeanPage getList(String department,String education,String search , String stime,String etime,String currentPage) throws ParseException {
        if(department.equals("")) {
            department = null;
        }
        if(education.equals("")) {
            education = null;
        }
        if(search.equals("")) {
            search = null;
        }

        List<listBean> data = listservice.findList(department, education, search);
        for (listBean datum : data) {
            List<String> list = listservice.findSigningTimeByWid(datum.getWid());
            if(list.size()!=0) {
                Collections.sort(list);
                datum.setSigningTime(list.get(list.size() - 1));
            }
            datum.setDepartment(listservice.getDepartmentNameByID(datum.getDepartment()));
            datum.setState(listservice.getStateByWid(datum.getWid()));
        }
        if(!stime.equals("")) {
            String[] split = stime.split(",");
            data = data.stream().filter(bean -> bean.getSigningTime()!=null).collect(Collectors.toList());
            data = data.stream().filter(bean -> bean.getSigningTime().compareTo(split[0]) >= 0 && bean.getSigningTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }

        if(!etime.equals("")) {
            String[] split = etime.split(",");
            data = data.stream().filter(bean -> bean.getDepartureTime()!=null).collect(Collectors.toList());
            data = data.stream().filter(bean -> bean.getDepartureTime().compareTo(split[0]) >= 0 && bean.getDepartureTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
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
    @RequestMapping("/xctable")
    public List<baseWages> findBaseWages(String wid){
        return listservice.findBaseWages(wid);
    }

    @RequestMapping(value = "/loglist")
    @ResponseBody
    public LogBeanPage getList(String date,String gid,String name,String ip ,String currentPage) throws ParseException {
        if(gid.equals("")) {
            gid = null;
        }
        if(name.equals("")) {
            name = null;
        }
        if(ip.equals("")){
            ip = null;
        }

        List<LogBean> data = logservice.findList(gid, name,ip);
        if(!date.equals("")) {
            String[] split = date.split(",");
            data = data.stream().filter(bean -> bean.getDate()!=null).collect(Collectors.toList());
            data = data.stream().filter(bean -> bean.getDate().compareTo(split[0]) >= 0 && bean.getDate().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }

        int start = (Integer.parseInt(currentPage)-1)*7;
        int end = start+7>data.size()?data.size():start+7;
        List<LogBean> datas = data.subList(start,end);
        LogBeanPage logBeanPage = new LogBeanPage(datas,data.size());
        return logBeanPage;
    }
}
