package com.dgut.group11.gwz.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group11.gwz.dao.Gwz_KeChengGaiKuangDao;
import com.dgut.group11.gwz.javabean.gwz_Course;
import com.dgut.group11.gwz.service.gwz_KeChengGaiKuangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/course")
public class gwz_KeChengKaiKuangController {

    @Autowired
    gwz_KeChengGaiKuangService gwz_keChengGaiKuangService;

    @Autowired
    Gwz_KeChengGaiKuangDao gwz_keChengGaiKuangDao;


    @RequestMapping(value = "/JianJie" ,method = {RequestMethod.GET})
    @ResponseBody
    public String gwz_JianJie(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllCourse();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",courseList);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }


    @RequestMapping(value = "/JiaoCai",method = {RequestMethod.GET})
    @ResponseBody
    public String gwz_JiaoCai(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllCourse();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",courseList);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    @RequestMapping(value = "/LiShi" ,method = {RequestMethod.GET})
    @ResponseBody
    public String gwz_LiShi(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllCourse();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",courseList);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();//
    }

    @RequestMapping(value = "/TeSe",method = {RequestMethod.GET})
    @ResponseBody
    public String gwz_TeSe(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllCourse();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",courseList);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }



    @RequestMapping("/AddJianJie")
    public void AddJianJie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/afterTable/gwz_AddJianJie.html");
    }

    @RequestMapping("/EditJianJie")
    public String EditJianJie(){
        return "/afterTable/gwz_EditJianJie.html";
    }

    @RequestMapping("/EditTeSe")
    public String EditTeSe(){
        return "/afterTable/gwz_EditTeSe.html";
    }

    @RequestMapping("/EditJiaoCai")
    public String EditJiaoCai(){
        return "/afterTable/gwz_EditJiaoCai.html";
    }

    @RequestMapping("/EditLiShi")
    public String EditLiShi(){
        return "/afterTable/gwz_EditLiShi.html";
    }





    @RequestMapping("/accept_AddJianJie")
    @ResponseBody
    public String accept_AddJianJie(gwz_Course course){
        gwz_keChengGaiKuangService.AddJianJie(course);
        return "sucessful";
    }







    @RequestMapping("/accept_EditJianJie")
    @ResponseBody
    public String accept_EditJianJie(gwz_Course course){
        gwz_keChengGaiKuangService.EditJianJie(course);
        return "sucessful";
    }

    @RequestMapping("/accept_EditTeSe")
    @ResponseBody
    public String accept_EditTeSe(gwz_Course course){
        gwz_keChengGaiKuangService.EditTeSe(course);
        return "sucessful";
    }

    @RequestMapping("/accept_EditJiaoCai")
    @ResponseBody
    public String accept_EditJiaoCai(gwz_Course course){
        gwz_keChengGaiKuangService.EditJiaoCai(course);
        return "sucessful";
    }

    @RequestMapping("/accept_EditLiShi")
    @ResponseBody
    public String accept_EditLiShi(gwz_Course course){
        gwz_keChengGaiKuangService.EditLiShi(course);
        return "sucessful";
    }

}
