package com.dgut.model;

import java.io.Serializable;
import java.sql.Date;

public class staff implements Serializable {

    String wid; //工号
    String name; //姓名
    String sex; //性别
    String nation; //民族
    String nationality; //国籍
    String origin; //籍贯
    String idType; //证件类型
    String idNumber; //证件号
    String education; //学历
    String degree; //学位
    String department; //部门
    String job; //岗位
    String title; //职称
    String lPhone; //手机长号
    String sPhone; //短号
    String gPhone; //固定电话
    String email; //邮箱
    String img; //头像
    String state; //状态
    String baseWage; //基本工资
    String bankName; //银行名称
    String bankId; //银行账号
    String htName; //合同名称
    Date signingTime; //签约时间
    Date useTime; //合同有效期
    Date departureTime; //离职时间
}
