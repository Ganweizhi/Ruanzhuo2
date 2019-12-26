//package com.dgut.group11.service;
//
//import com.dgut.group11.dao.JiaoXueRiLiDao;
//import com.dgut.group11.javabean.Course;
//import com.dgut.group11.javabean.RiLi;
//import com.dgut.group11.javabean.SuccessCourse;
//import com.dgut.group11.javabean.Teacher;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
///*
//lgc
// */
//@Service
//public class JiaoXueRiLiService {
//
//    @Autowired
//    private JiaoXueRiLiDao jiaoXueRiLiDao;
//
//
//    public List<SuccessCourse> findAllSuccessCourse() {
//        return jiaoXueRiLiDao.findAllSuccessCourse();
//    }
//
//    public SuccessCourse findSuccessCourseById(int success_id) {
//        return jiaoXueRiLiDao.findSuccessCourseById(success_id);
//    }
//
//    public List<RiLi> findAllRiLiBySuccessCourseId(int success_id) {
//        return jiaoXueRiLiDao.findAllRiLiBySuccessCourseId(success_id);
//    }
//
//    public Teacher getTeacherById(int teacher_id) {
//        return jiaoXueRiLiDao.getTeacherById(teacher_id);
//    }
//
//    public Course getCourseById(int course_id) {
//        return jiaoXueRiLiDao.getCourseById(course_id);
//    }
//}
