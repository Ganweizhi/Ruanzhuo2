package com.dgut.group22.service;

import com.dgut.group22.dao.ISuccessCourseDao;
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
        if (successCourse==null)
            return null;
        System.out.println(successCourse.toString());
        return successCourse;
    }

    public int insertTextbook(resource resource){
        return resourceDao.insertTextbook(resource);
    }

    public int insertExperiment_house(experiment_house experiment_house){
        return resourceDao.insertExperiment_house(experiment_house);
    }

    public SuccessCourse selectSuccessCourseById(Integer success_id){
        return resourceDao.selectSuccessCourseById(success_id);
    }

    public List<resource> selectResourceBySuccess_id(Integer success_id){
        return resourceDao.selectResourceBySuccess_id(success_id);
    }

    public int DeleteTextbook(resource resource){
        return resourceDao.DeleteTextbook(resource);
    }

    public int DeleteExperiment_house(Integer experiment_id){
        return resourceDao.DeleteExperiment_house(experiment_id);
    }

    public Course selectCourseById(int course_id){
        return resourceDao.selectCourseById(course_id);
    }

    public Teacher selectTeacherById(int teacher_id){
        return resourceDao.selectTeacherById(teacher_id);
    }

    public resource selectResourceById(Integer resource_id){
        return resourceDao.selectResourceById(resource_id);
    }
}
