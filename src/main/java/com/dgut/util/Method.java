package com.dgut.util;

import ch.qos.logback.core.util.FileUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import javax.servlet.GenericServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Method {
    public static String timeChange(String s){
        if(s.equals("Jan")) return "01";
        else if(s.equals("Feb")) return "02";
        else if(s.equals("Mar")) return "03";
        else if(s.equals("Apr")) return "04";
        else if(s.equals("May")) return "05";
        else if(s.equals("Jan")) return "06";
        else if(s.equals("Jul")) return "07";
        else if(s.equals("Aug")) return "08";
        else if(s.equals("Sep")) return "09";
        else if(s.equals("Oct")) return "10";
        else if(s.equals("Nov")) return "11";
        else return "12";
    }
    public static int CompareTime(String q, String  b) throws Exception
            //参数1合同有效月份，参数2合同签约时间
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        int a = Integer.parseInt(q);
        a = a*-1;
        rightNow.add(Calendar.MONTH,a); //减去合同月份
        Date nowC = rightNow.getTime();
        String nowString = sdf.format(nowC);
        //System.out.println(nowString);
        //System.out.println(b.compareTo(nowString));
        int w = b.compareTo(nowString);
        if(w>=0) return 1;//合同有效
        else  return  0;  //合同无效
    }
}
