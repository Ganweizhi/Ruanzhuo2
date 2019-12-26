package com.dgut.group11.gwz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dgut.group11.gwz.dao.Gwz_KeChengGaiKuangDao;
import com.dgut.group11.gwz.javabean.gwz_Course;
import com.dgut.group11.gwz.javabean.gwz_teacher;
import com.dgut.group11.gwz.service.gwz_KeChengGaiKuangService;
import org.apache.ibatis.annotations.Result;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/course")
public class gwz_KeChengKaiKuangController  extends HttpServlet {

    @Autowired
    gwz_KeChengGaiKuangService gwz_keChengGaiKuangService;

    @Autowired
    Gwz_KeChengGaiKuangDao gwz_keChengGaiKuangDao;


    @RequestMapping(value = "/JianJie_front" ,method = {RequestMethod.GET})
    @ResponseBody
    public void gwz_JianJie_front(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllFullCourse();
        request.getSession().setAttribute("",courseList);
        response.sendRedirect("/beforeTable/");
    }


    @RequestMapping(value = "/JiaoCai_front",method = {RequestMethod.GET})
    @ResponseBody
    public void gwz_JiaoCai_front(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllFullCourse();
        request.getSession().setAttribute("",courseList);
        response.sendRedirect("/beforeTable/");
    }

    @RequestMapping(value = "/LiShi_front" ,method = {RequestMethod.GET})
    @ResponseBody
    public void gwz_LiShi_front(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllFullCourse();
        request.getSession().setAttribute("",courseList);
        response.sendRedirect("/beforeTable/");

    }

    @RequestMapping(value = "/TeSe_front",method = {RequestMethod.GET})
    @ResponseBody
    public void gwz_TeSe_front(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllFullCourse();
        request.getSession().setAttribute("",courseList);
        response.sendRedirect("/beforeTable/");
    }










//    下面都是你甘哥的，你的在上面

    @RequestMapping("/JianJie")
    public void gwz_JianJie(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllFullCourse();
        request.getSession().setAttribute("JianJie_courseList",courseList);
        response.sendRedirect("/afterTable/gwz_JianJie.jsp");
    }


    @RequestMapping("/JiaoCai")
    public void gwz_JiaoCai(Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllFullCourse();
        request.getSession().setAttribute("JiaoCai_courseList",courseList);
        response.sendRedirect("/afterTable/gwz_JiaoCai.jsp");
    }

    @RequestMapping("/LiShi")
    public void gwz_LiShi(Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllFullCourse();
        request.getSession().setAttribute("LiShi_courseList",courseList);
        response.sendRedirect("/afterTable/gwz_LiShi.jsp");
    }

    @RequestMapping("/TeSe")
    public void gwz_TeSe(Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<gwz_Course> courseList=gwz_keChengGaiKuangDao.FindAllFullCourse();
        request.getSession().setAttribute("TeSe_courseList",courseList);
        response.sendRedirect("/afterTable/gwz_TeSe.jsp");
    }






    @RequestMapping("/AddJianJie")
    public void AddJianJie(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<gwz_teacher> teacherList=gwz_keChengGaiKuangDao.FindFullTeacherList();
        request.getSession().setAttribute("AddJianJie_teacherList",teacherList);
        response.sendRedirect("/afterTable/gwz_AddJianJie.jsp");
    }

    @RequestMapping("/EditJianJie")
    public void EditJianJie(int course_id,HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        gwz_Course course=gwz_keChengGaiKuangDao.FindCourseById(course_id);
        request.getSession().setAttribute("EditJianJie_course",course);
        response.sendRedirect("/afterTable/gwz_EditJianJie.jsp");
    }

    @RequestMapping("/EditTeSe")
    public void EditTeSe(int course_id,HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        gwz_Course course=gwz_keChengGaiKuangDao.FindCourseById(course_id);
        request.getSession().setAttribute("EditTeSe_course",course);
        response.sendRedirect("/afterTable/gwz_EditTeSe.jsp");
    }

    @RequestMapping("/EditJiaoCai")
    public void EditJiaoCai(int course_id,HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        gwz_Course course=gwz_keChengGaiKuangDao.FindCourseById(course_id);
        request.getSession().setAttribute("EditJiaoCai_course",course);
        response.sendRedirect("/afterTable/gwz_EditJiaoCai.jsp");
    }

    @RequestMapping("/EditLiShi")
    public void EditLiShi(int course_id,HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        gwz_Course course=gwz_keChengGaiKuangDao.FindCourseById(course_id);
        request.getSession().setAttribute("EditLiShi_course",course);
        response.sendRedirect("/afterTable/gwz_EditLiShi.jsp");
    }





    @RequestMapping("/accept_AddJianJie")
    public String accept_AddJianJie(gwz_Course course,int teacher_id){
        gwz_teacher teacher=gwz_keChengGaiKuangDao.FindFullTeacherById(teacher_id);
        course.setGwzTeacher(teacher);
        gwz_keChengGaiKuangDao.AddJianJie(course);
        return "redirect:/course/JianJie";
    }







    @RequestMapping("/accept_EditJianJie")
    @ResponseBody
    public String accept_EditJianJie(gwz_Course course,int teacher_id){
        gwz_teacher teacher=gwz_keChengGaiKuangDao.FindFullTeacherById(teacher_id);
        course.setGwzTeacher(teacher);
        gwz_keChengGaiKuangDao.EditJianJie(course);
        return "sucessful";
    }

    @RequestMapping("/accept_EditTeSe")
    @ResponseBody
    public String accept_EditTeSe(gwz_Course course){
        gwz_keChengGaiKuangDao.EditTeSe(course);
        return "sucessful";
    }

    @RequestMapping("/accept_EditJiaoCai")
    @ResponseBody
    public String accept_EditJiaoCai(gwz_Course course){
        gwz_keChengGaiKuangDao.EditJiaoCai(course);
        return "sucessful";
    }

    @RequestMapping("/accept_EditLiShi")
    @ResponseBody
    public String accept_EditLiShi(gwz_Course course){
        gwz_keChengGaiKuangDao.EditLiShi(course);
        return "sucessful";
    }






    @RequestMapping("/delete_JianJie")
    public String delete_JianJie(int course_id){
        gwz_keChengGaiKuangDao.deleteJianjie(course_id);
        return "redirect:/course/JianJie";
    }

    @RequestMapping("/delete_JiaoCai")
    public String delete_JiaoCai(int course_id){
        gwz_keChengGaiKuangDao.deleteJiaoCai(course_id);
        return "redirect:/course/JiaoCai";
    }

    @RequestMapping("/delete_LiShi")
    public String delete_LiShi(int course_id){
        gwz_keChengGaiKuangDao.deleteLiShi(course_id);
        return "redirect:/course/LiShi";
    }

    @RequestMapping("/delete_TeSe")
    public String delete_TeSe(int course_id){
        gwz_keChengGaiKuangDao.deleteTeSe(course_id);
        return "redirect:/course/TeSe";
    }



}
