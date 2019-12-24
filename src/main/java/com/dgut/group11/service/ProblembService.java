package com.dgut.group11.service;

import com.dgut.group11.dao.PlanbDao;
import com.dgut.group11.dao.ProblembDao;
import com.dgut.group11.javabean.Planb;
import com.dgut.group11.javabean.Problemb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
lgc
 */
@Service
public class ProblembService {
    @Autowired
    private ProblembDao problembDao;


    public List<Problemb> findAllProblembBySuccessCourseId(int success_id) {
        return problembDao.findAllProblembBySuccessCourseId(success_id);
    }
}
