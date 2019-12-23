package com.dgut.group33.service;

import com.dgut.group33.dao.CourseMapper;
import com.dgut.group33.dao.CoursePlanMapper;
import com.dgut.group33.javaBean.Course;
import com.dgut.group33.javaBean.CoursePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursePlanService {
    @Autowired
    CoursePlanMapper coursePlanMapper;
    @Autowired
    CourseMapper courseMapper;

    public List<CoursePlan> findAllCoursePlan() {
        return coursePlanMapper.findAllCoursePlan();
    }

    public CoursePlan findCoursePlanById(int course_plan_id) {
        return coursePlanMapper.findCoursePlanById(course_plan_id);
    }

    public List<Course> findCourseByCpid(int course_plan_id) {
        return courseMapper.findCourseByCpid(course_plan_id);
    }

}
