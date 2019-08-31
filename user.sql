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
                            , '123456', '0', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('张三', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '博士研究生', '学士', '0', '清洁工'
      , '工人', '12547896321', '12345','1790992954@qq.com'
      , '123456', '4', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('张三', '0', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '博士研究生', '学士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '123456', '3', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ming', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '本科毕业生', '硕士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '123456', '6', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ming', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '本科毕业生', '硕士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '123456', '7', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ming', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '本科毕业生', '硕士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '123456', '9', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ming', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '本科毕业生', '硕士', '0', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '123456', '4', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ccc', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '硕士研究生', '硕士', '1', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '123456', '6', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ccc', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '硕士研究生', '硕士', '1', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '123456', '8', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ccc', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '硕士研究生', '硕士', '1', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '123456', '9', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');
INSERT INTO STAFF(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,
                  email,baseWage,bankName,bankId,img)
VALUES('ccc', '1', '汉族', '中国','广东省东莞市', '0', '432503197505028819', '硕士研究生', '硕士', '1', '清洁工'
      , '工人', '12547896321', '12345','124452@qq.com'
      , '123456', '8', '6222020903001483077', 'https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg');

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
                    id VARCHAR(255) PRIMARY KEY, --工号
                    name VARCHAR(255),  --姓名
                    state tinyint(1) default 0, --登录状态，取值{0,1}，默认值0
                    CONSTRAINT chk_state CHECK (state = 1 OR state = 0)
);
insert into managers(id, state) values('201741412224', 1);
insert into managers(id, state) values('110', 0);
insert into managers(id, state) values('120', 1);
insert into managers(id, state) values('119', 0);
insert into managers(id, state) values('911', 1);

insert into managers(id, state) values('201741412214', 1);
insert into managers(id, state) values('201741412205', 1);
insert into managers(id, state) values('201741404149', 1);


DROP TABLE IF EXISTS `roles`;
CREATE  table roles(
                    id int identity(0,1)  PRIMARY KEY, --角色主键
                    name VARCHAR(255),  --角色名称
                    page_power VARCHAR(255), --页面权限，一串二进制数，长度固定
                    department_power VARCHAR(255),  -- 部门权限，一串二进制数，随着部门的增加，长度增长
);
insert into roles(name, page_power, department_power) values('超级管理员', 'FFFFF', '11');
insert into roles(name, page_power, department_power) values('国交局人员', 'FFFFF', '11');
insert into roles(name, page_power, department_power) values('后勤人员', 'FFFFF', '11');
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
                    managers_id VARCHAR(255),  --管理员主键
                    roles_id int, --角色主键
                    FOREIGN KEY(managers_id) REFERENCES managers(id),
                    FOREIGN KEY(roles_id) REFERENCES roles(id)
);
insert into roles_managers(managers_id, roles_id) values('201741412224', 0);
insert into roles_managers(managers_id, roles_id) values('110', 0);
insert into roles_managers(managers_id, roles_id) values('120', 1);
insert into roles_managers(managers_id, roles_id) values('120', 2);
insert into roles_managers(managers_id, roles_id) values('119', 1);
insert into roles_managers(managers_id, roles_id) values('119', 2);
insert into roles_managers(managers_id, roles_id) values('911', 1);
insert into roles_managers(managers_id, roles_id) values('911', 0);
-- insert into roles_managers(managers_id, roles_id) values(2019505, 2);

insert into roles_managers(managers_id, roles_id) values('201741412214', 1);
insert into roles_managers(managers_id, roles_id) values('201741412214', 2);
insert into roles_managers(managers_id, roles_id) values('201741412205', 0);
insert into roles_managers(managers_id, roles_id) values('201741404149', 0);



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

DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `bank_name` varchar(20) NOT NULL COMMENT '银行名称',
                        `bank_code` varchar(11) NOT NULL COMMENT '银行标识码',
                        PRIMARY KEY (`id`)
);

