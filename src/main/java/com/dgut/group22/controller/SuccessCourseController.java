package com.dgut.group22.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dgut.group22.javaBean.Course;
import com.dgut.group22.javaBean.SuccessCourse;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.service.CourseService;
import com.dgut.group22.service.SuccessCourseService;
import com.dgut.group22.service.TeacherService;
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
@RequestMapping("/successCourse")
public class SuccessCourseController {
    @Autowired
    SuccessCourseService successCourseService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/findAllsuccessCourse/{page}",method = {RequestMethod.POST})
    public String findAllsuccessCourse(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<SuccessCourse> successCourse = new ArrayList<>();
        List<SuccessCourse> allSuccessCourse = successCourseService.findAllSuccessCourse();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allSuccessCourse.size(); i++){
            successCourse.add(allSuccessCourse.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allSuccessCourse.size()%9==0?0:1;

        jsonObject.put("page",allSuccessCourse.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",successCourse);
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/findSuccessCourseMsg/{teacher_id}&{course_id}",method = {RequestMethod.POST})
    public String findSuccessCourseMsg(@PathVariable("teacher_id") String teacher_id,@PathVariable("course_id") String course_id){
        Teacher teacher = teacherService.findById(teacher_id);
        Course course=courseService.findById(course_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teacher",teacher);
        jsonObject.put("course",course);
        return jsonObject.toJSONString();
    }
}
