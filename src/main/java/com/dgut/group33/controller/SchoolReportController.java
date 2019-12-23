package com.dgut.group33.controller;
import com.alibaba.fastjson.JSONObject;
import com.dgut.group22.service.CourseService;
import com.dgut.group33.javaBean.Class;
import com.dgut.group33.javaBean.SelectCourse;
import com.dgut.group33.javaBean.Student;
import com.dgut.group33.javaBean.Title;
import com.dgut.group33.service.CoursePlanService;
import com.dgut.group33.service.RosterService;
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
public class SchoolReportController {
    @Autowired
    RosterService rosterService;

    @Autowired
    CoursePlanService coursePlanService;
    @RequestMapping(value = "/ChungLife_dt_cjd/{page}", method = RequestMethod.POST)
    public String getHmc(@PathVariable String page) {
        int anInt = Integer.parseInt(page);
        List<Title> titleList = new ArrayList<>();
        List<Class> allClass = rosterService.findAllClass();
        for (int i = (anInt - 1) * 10; i < (anInt - 1) * 10 + 10 && i < allClass.size(); i++) {
            Title title=new Title();
            title.setTitle(allClass.get(i).getClass_name()+"成绩单");
            title.setContent_id(allClass.get(i).getClass_id());
            titleList.add(title);
        }
        JSONObject result = new JSONObject();
        result.put("data", titleList);
        return result.toJSONString();
    }

    @RequestMapping(value = "/ChungLife_dt_cjd_show/{content_id}", method = RequestMethod.POST)
    public String getHmcById(@PathVariable String content_id) {
        int class_id = Integer.parseInt(content_id);
        List<Student> students = rosterService.findStudentByCid(class_id);
        List<SelectCourse> selectCourses = new ArrayList<SelectCourse>();
        for (int i=0;i<students.size();i++){
            selectCourses.add(coursePlanService.findScoreById(students.get(i).getStudent_id()));
        }
        String title = rosterService.findClassById(class_id).getClass_name();
        JSONObject result = new JSONObject();
        result.put("title", title.concat("成绩单"));
        result.put("StudentList", selectCourses);
        return result.toJSONString();
    }
    @RequestMapping(value = "/ChungLife_dt_cjd/addSelectCourse",method = RequestMethod.POST)
    public String addSelectCourse(SelectCourse selectCourse){
        int res = coursePlanService.addSelectScore(selectCourse);
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
