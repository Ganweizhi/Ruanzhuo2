package com.dgut.group22.service;

import com.dgut.group22.dao.ISuccessCourseDao;
import com.dgut.group22.javaBean.SuccessCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Ning
@Service
public class SuccessCourseService {
    @Autowired
    ISuccessCourseDao successCourseDao;
    public List<SuccessCourse>findAllSuccessCourse(){
        return successCourseDao.findAllSuccessCourse();
    }
}
