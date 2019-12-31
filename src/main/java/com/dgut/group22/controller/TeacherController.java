package com.dgut.group22.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dgut.group22.javaBean.SuccessCourse;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.javaBean.Young;
import com.dgut.group22.service.SuccessCourseService;
import com.dgut.group22.service.TeacherService;
import com.dgut.group22.service.YoungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//Ning
@RestController
@Transactional
@RequestMapping("/Teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    YoungService youngService;

    @Autowired
    SuccessCourseService successCourseService;

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

    @RequestMapping(value = "/findAllYoungTeacherAfter/{page}",method = {RequestMethod.POST})
    public String findAllYoungTeacherAfter(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<Teacher> youngTeacher = new ArrayList<>();
        List<Teacher> allYoungTeacher = teacherService.findAllYoungTeacher();

        for(int i=(anInt-1)*5; i<(anInt-1)*5+5 && i<allYoungTeacher.size(); i++){
            youngTeacher.add(allYoungTeacher.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allYoungTeacher.size()%5==0?0:1;
        jsonObject.put("page",allYoungTeacher.size()/5+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",youngTeacher);
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/findYoungByIdAfter/{teacher_id}",method = {RequestMethod.POST})
    public String findYoungByIdAfter(@PathVariable("teacher_id") String teacher_id){
        Young young=youngService.findYoungById(teacher_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("young",young);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/updateYoungTeacherAfter",method = {RequestMethod.POST})
    public String updateYoungTeacherAfter(Young young){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try {
            flag = youngService.updateYoung(young);
        }
        catch (Exception e){
            flag="0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else
            jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/deleteYoungTeacherAfter/{teacher_id}",method = {RequestMethod.POST})
    public String deleteYoungTeacherAfter(@PathVariable("teacher_id") String teacher_id){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try {
            flag = youngService.deleteYoung(teacher_id);
        }
        catch (Exception e){
            flag="0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else
            jsonObject.put("data","失败");
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/addYoungTeacherAfter",method = {RequestMethod.POST})
    public String addYoungTeacherAfter(Young young){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try {
            flag = youngService.addYoung(young);
        }
        catch (Exception e){
            flag="0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else
            jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/findAllSuccessCourse/{page}",method = {RequestMethod.POST})
    public String findAllSuccessCourse(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<SuccessCourse> successCourses=new ArrayList<>();
        List<SuccessCourse> allSuccessCourse= successCourseService.findAllSuccessCourse();
        for(int i=(anInt-1)*5; i<(anInt-1)*5+5 && i<allSuccessCourse.size(); i++){
            successCourses.add(allSuccessCourse.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allSuccessCourse.size()%5==0?0:1;
        jsonObject.put("page",allSuccessCourse.size()/5+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",successCourses);
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/deleteSuccessCourse/{success_id}",method = {RequestMethod.POST})
    public String deleteSuccessCourse(@PathVariable("success_id") String success_id){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try {
            flag=successCourseService.deleteSuccessCourse(success_id);
        }
        catch (Exception e){
            flag="0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else
            jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }

    //修改教师头像
    @RequestMapping(value = "/changeTeacherPhoto/{teacher_id}",method = {RequestMethod.POST})
    public String changeTeacherPhoto(MultipartFile upload, @PathVariable("teacher_id") String teacher_id){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try{
            String downloadFilePath =System.getProperty("user.dir");
            downloadFilePath =downloadFilePath+"\\src\\main\\webapp\\beforeTable\\images";
            File file = new File(downloadFilePath);
            if(!file.exists()){
                file.mkdirs();
            }
            String fileName = upload.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName = teacher_id+suffixName;
            upload.transferTo(new File(downloadFilePath,fileName));
            Teacher teacher = teacherService.findById(teacher_id);
            teacher.setTeacher_photo("image/"+fileName);
            teacherService.updateTeacher(teacher);
            flag="1";
        }
        catch (Exception e){
            flag="0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }

    //修改教师信息
    @RequestMapping(value = "/editTeacher",method = {RequestMethod.POST})
    public String editTeacher(Teacher teacher){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try{
            teacherService.updateTeacher(teacher);
        }
        catch (Exception e){
            flag="0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }
}
