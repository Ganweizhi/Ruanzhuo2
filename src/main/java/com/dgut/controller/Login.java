package com.dgut.controller;

import com.alibaba.fastjson.JSON;
import com.dgut.util.Send;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dgut.jsonBean.Manager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Login {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/login/dgut")
    public String login(String token, String state,HttpServletResponse response) throws IOException {
        List<NameValuePair> first = new ArrayList<>();
        first.add(new BasicNameValuePair("token", token));
        first.add(new BasicNameValuePair("appid", "javaee"));
        first.add(new BasicNameValuePair("appsecret", "b3b52e43ccfd"));
        first.add(new BasicNameValuePair("userip", request.getLocalAddr()));
        String fj = Send.post("https://cas.dgut.edu.cn/ssoapi/v2/checkToken", first);

        if (JSON.parseObject(fj).getString("message").equals("success")) {
            String access_token = JSON.parseObject(fj).getString("access_token");
            String openid = JSON.parseObject(fj).getString("openid");
            List<NameValuePair> second = new ArrayList<>();
            second.add(new BasicNameValuePair("access_token", access_token));
            second.add(new BasicNameValuePair("openid", openid));
            String sj = Send.post("https://cas.dgut.edu.cn/oauth/getUserInfo", second);

            if (JSON.parseObject(sj).getString("message") == null) {
                Manager manager = JSON.parseObject(sj, Manager.class);
                System.out.println(manager);
                request.getSession().setAttribute("manager", manager);
                response.sendRedirect("http://localhost:8081");
            } else {
                return JSON.parseObject(sj).getString("message");
            }
        } else {
            return JSON.parseObject(fj).getString("message");
        }
        return "1";
    }

    @RequestMapping(value="/loginstate",method = {RequestMethod.POST,RequestMethod.GET})
    public String zt() {
        Manager m = (Manager) request.getSession().getAttribute("manager");
        if(m==null) return "{\"state\":0,\"name\":\"未登录\"}";
        else return "{\"state\":1,\"name\":\""+ m.getName() +"\"}";
    }

    @RequestMapping(value="/dl",method = {RequestMethod.POST,RequestMethod.GET})
    public void dl(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://cas.dgut.edu.cn?appid=javaee&state="+ request.getSession().getId());
    }

    @RequestMapping(value="/tc",method = {RequestMethod.POST,RequestMethod.GET})
    public void tc(HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("manager");
        response.sendRedirect("https://cas.dgut.edu.cn/logout?callback=http://localhost:8081/");
    }
}
