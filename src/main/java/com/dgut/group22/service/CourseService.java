package com.dgut.group22.service;

import com.dgut.group22.javaBean.Course;
import com.dgut.group22.dao.ICourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Ning
@Service
public class CourseService {
    @Autowired
    ICourseDao courseDao;

    public Course findById(String course_id){
        return  courseDao.findById(course_id);
    }
}
