package com.dgut.CCC_WYM.controller;

import com.dgut.CCC_WYM.services.uploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class interaction {
    @Autowired
    private uploadServices Upload;
    @RequestMapping(path = "/test1")
    @ResponseBody
    public String uploadForQQ()
    {
        return Upload.getAllSuccessCourse().toString();
    }
//    @RequestMapping(path = "/")
//    public String uploadForWechat() {
//        return null;
//    }
//    @RequestMapping(path = "/")
//    public String uploadForWeb() {
//        return null;
//    }
}
