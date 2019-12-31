package com.dgut.group22.service;

import com.dgut.group22.dao.IYoungDao;
import com.dgut.group22.javaBean.Young;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YoungService {
    @Autowired
    IYoungDao youngDao;

    public String updateYoung(Young young){
        youngDao.updateYoung(young);
        return "1";
    }

    public String deleteYoung(String teacher_id){
        youngDao.deleteYoung(teacher_id);
        return "1";
    }

    public Young findYoungById(String teacher_id){
        return youngDao.findYoungById(teacher_id);
    }
}
