package com.dgut.group22.controller;


import com.alibaba.fastjson.JSONObject;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.javaBean.Young;
import com.dgut.group22.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Ning
@RestController
@Transactional
@RequestMapping("/Teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/findById/{teacher_id}",method = {RequestMethod.POST})
    public String findById(@PathVariable("teacher_id")String teacher_id){
        Teacher teacher=teacherService.findById(teacher_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teacher",teacher);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/findAllYoungTeacher/{page}",method = {RequestMethod.POST})
    public String findAllYoungTeacher(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<Teacher> youngTeacher = new ArrayList<>();
        List<Teacher> allYoungTeacher = teacherService.findAllYoungTeacher();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allYoungTeacher.size(); i++){
            youngTeacher.add(allYoungTeacher.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allYoungTeacher.size()%9==0?0:1;

        jsonObject.put("page",allYoungTeacher.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",youngTeacher);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/findYoungById/{teacher_id}",method = {RequestMethod.POST})
    public String findYoungById(@PathVariable("teacher_id") String teacher_id){
        Young young = teacherService.findYoungById(teacher_id);
        Teacher teacher = teacherService.findById(teacher_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("young",young);
        jsonObject.put("teacher",teacher);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/findAllYoungTeacherAfter/{page}",method = {RequestMethod.GET})
    public String findAllYoungTeacherAfter(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<Teacher> youngTeacher = new ArrayList<>();
        List<Teacher> allYoungTeacher = teacherService.findAllYoungTeacher();

        System.out.println(allYoungTeacher);

        for(int i=(anInt-1)*5; i<(anInt-1)*5+5 && i<allYoungTeacher.size(); i++){
            youngTeacher.add(allYoungTeacher.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allYoungTeacher.size()%5==0?0:1;
        jsonObject.put("page",allYoungTeacher.size()/5+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",youngTeacher);
        return jsonObject.toJSONString();
    }


}
