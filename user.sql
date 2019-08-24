DROP TABLE IF EXISTS `department`;
create  table department(
   department varchar(12) primary key ,
   name   varchar(255) default null
);
insert  into department values (0,'后勤部');
insert  into department values (1,'卫生部');


DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  wid int identity(2019500,1)  PRIMARY KEY, --工号
  name varchar(255) DEFAULT NULL, --姓名
  sex varchar(2) DEFAULT NULL, --性别
  nation varchar(20) DEFAULT NULL, --民族
  nationality varchar(20) DEFAULT NULL, --国籍
  origin varchar(255) DEFAULT NULL, --籍贯
  idType varchar(255) DEFAULT NULL, --证件类型
  idNumber varchar(18) DEFAULT NULL, --证件号
  education varchar(255) DEFAULT NULL, --学历
  degree varchar(255) DEFAULT NULL, --学位
  department varchar(12) references department(department), --部门
  job varchar(255) DEFAULT NULL, --岗位
  title varchar(255) DEFAULT NULL, --职称
  lPhone varchar(12) DEFAULT NULL, --手机长号
  sPhone varchar(12) DEFAULT NULL, --短号
  gPhone varchar(12) DEFAULT NULL, --固定电话
  email varchar(20) DEFAULT NULL, --邮箱
  img varchar(255) DEFAULT NULL, --头像
  state varchar(20) DEFAULT NULL, --状态
  baseWage varchar(20) DEFAULT NULL, --基本工资
  bankName varchar(20) DEFAULT NULL, --银行名称
  bankId varchar(20) DEFAULT NULL, --银行账号
  htName varchar(255) DEFAULT NULL, --合同名称
  signingTime varchar(255) DEFAULT NULL, --签约时间
  useTime varchar(255) DEFAULT NULL, --合同有效期
  departureTime varchar(255) DEFAULT NULL, --离职时间
);
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                   email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
                   VALUES('张三', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '3', '0', '0', '清洁工'
                            , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
                            , '1', '12345', '0', '6222020903001483077', '合同1', '2019-06-20', '24', '2021-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('张三', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '3', '0', '0', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2019-06-20', '24', '2021-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('张三', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '3', '0', '0', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2019-06-20', '24', '2021-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('张三', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '3', '0', '0', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2019-06-20', '24', '2021-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('ming', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '4', '0', '1', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2020-06-20', '24', '2022-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('ming', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '4', '0', '1', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2020-06-20', '24', '2022-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('ming', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '4', '0', '1', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2020-06-20', '24', '2022-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('ming', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '4', '0', '1', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2020-06-20', '24', '2022-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('ming', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '4', '0', '1', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2020-06-20', '24', '2022-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('ming', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '4', '0', '1', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2020-06-20', '24', '2022-06-20');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,gPhone,
                  email,img,state,baseWage,bankName,bankId,htName,signingTime,useTime,departureTime)
    VALUES('ming', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '4', '0', '1', '清洁工'
    , '工人', '12547896321', '12345', '111','124452@qq.com', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg'
    , '1', '12345', '0', '6222020903001483077', '合同1', '2020-06-20', '24', '2022-06-20');

DROP TABLE IF EXISTS `file`;
CREATE  table file(
     wid int references staff(wid), --外键关联职工编号
     fileId VARCHAR(20) primary key , --文件id
     fileName varchar(255) default null, --文件名
     fileSize   varchar(255)  default null,   --文件大小
     fileClass varchar(20) default null, --文件类型
);

--权限部分
--@author Wujiewei
--两个实体表，一个映射表，多对多关系
--要区分职工和本系统的管理员的id
DROP TABLE IF EXISTS `managers`;
CREATE  table managers(
                    id int identity(2019500,1)  PRIMARY KEY, --工号
                    name VARCHAR(255),  --姓名
                    state tinyint(1) default 0, --登录状态，取值{0,1}，默认值0
                    CONSTRAINT chk_state CHECK (state = 1 OR state = 0)
);
insert into managers(name, state) values('王宝强', 0);
insert into managers(name, state) values('周润发', 0);
insert into managers(name, state) values('刘德华', 1);
insert into managers(name, state) values('郭富城', 0);
insert into managers(name, state) values('王祖贤', 1);


DROP TABLE IF EXISTS `roles`;
CREATE  table roles(
                    id int identity(0,1)  PRIMARY KEY, --角色主键
                    name VARCHAR(255),  --角色名称
                    page_power VARCHAR(255), --页面权限，一串二进制数，长度固定
                    department_power VARCHAR(255),  -- 部门权限，一串二进制数，随着部门的增加，长度增长
);
insert into roles(name, page_power, department_power) values('超级管理员', 'FFFFFF', '111');
insert into roles(name, page_power, department_power) values('国交局人员', 'FFF000', '010');
insert into roles(name, page_power, department_power) values('后勤人员', 'FFF000', '001');
-- ---
--      a. 人员列表页面
-- 　　　b. 薪酬管理页面
-- 　　　c. 合同管理页面
-- 　　　d. 日志管理页面
-- 　　　e. 管理员列表页面
-- 　　　f. 角色管理页面
--         对应page_power的 'abcdef' 'FFF000' 十六进制 ’1111 1111 1111 0000 0000 0000‘ 每四位都代表每个页面的增删改查
-- ---
-- ---
--      a. 超级管理员
-- 　　　b. 国交局
-- 　　　c. 学校后勤
-- 　       对应department_power的 'abc' '111' '010' '001'
-- ---

DROP TABLE IF EXISTS `roles_managers`;
CREATE  table roles_managers(
                    id int identity(0,1)  PRIMARY KEY, --角色和管理的组合，每当更改权限，就增加一条记录
                    managers_id int,  --管理员主键
                    roles_id int, --角色主键
                    FOREIGN KEY(managers_id) REFERENCES managers(id),
                    FOREIGN KEY(roles_id) REFERENCES roles(id)
);
insert into roles_managers(managers_id, roles_id) values(2019502, 2);
insert into roles_managers(managers_id, roles_id) values(2019502, 0);
insert into roles_managers(managers_id, roles_id) values(2019501, 1);
insert into roles_managers(managers_id, roles_id) values(2019501, 2);
insert into roles_managers(managers_id, roles_id) values(2019502, 1);
insert into roles_managers(managers_id, roles_id) values(2019503, 2);
insert into roles_managers(managers_id, roles_id) values(2019504, 1);
-- insert into roles_managers(managers_id, roles_id) values(2019505, 2);


