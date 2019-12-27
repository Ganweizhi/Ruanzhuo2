package com.dgut.CCC_WYM.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dgut.CCC_WYM.services.uploadServices;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class interaction {
    @Autowired
    private uploadServices Upload;
    @RequestMapping("/tests")
    @ResponseBody
    public String getss()
    {
        return Upload.getAllSuccessCourse().toString();
    }
   @RequestMapping("/QQ_upload")
    public String QQupload(MultipartFile pic,@Param("username")String username,@Param("course_id")String course_id,@Param("teacher_id")String teacher_id,HttpServletRequest request) throws IOException {

       System.out.println(pic+username+course_id+teacher_id);
       String realPath = request.getServletContext().getRealPath("/group_image/qq_image");
       File folder = new File(realPath);
       if(!folder.exists())
       {
           folder.mkdirs();
       }
       String oldname = pic.getOriginalFilename();
       String newName = username+"_"+course_id+"_"+oldname;
       pic.transferTo(new File(folder,newName));
       String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/group_image/qq_image/" + newName;
       System.out.println(url);
       return "redirect:QQ_group-add.html";
   }
   @RequestMapping("/getCourse_id")
   @ResponseBody
   public String getAllCourse_id()
   {
       List<String> corseList = new ArrayList<>();
       List<String> course = Upload.getCourse_Id();
       JSONObject jsonObject = new JSONObject();
       for(int i = 0;i<course.size();i++)
       {
           corseList.add(course.get(i));
       }
       for(String s:corseList)
       {
           jsonObject.put("course_id",s);
           jsonObject.put("course_id",s);
       }
       return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
   }

}
