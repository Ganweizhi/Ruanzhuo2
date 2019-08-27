package com.dgut.email;

import com.dgut.jsonBean.emailBean;
import com.dgut.mapper.emailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Component
public class Test {
    int i = 0;
    @Resource
    private MailServiceUtils mailServiceUtils;
    @Autowired
    private emailMapper mapper;

    /*
    还没有写完，理论上来说是只发一封信提醒；
     */

    //@Scheduled(fixedRate = 5000)//定时任务5秒执行一次
    @Scheduled(cron = "0 0 0 * * ?")//定时任务每天凌晨执行一次
    public void test() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        List<emailBean>  data = mapper.getList();
        for (emailBean bean : data) {
            Date dt=sdf.parse(bean.getSigningTime());
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.MONTH,Integer.parseInt(bean.getUseTime()));
            Date dt1=rightNow.getTime();
            long days=-(today.getTime()-dt1.getTime())/(1000*3600*24);
            System.out.println(days);
            if(days<61){
                String email = mapper.getEmailByWid(bean.getWid());
                System.out.println(email);
                mailServiceUtils.sendMail("986609648@qq.com",email,"主题"+i,"你被炒鱿鱼了!");
            }
        }
        i++;
    }

}

