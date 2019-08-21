package com.dgut.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

    @RequestMapping(value = "/list")
    public String getList(String department,String degree,String stime,String etime,String search) {
        System.out.println(department + " " + degree + " " + stime + " " + etime + " " + search);
        return "{\"data\":[{\"wid\":\"20136587\",\"name\":\"李贵超\",\"sex\":\"0\",\"degree\":\"2\"}]}";
    }
}