INSERT INTO `bank` (`id`, `bank_name`, `bank_code`)
VALUES(2,'招商银行','CMB'),
      (3,'建设银行','CCB'),
      (4,'交通银行','BOCOM'),
      (5,'邮储银行','PSBC'),
      (6,'工商银行','ICBC'),
      (7,'农业银行','ABC'),
      (8,'中国银行','BOC'),
      (9,'中信银行','CITIC'),
      (10,'光大银行','CEB'),
      (11,'华夏银行',' HXB'),
      (12,'民生银行','CMSB'),
      (13,'广发银行','CGB'),
      (14,'平安银行','SZD'),
      (15,'星展银行','DBS'),
      (16,'恒生银行','HSBC'),
      (17,'渣打银行','SCBFF'),
      (18,'汇丰银行','HSBC'),
      (19,'东亚银行','HKBEA'),
      (20,'花旗银行',''),
      (21,'浙商银行','CZB'),
      (22,'恒丰银行','HFB'),
      (23,'浦东发展银行','SPDB'),
      (24,'兴业银行','CIB'),
      (26,'齐鲁银行','QLB'),
      (27,'烟台银行','YTB'),
      (28,'淮坊银行','WFB'),
      (31,'渤海银行',''),
      (32,'上海银行','BOS'),
      (33,'厦门银行',''),
      (34,'北京银行','BCCB'),
      (35,'福建海峡银行',''),
      (36,'吉林银行',''),
      (38,'宁波银行','NBCB'),
      (39,'焦作市商业银行',''),
      (40,'温州银行',''),
      (41,'广州银行',''),
      (42,'汉口银行',''),
      (43,'龙江银行',''),
      (44,'盛京银行',''),
      (45,'洛阳银行',''),
      (46,'辽阳银行',''),
      (47,'大连银行','BODL'),
      (48,'苏州银行',''),
      (49,'河北银行',''),
      (50,'杭州银行','HCCB'),
      (51,'南京银行',''),
      (52,'东莞银行',''),
      (53,'金华银行',''),
      (54,'乌鲁木齐商业银行',''),
      (55,'绍兴银行',''),
      (56,'成都银行',''),
      (57,'抚顺银行',''),
      (58,'临商银行',''),
      (59,'宜昌市商业银行',''),
      (60,'葫芦岛银行',''),
      (61,'郑州银行',''),
      (62,'宁夏银行',''),
      (63,'珠海华润银行',''),
      (64,'齐商银行',''),
      (65,'锦州银行',''),
      (66,'徽商银行',''),
      (67,'重庆银行',''),
      (68,'哈尔滨银行',''),
      (69,'贵阳银行',''),
      (70,'西安银行',''),
      (71,'无锡市商业银行',''),
      (72,'丹东银行',''),
      (73,'兰州银行',''),
      (74,'南昌银行',''),
      (75,'晋商银行',''),
      (76,'青岛银行',''),
      (77,'南通商业银行',''),
      (78,'九江银行',''),
      (79,'日照银行',''),
      (80,'鞍山银行',''),
      (81,'秦皇岛银行',''),
      (82,'青海银行',''),
      (83,'台州银行',''),
      (84,'盐城银行',''),
      (85,'长沙银行',''),
      (86,'赣州银行',''),
      (87,'泉州银行',''),
      (88,'营口银行',''),
      (89,'富滇银行',''),
      (90,'阜新银行',''),
      (91,'嘉兴银行',''),
      (92,'廊坊银行',''),
      (93,'泰隆商业银行',''),
      (94,'内蒙古银行',''),
      (95,'湖州银行',''),
      (96,'沧州银行',''),
      (97,'广西北部湾银行',''),
      (98,'包商银行',''),
      (100,'威海商业银行',''),
      (101,'攀枝花市商业银行',''),
      (102,'绵阳市商业银行',''),
      (103,'泸州市商业银行',''),
      (104,'三门峡银行',''),
      (106,'邢台银行','XTB'),
      (107,'商丘市商业银行',''),
      (108,'安徽省农村信用社','AHNSYH'),
      (109,'江西省农村信用社',''),
      (110,'湖南农村信用社',''),
      (111,'无锡农村商业银行','');
