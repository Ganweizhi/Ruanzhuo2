package com.dgut.group33.controller;
import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.javaBean.Course;
import com.dgut.group33.javaBean.CoursePlan;
import com.dgut.group33.javaBean.Title;
import com.dgut.group33.service.CoursePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class CoursePlanController {
    @Autowired
    CoursePlanService coursePlanService;

    @RequestMapping(value = "/ChungLife_dt/{page}", method = RequestMethod.POST)
    public String getCoursePlan(@PathVariable String page) {
        int anInt = Integer.parseInt(page);
        List<CoursePlan> allCoursePlan=coursePlanService.findAllCoursePlan();
        List<Title> titleList=new ArrayList<>();
        for (int i = (anInt - 1) * 10; i < (anInt - 1) * 10 + 10 && i < allCoursePlan.size(); i++) {
            Title title=new Title();
            CoursePlan coursePlan=allCoursePlan.get(i);
            title.setTitle(coursePlan.getSpeciality().getAcademy().getAcademy_name()+coursePlan.getGrade()+"级"+coursePlan.getSpeciality().getSpeciality_name()+"开课计划");
            title.setContent_id(allCoursePlan.get(i).getCourse_plan_id());
            titleList.add(title);
        }
        JSONObject result = new JSONObject();
        result.put("data", titleList);
        return result.toJSONString();
    }
    @RequestMapping(value = "/ChungLife_dt_show/{content_id}", method = RequestMethod.POST)
    public String getCoursePlanById(@PathVariable String content_id) {
        int class_plan_id = Integer.parseInt(content_id);
        List<Course> courses = coursePlanService.findCourseByCpid(class_plan_id);
        CoursePlan coursePlan=coursePlanService.findCoursePlanById(class_plan_id);
        String title=coursePlan.getSpeciality().getAcademy().getAcademy_name()+coursePlan.getGrade()+"级"+coursePlan.getSpeciality().getSpeciality_name()+"开课计划";
        JSONObject result = new JSONObject();
        result.put("title", title);
        result.put("CourseList", courses);
        return result.toJSONString();
    }
    @RequestMapping(value = "/ChungLife_dt/addCoursePlan", method = RequestMethod.POST)
    public  String addCoursePlan(CoursePlan coursePlan){
        coursePlan.setSpeciality_id(1);
        int res = coursePlanService.addCoursePlan(coursePlan);
        JSONObject result = new JSONObject();
        if(res>0){

            result.put("msg", "添加成功");
            return result.toJSONString();
        }else {
            result.put("msg", "添加失败");
            return result.toJSONString();
        }
    }

    @RequestMapping(value = "/ChungLife_dt/addCourse", method = RequestMethod.POST)
    public  String addCoursePlan(Course course){
        int res = coursePlanService.addCourse(course);
        JSONObject result = new JSONObject();
        if(res>0){

            result.put("msg", "添加成功");
            return result.toJSONString();
        }else {
            result.put("msg", "添加失败");
            return result.toJSONString();
        }
    }
}
