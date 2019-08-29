package com.dgut.interceptor;

import com.dgut.jsonBean.LogBean;
import com.dgut.jsonBean.Manager;
import com.dgut.mapper.LogMapper;
import com.dgut.service.LogService;
import com.dgut.util.IpUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LogService logservice;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Manager m = (Manager) request.getSession().getAttribute("manager");
        if(m!=null){
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(date);
            if(IpUtil.getIpAddr(request)!=null&&request.getServletPath()!=null){
                LogBean logBean = new LogBean(0,time,m.getUsername(),m.getName(),IpUtil.getIpAddr(request),request.getServletPath());
                System.out.println(logBean.toString());
                logservice.add(logBean);
            }
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
