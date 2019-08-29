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
//        System.out.println(list.toString());
        String result = list.get(0);
        result.replace('1','0');
        StringBuilder sb = new StringBuilder(result);
        for(int i=0; i<result.length(); i++){
            for (String s : list) {
                if(s.charAt(i)=='1'){
                    sb.setCharAt(i,'1');
                    break;
                }
            }
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }
}
