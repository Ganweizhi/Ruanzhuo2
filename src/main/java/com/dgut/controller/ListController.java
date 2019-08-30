package com.dgut.controller;
import com.dgut.jsonBean.*;
import com.dgut.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private ManagersService managersService;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GetDepPower GetdepPower;
    @Autowired
    private UserFileService userFileService;
    @RequestMapping(value = "/init")
    public String getNewWid(){
        int wid = listservice.getNewWid()+2019500;
        return "{\"wid\":"+wid+"}";
    }

    @RequestMapping(value = "/inlist", method = RequestMethod.POST)
    public String add(@RequestBody List<outlistBean> msgForm){
        if(managersService.findPagePower(3)) return "{\"success\":3}";
        for (outlistBean bean : msgForm) {
            bean.setDepartment(listservice.getDepartmentIDByName(bean.getDepartment()));
            bean.setSex(bean.getSex().equals("男")?"0":"1");
            switch (bean.getBankName()){
                case "中国工商银行": bean.setBankName("0");break;
                case "中国农业银行": bean.setBankName("1");break;
                case "中国建设银行": bean.setBankName("2");break;
                case "中国招商银行": bean.setBankName("3");break;
                case "中国交通银行": bean.setBankName("4");break;
                case "邮政储蓄银行": bean.setBankName("5");break;
            }
            switch (bean.getIdType()){
                case "身份证": bean.setIdType("0");break;
                case "港澳居民来往内地通行证": bean.setIdType("1");break;
                case "台湾居民来往大陆通行证": bean.setIdType("2");break;
                case "护照": bean.setIdType("3");break;
                case "外国人永久居留证": bean.setIdType("4");break;
                case "其他国家或地区身份证明": bean.setIdType("5");break;
            }
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
        if(managersService.findPagePower(2)) return "{\"success\":3}";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        listservice.deleteByWid(wid,df.format(new Date()));
        return "{\"success\":1}";
    }

    @RequestMapping(value = "/outlist")
    @ResponseBody
    public List<outlistBean> getOutlist(String department, String education, String search, String stime, String etime,@SessionAttribute Manager manager) {
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
        for (outlistBean bean : data) {
            bean.setSex(bean.getSex().equals("0")?"男":"女");
            switch (bean.getBankName()){
                case "0": bean.setBankName("中国工商银行");break;
                case "1": bean.setBankName("中国农业银行");break;
                case "2": bean.setBankName("中国建设银行");break;
                case "3": bean.setBankName("中国招商银行");break;
                case "4": bean.setBankName("中国交通银行");break;
                case "5": bean.setBankName("邮政储蓄银行");break;
            }
            switch (bean.getIdType()){
                case "0": bean.setIdType("身份证");break;
                case "1": bean.setIdType("港澳居民来往内地通行证");break;
                case "2": bean.setIdType("台湾居民来往大陆通行证");break;
                case "3": bean.setIdType("护照");break;
                case "4": bean.setIdType("外国人永久居留证");break;
                case "5": bean.setIdType("其他国家或地区身份证明");break;
            }
        }
        String depPower = GetdepPower.getDepPower(manager.getUsername());
        StringBuilder sb = new StringBuilder(depPower).reverse();
        data = data.stream().filter(bean ->sb.charAt(Integer.parseInt(bean.getDepartment()))=='1').collect(Collectors.toList());

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
    public listBeanPage getList(String department,String education,String search , String stime,String etime,String currentPage,@SessionAttribute Manager manager) throws ParseException {
        if(managersService.findPagePower(0)) return new listBeanPage(null,-1);
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

        String depPower = GetdepPower.getDepPower(manager.getUsername());
        StringBuilder sb = new StringBuilder(depPower).reverse();
        data = data.stream().filter(bean ->sb.charAt(Integer.parseInt(bean.getDepartment()))=='1').collect(Collectors.toList());


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
        if(managersService.findPagePower(Integer.parseInt(index))) return "{\"success\":0}";
        else return "{\"success\":1}";

    }

    @RequestMapping(value = "/ryadd")
    public String add(){
        if(managersService.findPagePower(3)) return "{\"success\":0}";
        else return "{\"success\":1}";

    }
    @RequestMapping("/xctable")
    public List<baseWages> findBaseWages(String wid){
        return listservice.findBaseWages(wid);
    }

    @RequestMapping(value = "/loglist")
    @ResponseBody
    public LogBeanPage getList(String date,String gid,String name,String ip ,String currentPage) throws ParseException {
        if(managersService.findPagePower(4)) return new LogBeanPage(null,-1);
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
