package com.dgut.CCC_WYM.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dgut.CCC_WYM.javabeans.Webquestion;
import com.dgut.CCC_WYM.javabeans.image_qq;
import com.dgut.CCC_WYM.javabeans.webTitle;
import com.dgut.CCC_WYM.services.uploadServices;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Queue;

@Controller
public class WebUpload {
    @Autowired
    private uploadServices Upload;

    @RequestMapping("/Webquestion")
   public String webQuestion(@Param("name")String name,@Param("title")String title,@Param("times")String times,@Param("content")String content)
    {
        System.out.println(name+title);
        Upload.webUpload(name,title,times,content);
        return "redirect:afterTable/student.html";
    }
   @RequestMapping("/returnsign_find/{Page}")
   @ ResponseBody
    public String getWebPages(@PathVariable("Page")String Page)
   {
       List<webTitle> AllQQ = Upload.getAllTitle();
       int total = AllQQ.size();
       int totalPage;
       if(total%3==0) totalPage = total/3;
       else totalPage = total/3+1;
       JSONObject jsonObject = new JSONObject();
       int i = 0;
       int pages = Integer.valueOf(Page);
       if(pages<=0) pages=1;
       if(pages>=totalPage) pages=totalPage;
       if(total<=3){
           for(webTitle s:AllQQ)
           {
               try {
                   if (s.getAnswer().isEmpty()) s.setAnswer("暂未回答");
               }catch (Exception ex)
               {
                   s.setAnswer("暂未回答");
               }
               jsonObject.put(i+"",s);
               i++;
           }
       }else {
           for (int m = (pages - 1) * 3; m < total; m++) {
               if (i >= 3) break;
               try{
                   if(AllQQ.get(m).getAnswer().isEmpty())AllQQ.get(m).setAnswer("暂未回答");
               }catch (Exception ex)
               {
                   AllQQ.get(m).setAnswer("暂未回答");
               }
               jsonObject.put(i + "", AllQQ.get(m));
               i++;
           }
       }
       if(i==3)jsonObject.put("size",3);
       else jsonObject.put("size",i);
       jsonObject.put("curPage",pages);
       jsonObject.put("totalPage",totalPage);
       return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
   }
   @RequestMapping("/jiaoxuehudong_wangye/{page}")
   @ResponseBody
   public String getAllQuestion(@PathVariable("page")String page)
   {
       List<webTitle>  webTitles  = Upload.getAllTitle();
       int total = webTitles.size();
       int totalPage;
       if(total%6==0) totalPage = total/6;
       else totalPage = total/6+1;
       JSONObject jsonObject = new JSONObject();
       int i = 0;
       int pages = Integer.valueOf(page);
       if(pages<=0) pages=1;
       if(pages>=totalPage) pages=totalPage;
       if(total<=6){
           for(webTitle s:webTitles)
           {
             try {
               if(s.getAnswer().isEmpty());
             }catch (Exception ex )
             {
                 s.setAnswer("暂未回答");
             }
               jsonObject.put(i+"",s);
               i++;
           }
       }else {
           for (int m = (pages - 1) * 6; m < total; m++) {
               if (i >= 6) break;
               try {
                   if(webTitles.get(m).getAnswer().isEmpty());
               }catch (Exception ex )
               {
                   webTitles.get(m).setAnswer("暂未回答");
               }

              // if(webTitles.get(m).getAnswer().isEmpty())webTitles.get(m).setAnswer("暂未回答");
               jsonObject.put(i + "", webTitles.get(m));
               i++;
           }
       }
       if(i==6)jsonObject.put("size",6);
       else jsonObject.put("size",i);
       jsonObject.put("curPage",pages);
       jsonObject.put("totalPage",totalPage);
       return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
   }
   @RequestMapping("/wangye-neirong/{contentid}")
   @ResponseBody
    public String getWebById(@PathVariable("contentid")String contentid)
   {
       JSONObject jsonObject = new JSONObject();
       Webquestion webquestion = Upload.getWebQuestionById(contentid);
      try
      {
          if(webquestion.getAnswer().isEmpty()) ;
      }catch (Exception ex)
      {
          webquestion.setAnswer("暂未回答");
      }
       jsonObject.put("0",webquestion);
       return JSON.toJSONString(jsonObject,SerializerFeature.DisableCircularReferenceDetect);
   }
   @RequestMapping("/answer_find/{Page}")
   @ResponseBody
   public String getAllNotSlovedQuestion(@PathVariable("Page")String page)
   {
       List<webTitle> webTitles = Upload.getAllNotSovledQuestion();
       JSONObject jsonObject = new JSONObject();
       int total = webTitles.size();
       int totalPage;
       if(total%3==0) totalPage = total/3;
       else totalPage = total/3+1;
       int i = 0;
       int pages = Integer.valueOf(page);
       if(pages<=0) pages=1;
       if(pages>=totalPage) pages=totalPage;
       if(total<=3){
           for(webTitle s:webTitles)
           {
               try {
                   if(s.getAnswer().isEmpty());
               }catch (Exception ex )
               {
                   s.setAnswer("暂未回答");
               }
               jsonObject.put(i+"",s);
               i++;
           }
       }else {
           for (int m = (pages - 1) * 3; m < total; m++) {
               if (i >= 3) break;
               try {
                   if(webTitles.get(m).getAnswer().isEmpty());
               }catch (Exception ex )
               {
                   webTitles.get(m).setAnswer("暂未回答");
               }
               jsonObject.put(i + "", webTitles.get(m));
               i++;
           }
       }
       if(i==3)jsonObject.put("size",3);
       else jsonObject.put("size",i);
       jsonObject.put("curPage",pages);
       jsonObject.put("totalPage",totalPage);
       return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
   }
   @RequestMapping("/ss")
   public String responseQuestion(@Param("question_id")String question_id,@Param("answer")String answer)
   {
       Upload.responseQuestion(question_id,answer);
       return "redirect:afterTable/teacher.html";
   }
   @RequestMapping("/answer_upload")
   public String answerRespones(@Param("question_id")String question_id,@Param("desc")String desc)
   {
       System.out.println(question_id+":"+desc);
       Upload.responseQuestion(question_id,desc);
       return "redirect:afterTable/teacher.html";
   }

}
