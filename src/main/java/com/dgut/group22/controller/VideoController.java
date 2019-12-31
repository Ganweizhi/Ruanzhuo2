package com.dgut.group22.controller;


import com.dgut.group22.javaBean.Video;
import com.dgut.group22.javaBean.resource;
import com.dgut.group22.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/resource")
public class VideoController {

    @Autowired
    private VideoService videoService;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String course_id;

    @RequestMapping(value = "/FindAllCourseName",method = RequestMethod.GET)
    @ResponseBody
    public List<Video> FindAllCourseName()
    {
        return videoService.FindAllCourseName();
    }

    @RequestMapping(value = "/FindCourseVideoPath/{course_id}",method = RequestMethod.GET)
    @ResponseBody
    public String FindCourseVideoPath( @PathVariable String course_id,HttpServletRequest request, HttpServletResponse response)
    {
        int course_id2=Integer.parseInt(course_id);
       String path=videoService.FindCourseVideoPath(course_id);

        String downloadFilePath =System.getProperty("user.dir");
//        downloadFilePath = "G:\\复习";
        downloadFilePath =downloadFilePath+"\\src\\main\\resources\\video\\";

        try {
            FileInputStream fis = null;
            OutputStream os = null ;
            fis = new FileInputStream(downloadFilePath+path);
            int size = fis.available(); // 得到文件大小
            byte data[] = new byte[size];
            fis.read(data); // 读数据
            fis.close();
            fis = null;
            response.setContentType("video/mp4"); // 设置返回的文件类型
            os = response.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
            os = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    //Ning
    //上传文件
    @RequestMapping("/upload")
    public void Upload(MultipartFile upload) throws IOException {
        String downloadFilePath =System.getProperty("user.dir");
        downloadFilePath =downloadFilePath+"\\src\\main\\webapp\\afterTable\\images";
        File file = new File(downloadFilePath);
        if(!file.exists()){
            file.mkdirs();
        }
        String fileName = upload.getOriginalFilename();
//        String uuid = UUID.randomUUID().toString().replace("-","");
//        fileName = uuid + "_" + fileName;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName="11"+suffixName;
        upload.transferTo(new File(downloadFilePath,fileName));
        System.out.println("成功");
    }
}
