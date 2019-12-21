package com.dgut.group22.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
