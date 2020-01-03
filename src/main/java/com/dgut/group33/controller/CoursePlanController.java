package com.dgut.group33.controller;
import com.alibaba.fastjson.JSONObject;
import com.dgut.CCC_WYM.javabeans.successCourse;
import com.dgut.group33.javaBean.Course;
import com.dgut.group33.javaBean.CoursePlan;
import com.dgut.group33.javaBean.SuccessCourse;
import com.dgut.group33.javaBean.Title;
import com.dgut.group33.service.CoursePlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @RequestMapping(value = "/ChungLife_dt/QQ_upload", method = RequestMethod.POST)
    public String QQupload(@RequestParam("file")MultipartFile pic,  HttpServletRequest request) throws IOException {
        JSONObject result = new JSONObject();
        String realPath = request.getServletContext().getRealPath("/beforeTable/group_image/qq_image");
        File folder = new File(realPath);
        if(!folder.exists())
        {
            folder.mkdirs();
        }
        String oldname = pic.getOriginalFilename();
        String newName = UUID.randomUUID().toString()+"_"+"QQ"+"_"+oldname.substring(oldname.lastIndexOf("."));
        pic.transferTo(new File(folder,newName));
       // String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/group_image/qq_image/" + newName;

        result.put("msg","上传成功");
        result.put("url",newName);

        return result.toJSONString();
    }

    @RequestMapping(value = "/ChungLife_dt/weixin_upload", method = RequestMethod.POST)
    public String WXupload(@RequestParam("file")MultipartFile pic,  HttpServletRequest request) throws IOException {
        JSONObject result = new JSONObject();
        String realPath = request.getServletContext().getRealPath("/beforeTable/group_image/wechat_image");
        File folder = new File(realPath);
        if(!folder.exists())
        {
            folder.mkdirs();
        }
        String oldname = pic.getOriginalFilename();
        String newName = UUID.randomUUID().toString()+"_"+"wechat"+"_"+oldname.substring(oldname.lastIndexOf("."));
        pic.transferTo(new File(folder,newName));
       // String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/group_image/wechat_image/" + newName;

        result.put("msg","上传成功");
        result.put("url",newName);

        return result.toJSONString();
    }

    //添加信息到开课计划中
    @RequestMapping(value = "/ChungLife_dt/addSuccessCourse", method = RequestMethod.POST)
    public String addSuccessCourse(SuccessCourse successCourse){
        System.out.println(successCourse);
        JSONObject result = new JSONObject();
         int res =coursePlanService.addSuccessCourse(successCourse);
         if(res>0){
             result.put("msg","上传成功");
         }else {
             result.put("msg","上传失败！");
         }
        return result.toJSONString();
    }
}
