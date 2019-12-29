package com.dgut.group11.service;


import com.dgut.group11.dao.Teaching_ProgramDao;
import com.dgut.group11.javabean.Teaching_program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
lgc
 */
@Service
public class Teaching_ProgramService {

    @Autowired
    Teaching_ProgramDao teaching_programDao;
    public List<Teaching_program> findAllTeaching_programBySuccessCourseId(int success_id) {
        return teaching_programDao.findAllTeaching_programBySuccessCourseId(success_id);
    }
}
