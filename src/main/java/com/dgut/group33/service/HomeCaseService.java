package com.dgut.group33.service;

import com.dgut.group33.dao.HomeCaseMapper;
import com.dgut.group33.javaBean.HomeWorkCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeCaseService {
    @Autowired
    HomeCaseMapper homeCaseMapper;

   public List<HomeWorkCase> findAllCase(){
        return homeCaseMapper.findAllCase();
    }
   public HomeWorkCase findCaseById(int homework_case_id){
      return homeCaseMapper.findCaseById(homework_case_id);
    }
   public int addHomeCase(HomeWorkCase homeWorkCase){
        return homeCaseMapper.addHomeCase(homeWorkCase);
    }

}
