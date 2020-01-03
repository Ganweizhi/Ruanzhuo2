package com.dgut.CCC_WYM.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dgut.CCC_WYM.javabeans.beforeWechat;
import com.dgut.CCC_WYM.javabeans.image_wechat;
import com.dgut.CCC_WYM.javabeans.success_id;
import com.dgut.CCC_WYM.services.uploadServices;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class WechatUpload {
    @Autowired
    private uploadServices Upload;
    @RequestMapping("/Wechat_upload")
    @ResponseBody
    public String QQupload(MultipartFile pic, @Param("success_id")String success_id, HttpServletRequest request) throws IOException {

        System.out.println(pic+success_id);
        String realPath = request.getServletContext().getRealPath("/beforeTable/group_image/wechat_image");
        File folder = new File(realPath);
        if(!folder.exists())
        {
            folder.mkdirs();
        }
        String oldname = pic.getOriginalFilename();
        String newName = success_id+"_"+"wechat"+"_"+oldname.substring(oldname.lastIndexOf("."));
        pic.transferTo(new File(folder,newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/beforeTable/group_image/wechat_image/" + newName;
        System.out.println(url);

        JSONObject jsonObject = new JSONObject();
        try{
            Upload.setWechatimage(newName,success_id);
            jsonObject.put("code",1);
        }catch (Exception ex)
        {
            jsonObject.put("code",0);
        }
        return JSON.toJSONString(jsonObject);
    }
    @RequestMapping("/getSuccess_idForWechat")
    @ResponseBody
    public String getWechatSuccess_id()
    {
        List<success_id> success_ids= Upload.getAllWechatNotUpload();
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
    @RequestMapping("/Wechat_find/{Page}")
    @ResponseBody
    public String getWechatPages(@PathVariable("Page")String page)
    {
        List<image_wechat> AllWechat = Upload.getAllWechatImage();
        int total = AllWechat.size();
        int totalPage;
        if(total%3==0) totalPage = total/3;
        else totalPage = total/3+1;
        JSONObject jsonObject = new JSONObject();
        int i = 0;
        int pages = Integer.valueOf(page);
        if(pages<=0) pages=1;
        if(pages>=totalPage) pages=totalPage;
        if(total<=3){
            for(image_wechat s:AllWechat)
            {
                jsonObject.put(i+"",s);
                i++;
            }
        }else {
            for (int m = (pages - 1) * 3; m < total; m++) {
                if (i >= 3) break;
                jsonObject.put(i + "", AllWechat.get(m));
                i++;
            }
        }
        if(i==3)jsonObject.put("size",3);
        else jsonObject.put("size",i);
        jsonObject.put("curPage",pages);
        jsonObject.put("totalPage",totalPage);
        return JSON.toJSONString(jsonObject,SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/jiaoxuehudong_Wechat/{page}")
    @ResponseBody
    public String getBeforeWechat(@PathVariable("page")String page)
    {
        List<beforeWechat> beforeWechats = Upload.getAllWechatUrl();
        int total =beforeWechats.size();
        int totalPage;
        if(total%3==0) totalPage = total/3;
        else totalPage = total/3+1;
        JSONObject jsonObject = new JSONObject();
        int i = 0;
        int pages = Integer.valueOf(page);
        if(pages<=0) pages=1;
        if(pages>=totalPage) pages=totalPage;
        if(total<=3){
            for(beforeWechat s:beforeWechats)
            {
                jsonObject.put(i+"",s);
                i++;
            }
        }else {
            for (int m = (pages - 1) * 3; m < total; m++) {
                if (i >= 3) break;
                jsonObject.put(i + "", beforeWechats.get(m));
                i++;
            }
        }
        if(i==3)jsonObject.put("size",3);
        else jsonObject.put("size",i);
        jsonObject.put("curPage",pages);
        jsonObject.put("totalPage",totalPage);
        return JSON.toJSONString(jsonObject,SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/Wechat_Delete/{id}")
    @ResponseBody
    public String deletWechat(@PathVariable("id") String id)
    {
        System.out.println(id);
        JSONObject jsonObject = new JSONObject();
        try {
            Upload.deleteWechat(id);
            jsonObject.put("code","1");
        }catch (Exception ex)
        {
            jsonObject.put("code",0);
        }
        return JSON.toJSONString(jsonObject);
    }
    @RequestMapping("/Wechat_edit")
    @ResponseBody
    public String changeWechatImage(@Param("success_id")String success_id,@Param("pic")MultipartFile pic,HttpServletRequest request ) throws IOException {
        String realPath = request.getServletContext().getRealPath("/beforeTable/group_image/wechat_image");
        File folder = new File(realPath);
        if(!folder.exists())
        {
            folder.mkdirs();
        }
        String oldname = pic.getOriginalFilename();
        String newName = success_id+"_"+"wechat"+"_"+oldname.substring(oldname.lastIndexOf("."));
        pic.transferTo(new File(folder,newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/beforeTable/group_image/wechat_image/" + newName;
        System.out.println(url);
        System.out.println(success_id+newName);
        Upload.changeWechat(success_id,newName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",1);
        return JSON.toJSONString(jsonObject);
    }
}
