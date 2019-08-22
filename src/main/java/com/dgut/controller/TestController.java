package com.dgut.controller;
import com.dgut.mapper.UserMapper;
import com.dgut.model.staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestController {


    @Autowired
    private staff staffMapper;
    @RequestMapping(value = "/list")
    public String getList(String department,String degree,String stime,String etime,String search) {
        System.out.println(department + " " + degree + " " + stime + " " + etime + " " + search);
        return null;
    }
}
