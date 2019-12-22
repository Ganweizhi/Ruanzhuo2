package com.dgut.group11.gwz.service;

import com.dgut.group11.gwz.dao.Gwz_KeChengGaiKuangDao;
import com.dgut.group11.gwz.javabean.gwz_Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class gwz_KeChengGaiKuangService {

    @Autowired
    Gwz_KeChengGaiKuangDao gwz_keChengGaiKuangDao;

    public List<gwz_Course> FindAllCourse(){
        return gwz_keChengGaiKuangDao.FindAllCourse();
    }

    public List<gwz_Course> FindCourseById(int course_id){
        return gwz_keChengGaiKuangDao.FindCourseById(course_id);
    }

    public void AddJianJie(gwz_Course course){
        gwz_keChengGaiKuangDao.AddJianJie(course);
    }

    public void EditJianJie(gwz_Course course){
        gwz_keChengGaiKuangDao.EditJianJie(course);
    }

    public void EditTeSe(gwz_Course course){
        gwz_keChengGaiKuangDao.EditTeSe(course);
    }

    public void EditJiaoCai(gwz_Course course){
        gwz_keChengGaiKuangDao.EditJiaoCai(course);
    }

    public void EditLiShi(gwz_Course course){
        gwz_keChengGaiKuangDao.EditLiShi(course);
    }





}
