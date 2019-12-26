package com.dgut.group22.service;

import com.dgut.group22.dao.IFuZeRenDao;
import com.dgut.group22.javaBean.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Ning
@Service
public class FuZeRenService {
    @Autowired
    IFuZeRenDao fuZeRenDao;

    public List<Teacher> findAllFuZeRen(){
        return fuZeRenDao.findAllFuZeRen();
    }

    public Teacher findFuZeRenById(String teacher_id){
        return fuZeRenDao.findFuZeRenById(teacher_id);
    }

    public List<Teacher> findAllTeacher(){
        return fuZeRenDao.findAllTeacher();
    }

    public void updateTeacher(Teacher teacher){
        fuZeRenDao.update(teacher);
    }

    public String deleteFuZeRen(String course_id){
        fuZeRenDao.deleteFuZeRen(course_id);
        return "1";
    }
}
