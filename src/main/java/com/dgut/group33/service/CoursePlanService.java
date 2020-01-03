package com.dgut.group33.service;

import com.dgut.group33.dao.CourseMapper;
import com.dgut.group33.dao.CoursePlanMapper;
import com.dgut.group33.dao.SuccessCourseMapper;
import com.dgut.group33.javaBean.Course;
import com.dgut.group33.javaBean.CoursePlan;
import com.dgut.group33.javaBean.SelectCourse;
import com.dgut.group33.javaBean.SuccessCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursePlanService {
    @Autowired
    CoursePlanMapper coursePlanMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    SuccessCourseMapper successCourseMapper;

    public List<CoursePlan> findAllCoursePlan() {
        return coursePlanMapper.findAllCoursePlan();
    }

    public CoursePlan findCoursePlanById(int course_plan_id) {
        return coursePlanMapper.findCoursePlanById(course_plan_id);
    }

    public List<Course> findCourseByCpid(int course_plan_id) {
        return courseMapper.findCourseByCpid(course_plan_id);
    }

    public int addCoursePlan(CoursePlan coursePlan){
        return  coursePlanMapper.addCoursePlan(coursePlan);
    }
    public int addCourse(Course course){
        return  courseMapper.addCourse(course);
    }

    public SelectCourse findScoreById(int student_id){
        return  courseMapper.findScoreById(student_id);
    }
    public int  addSelectScore(SelectCourse selectCourse){
        return courseMapper.addSelectScore(selectCourse);
    }

    public int addSuccessCourse(SuccessCourse successCourse){
        return successCourseMapper.insertSuccessCourse(successCourse);
    }
}
