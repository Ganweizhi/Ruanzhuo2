package com.dgut.group11.service;

import com.dgut.group11.dao.ContentBDao;
import com.dgut.group11.dao.MethodbDao;
import com.dgut.group11.javabean.Contentb;
import com.dgut.group11.javabean.Methodb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
lgc
 */
@Service
public class MethodbService {
    @Autowired
    private MethodbDao methodbDao;


    public List<Methodb> findAllMethodbBySuccessCourseId(int success_id) {
        return methodbDao.findAllMethodbBySuccessCourseId(success_id);
    }
}
