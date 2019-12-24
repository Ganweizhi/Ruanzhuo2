package com.dgut.group11.service;

import com.dgut.group11.dao.PlanbDao;
import com.dgut.group11.javabean.Planb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
lgc
 */
@Service
public class PlanbService {
    @Autowired
    private PlanbDao planbDao;


    public List<Planb> findAllPlanbBySuccessCourseId(int success_id) {

        return planbDao.findAllPlanbBySuccessCourseId(success_id);
    }
}
