package com.dgut.CCC_WYM.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dgut.CCC_WYM.javabeans.*;
import com.dgut.CCC_WYM.services.uploadServices;
import org.apache.ibatis.annotations.Param;
//import org.jboss.logging.FormatWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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
public class GroupImageUpload {
    @Autowired
    private uploadServices Upload;
    @RequestMapping("/tests")
    @ResponseBody
    public String getss()
    {
        return Upload.getAllSuccessCourse().toString();
    }
    @RequestMapping("/QQ_upload")
    public String QQupload(MultipartFile pic,@Param("success_id")String success_id, HttpServletRequest request) throws IOException {

       System.out.println(pic+success_id);
       String realPath = request.getServletContext().getRealPath("/beforeTable/group_image/qq_image");
       File folder = new File(realPath);
       if(!folder.exists())
       {
           folder.mkdirs();
       }
       String oldname = pic.getOriginalFilename();
       String newName = success_id+"_"+"QQ"+"_"+oldname.substring(oldname.lastIndexOf("."));
       pic.transferTo(new File(folder,newName));
       String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/group_image/qq_image/" + newName;
       System.out.println(url);
       Upload.setQQimage(newName,success_id);
       return "redirect:afterTable/super_admin.html";
   }
   @RequestMapping("/getCourse_id")
   @ResponseBody
   public String getAllCourse_id()
   {
       List<course> corseList = new ArrayList<>();
       List<course> course = Upload.getCourse();
       JSONObject jsonObject = new JSONObject();
       for(int i = 0;i<course.size();i++)
       {
           corseList.add(course.get(i));
       }
       int i = 0;
       for(course s:corseList)
       {
           jsonObject.put(i+"",s);
           i++;
       }
       jsonObject.put("size",i);
       return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
   }
   @RequestMapping("/getTeacher_id")
   @ResponseBody
   public String getTeacher()
   {
       List<teacher> teachers = Upload.getSuccessCourseTacher();
       JSONObject jsonObject = new JSONObject();
       int i = 0;
       for(teacher t:teachers)
       {
           jsonObject.put(i+"",t);
           i++;
       }
       jsonObject.put("size",i);
       return  JSON.toJSONString(jsonObject,SerializerFeature.DisableCircularReferenceDetect);
   }
    @RequestMapping("/getSuccess_id")
    @ResponseBody
    public String getSuccess_id()
    {
      List<success_id> success_ids= Upload.getALLsucessIdForQQ();
        JSONObject jsonObject = new JSONObject();
        int i = 0;
        for(success_id t:success_ids)
        {
            jsonObject.put(i+"",t);
            i++;
        }
        jsonObject.put("size",i);
        return  JSON.toJSONString(jsonObject,SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/QQ_find/{page}")
    @ResponseBody
    public String getQQPages(@PathVariable("page")String page)
    {
          List<image_qq> AllQQ = Upload.getAllQQImage();
          int total = AllQQ.size();
          int totalPage;
          if(total%3==0) totalPage = total/3;
          else totalPage = total/3+1;
          JSONObject jsonObject = new JSONObject();
          int i = 0;
          int pages = Integer.valueOf(page);
         if(pages<=0) pages=1;
         if(pages>=totalPage) pages=totalPage;
          if(total<=3){
              for(image_qq s:AllQQ)
              {
                  jsonObject.put(i+"",s);
                  i++;
              }
          }else {
              for (int m = (pages - 1) * 3; m < total; m++) {
                  if (i >= 3) break;
                  jsonObject.put(i + "", AllQQ.get(m));
                  i++;
              }
          }
              if(i==3)jsonObject.put("size",3);
              else jsonObject.put("size",i);
              jsonObject.put("curPage",pages);
              jsonObject.put("totalPage",totalPage);
        return JSON.toJSONString(jsonObject,SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("/jiaoxuehudong_QQ/{page}")
    @ResponseBody
    public String getBeforeQQ(@PathVariable("page")String page)
    {
        List<beforeQQ> beforeQQS = Upload.getBeforeQQ();
        int total = beforeQQS.size();
        int totalPage;
        if(total%3==0) totalPage = total/3;
        else totalPage = total/3+1;
        JSONObject jsonObject = new JSONObject();
        int i = 0;
        int pages = Integer.valueOf(page);
        if(pages<=0) pages=1;
        if(pages>=totalPage) pages=totalPage;
        if(total<=3){
            for(beforeQQ s:beforeQQS)
            {
                jsonObject.put(i+"",s);
                i++;
            }
        }else {
            for (int m = (pages - 1) * 3; m < total; m++) {
                if (i >= 3) break;
                jsonObject.put(i + "", beforeQQS.get(m));
                i++;
            }
        }
        if(i==3)jsonObject.put("size",3);
        else jsonObject.put("size",i);
        jsonObject.put("curPage",pages);
        jsonObject.put("totalPage",totalPage);
        return JSON.toJSONString(jsonObject,SerializerFeature.DisableCircularReferenceDetect);
    }




    @RequestMapping("/QQ_Delete/{id}")
    @ResponseBody
    public String deletQQ(@PathVariable("id") String id)
    {
        System.out.println(id);
        Upload.delete(id);
        return null;
    }
}
