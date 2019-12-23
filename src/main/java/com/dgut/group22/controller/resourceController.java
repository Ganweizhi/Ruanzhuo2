package com.dgut.group22.controller;

import com.dgut.group22.javaBean.resource;
import com.dgut.group22.service.resourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/resource")
public class resourceController {

    @Autowired
    private resourceService resourceService;

    @RequestMapping(value = "/GetAllTextbook",method = RequestMethod.GET)
    @ResponseBody
    public List<String> GetAllTextbook(HttpServletRequest request) throws FileNotFoundException {
        List<String> strings=new ArrayList<String>();
//        File sourceFile= null;
        String path=null;
        List<resource> resources=resourceService.GetAllResource();
        for(resource resource: resources ){
            if(resource.getResource_textbook()!=null)
            strings.add(resource.getResource_textbook());
            String downloadFilePath =System.getProperty("user.dir");
//            downloadFilePath =downloadFilePath+"\\src\\main\\resources\\ppt";
//            String downloadFilePath = request.getSession().getServletContext().getRealPath("/");
            System.out.println(downloadFilePath);
//            path= request.getServletContext().getRealPath("/ppt/");//获取文件的路径
//            strings.add(path+resource.getResource_textbook());
        }
        return strings;
    }

    @RequestMapping("/downLoadFile")
    @ResponseBody
    private String downLoadFile(HttpServletResponse response ,HttpServletRequest request,String fileName){
        String downloadFilePath =System.getProperty("user.dir");
//        downloadFilePath = "G:\\复习";
        downloadFilePath =downloadFilePath+"\\src\\main\\resources\\ppt\\";
//        String downloadFilePath = request.getServletContext().getRealPath("/ppt/");//被下载的文件在服务器中的路径,
//        String fileName = " ";
        System.out.println(fileName);
        System.out.println(downloadFilePath);
        File file = new File(downloadFilePath,fileName);
        System.out.println(file.getPath());
        System.out.println(file.exists());
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                System.out.println(fileName);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }

}
