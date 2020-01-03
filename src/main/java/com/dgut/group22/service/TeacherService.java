package com.dgut.group22.service;

import com.dgut.group22.dao.ITeacherDao;
import com.dgut.group22.javaBean.SuccessCourse;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.javaBean.Young;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Ning
@Service
public class TeacherService {
    @Autowired
    ITeacherDao teacherDao;
    public Teacher findById(String teacher_id){
        return teacherDao.findById(teacher_id);
    }

    public List<Teacher> findAllYoungTeacher(){
        return teacherDao.findAllYoungTeacher();
    }

    public Young findYoungById(String teacher_id){
        return teacherDao.findYoungById(teacher_id);
    }

    public void updateTeacher(Teacher teacher){
        teacherDao.update(teacher);
    }

    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    public String deleteTeacher(String teacher_id) {
        teacherDao.deleteTeacher1(teacher_id);
        return "1";
    }

    public void editTeacher(Teacher teacher) {
        teacherDao.editTeacher(teacher);
    }

    public List<Teacher> findAllTeacher() {
        return teacherDao.findAllTeacher();
    }
}
