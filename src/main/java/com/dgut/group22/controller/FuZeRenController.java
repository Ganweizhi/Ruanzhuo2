package com.dgut.group22.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group22.dao.ICourseDao;
import com.dgut.group22.javaBean.Course;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.service.CourseService;
import com.dgut.group22.service.FuZeRenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Ning
@RestController
@RequestMapping("/FuZeRen")
public class FuZeRenController {
    @Autowired
    FuZeRenService fuZeRenService;
    @Autowired
    CourseService courseService;

    @RequestMapping(value="/findAllFuZeRen/{page}",method = {RequestMethod.POST})
    public String findAllFuZeRen(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<Teacher> fuZeRen = new ArrayList<>();
        List<Teacher> allFuZeRen = fuZeRenService.findAllFuZeRen();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allFuZeRen.size(); i++){
            fuZeRen.add(allFuZeRen.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allFuZeRen.size()%9==0?0:1;

        jsonObject.put("page",allFuZeRen.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",fuZeRen);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/findFuZeRenById/{teacher_id}/{course_id}",method = {RequestMethod.GET})
    @ResponseBody
    public String  findFuZeRenId(@PathVariable("teacher_id")String teacher_id,@PathVariable ("course_id") String course_id){
        Teacher fuZeRen = fuZeRenService.findFuZeRenById(teacher_id);
        Course course=courseService.findById(course_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",fuZeRen);
        jsonObject.put("data",course);
        return jsonObject.toJSONString();
    }

}
