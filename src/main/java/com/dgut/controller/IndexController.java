package com.dgut.controller;

import com.dgut.model.UserModel;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {
    private static final String INDEX = "index";
    @Autowired
    private UserService userService;
    @RequestMapping("/show")
    public String getIndex() {
        return INDEX;
    }
    @RequestMapping("/user")
    @ResponseBody
    public List<UserModel> getUserList(UserModel userModel) {
        List<UserModel> userList = userService.getUserInfo(null);
        return userList;
        //http://localhost:8080/user
    }
}