package com.dgut.service;

import com.dgut.mapper.staffMapper;
import com.dgut.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetDepPower {

    @Autowired
    private staffMapper staffmapper;
    public String getDepPower(String managers_id){
        List<String> list = staffmapper.getDepPower(managers_id);
        System.out.println(list.toString());
        for(int i=0; i<list.get(0); i++);
        return null;
    }
}
