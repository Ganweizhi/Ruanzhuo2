package com.dgut.CCC_WYM.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
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

import java.util.List;

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
       return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
   }
}
