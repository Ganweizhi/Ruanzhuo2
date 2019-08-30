package com.dgut.interceptor;

import com.dgut.jsonBean.LogBean;
import com.dgut.jsonBean.Manager;
import com.dgut.mapper.LogMapper;
import com.dgut.service.LogService;
import com.dgut.service.ManagersService;
import com.dgut.util.IpUtil;
import org.apache.catalina.core.StandardService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LogService logservice;

    private List<String> logList = new ArrayList<>(Arrays.asList("/add","/inlist","/delete","htdelete","/xcedit","/headimg","/sfzz","/sfzf","/yhkz","/yhkf","/htfile","/gladda","/gledit","/roleadd","/gldel","/gladd","/qxedit"));
    private List<String> logAction = new ArrayList<>(Arrays.asList("修改或添加人员基本信息","导入人员信息","辞退人员","删除合同","修改或添加薪酬信息","上传头像","上传身份证","上传身份证","上传银行卡","上传银行卡","添加合同","添加管理员","修改管理员信息","添加角色","修改管理员信息","修改管理员信息","修改角色信息"));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Manager m = (Manager) request.getSession().getAttribute("manager");
        if(m!=null&&logList.contains(request.getServletPath())){
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(date);
            System.out.print(request.getServletPath() + " ");
            LogBean logBean = new LogBean(0,time,m.getUsername(),m.getName(),IpUtil.getIpAddr(request),logAction.get(logList.indexOf(request.getServletPath())));
            logservice.add(logBean);
        }
        return m!=null;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
