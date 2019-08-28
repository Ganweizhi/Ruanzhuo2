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
  email varchar(20) DEFAULT NULL, --邮箱
  baseWage varchar(20) DEFAULT NULL, --基本工资
  bankName varchar(20) DEFAULT NULL, --银行名称
  bankId varchar(20) DEFAULT NULL, --银行账号
  departureTime varchar(20) DEFAULT NULL, //离职时间
  img varchar(255) DEFAULT NULL, --头像
  sfzz varchar(255) DEFAULT NULL, --身份证正面
  sfzf varchar(255) DEFAULT NULL, --身份证反面
  yhkz varchar(255) DEFAULT NULL, --银行卡正面
  yhkf varchar(255) DEFAULT NULL, --银行卡反面
);
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                   email,baseWage,bankName,bankId,img)
                   VALUES('张三', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '博士研究生', '学士', '0', '清洁工'
                            , '工人', '12547896321', '12345','751609938@qq.com'
                            , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('张三', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '博士研究生', '学士', '0', '清洁工'
      , '工人', '12547896321', '12345','1790992954@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('张三', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '博士研究生', '学士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ming', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '本科毕业生', '硕士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ming', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '本科毕业生', '硕士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ming', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '本科毕业生', '硕士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ming', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '本科毕业生', '硕士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ccc', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '硕士研究生', '学位', '1', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ccc', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '硕士研究生', '学位', '1', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ccc', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '硕士研究生', '学位', '1', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ccc', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '硕士研究生', '学位', '1', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '12345', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');

DROP TABLE IF EXISTS `ht`;
CREATE  table ht(
     wid int references staff(wid), --外键关联职工编号
     hid varchar(255) primary key , --ht id
     hName varchar(255) default null, --ht名字
     hUrl   varchar(255)  default null,   --ht路径
     useTime varchar(20) default null, -- 合同有效期
     signingTime varchar(20) default null, --签约时间
);

DROP TABLE IF EXISTS `PHT`;
create table pht(
  HID varchar(255) primary key references ht(hid)
);
--insert into ht(hid,wid,useTime,signingTime) values (1,2019500,'1','2019-8-27');

DROP TABLE--insert into ht(hid,wid,useTime,signingTime) values (2,2019501,'2','2019-8-27');
  IF EXISTS `wages`;
CREATE  table wages(
    wid int references staff(wid), --外键关联职工编号
    wageId int primary key , -- id
    baseWage varchar(255) default null, --基本工资
    time   varchar(255)  default null,   --签约时间
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
insert into roles_managers(managers_id, roles_id) values(2019500, 0);
-- insert into roles_managers(managers_id, roles_id) values(2019505, 2);



-- 日志
DROP TABLE IF EXISTS `log`;
CREATE  table log(
        lid int identity(0,1)  PRIMARY KEY,
        date VARCHAR(255),
        gid VARCHAR(255),
        name VARCHAR(255),
        ip VARCHAR(255),
        action VARCHAR(255),
        FOREIGN KEY(gid) REFERENCES managers(id)
);

-- 页面对应的权限(待定)
DROP TABLE IF EXISTS `page_power`;
CREATE  table page_power(
        index int PRIMARY KEY,
        url VARCHAR(255)
);
insert into page_power(index, url) values(0, '/list');
insert into page_power(index, url) values(1, '/edit');
insert into page_power(index, url) values(2, '/delete');
insert into page_power(index, url) values(3, '/add');

insert into page_power(index, url) values(4, '/loglist');
insert into page_power(index, url) values(5, '');
insert into page_power(index, url) values(6, '');
insert into page_power(index, url) values(7, '');

insert into page_power(index, url) values(8, '/gllist');
insert into page_power(index, url) values(9, '/gledit');
insert into page_power(index, url) values(10, '/');
insert into page_power(index, url) values(11, '/gladda');

insert into page_power(index, url) values(12, '/rolelist');
insert into page_power(index, url) values(13, '/edit');
insert into page_power(index, url) values(14, '/roledelete');
insert into page_power(index, url) values(15, '/roleadd');
