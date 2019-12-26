package com.dgut.group11.controller;


/*
lgc
 */

import com.alibaba.fastjson.JSONObject;
import com.dgut.group11.dao.AddEditDeleteDao;
import com.dgut.group11.javabean.*;
import com.dgut.group11.service.JiaoXueRiLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Contentb
Methodb
Planb
Problemb
RiLi
Teaching_program
 */

@RestController
@CrossOrigin(origins = "*")
public class AddEditDelete {

    @Autowired
    private AddEditDeleteDao addEditDeleteDao;
    @Autowired
    private JiaoXueRiLiService jiaoXueRiLiService;

    @RequestMapping(value="/listContentb",method = {RequestMethod.POST})
    public String listContentb(){

        List<Contentb> list = addEditDeleteDao.findAll1();

        for(Contentb l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listMethodb",method = {RequestMethod.POST})
    public String listMethodb(){

        List<Methodb> list = addEditDeleteDao.findAll2();

        for(Methodb l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listPlanb",method = {RequestMethod.POST})
    public String listPlanb(){

        List<Planb> list = addEditDeleteDao.findAll3();

        for(Planb l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(Integer.parseInt(l.getSuccess_id()));
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listProblemb",method = {RequestMethod.POST})
    public String listProblemb(){

        List<Problemb> list = addEditDeleteDao.findAll4();

        for(Problemb l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listCalendar",method = {RequestMethod.POST})
    public String listCalendar(){

        List<RiLi> list = addEditDeleteDao.findAll5();

        for(RiLi l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listTeaching_program",method = {RequestMethod.POST})
    public String listTeaching_program(){

        List<Teaching_program> list = addEditDeleteDao.findAll6();

        for(Teaching_program l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }



}
