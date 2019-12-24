package com.dgut.group11.service;

import com.dgut.group11.dao.ContentBDao;
import com.dgut.group11.javabean.Contentb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
lgc
 */
@Service
public class ContentbService {
    @Autowired
    ContentBDao contentBDao;

    public List<Contentb> findAllContentbBySuccessCourseId(int success_id) {
        return contentBDao.findAllContentbBySuccessCourseId(success_id);
    }
}
