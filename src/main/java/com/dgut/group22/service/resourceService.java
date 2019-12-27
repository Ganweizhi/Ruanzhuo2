package com.dgut.group22.service;

import com.dgut.group22.javaBean.*;
import com.dgut.group22.dao.resourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class resourceService {

    @Autowired
    private resourceDao resourceDao;
    public List<resource> GetAllResource(){
        List<resource> resources = resourceDao.selectAllResource();
        return resources;
    }

    public List<experiment_house> GetAllExperiment_house(){
        List<experiment_house> experiment_houses = resourceDao.selectAllExperiment_house();
        return experiment_houses;
    }

    public SuccessCourse selectSuccessCourse(String course_name,String teacher_name){
        Course course = resourceDao.selectCourseByName(course_name);
        Teacher teacher = resourceDao.selectTeacherByName(teacher_name);
        if (course==null||teacher==null){
            return null;
        }
        SuccessCourse successCourse = resourceDao.selectSuccessCourse(course.getCourse_id(),teacher.getTeacher_id());
        return successCourse;
    }

    public int insertTextbook(resource resource){
        return resourceDao.insertTextbook(resource);
    }

}
