package com.dgut.group22.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group22.javaBean.SuccessCourse;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.service.SuccessCourseService;
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
        return jsonObject.toJSONString();
    }
}
