DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `wid` int identity(2019500,1)  PRIMARY KEY, --工号
  `name` varchar(255) DEFAULT NULL, --姓名
  `sex` varchar(2) DEFAULT NULL, --性别
  `nation` varchar(20) DEFAULT NULL, --民族
  `nationality` varchar(20) DEFAULT NULL, --国籍
  `origin` varchar(255) DEFAULT NULL, --籍贯
  `idType` varchar(255) DEFAULT NULL, --证件类型
  `idNumber` varchar(18) DEFAULT NULL, --证件号
  `education` varchar(255) DEFAULT NULL, --学历
  `degree` varchar(255) DEFAULT NULL, --学位
  `department` varchar(255) DEFAULT NULL, --部门
  `job` varchar(255) DEFAULT NULL, --岗位
  `title` varchar(255) DEFAULT NULL, --职称
  `lPhone` varchar(12) DEFAULT NULL, --手机长号
  `sPhone` varchar(12) DEFAULT NULL, --短号
  `gPhone` varchar(12) DEFAULT NULL, --固定电话
  `email` varchar(20) DEFAULT NULL, --邮箱
  `img` varchar(255) DEFAULT NULL, --头像
  `state` varchar(20) DEFAULT NULL, --状态
  `baseWage` varchar(20) DEFAULT NULL, --基本工资
  `bankName` varchar(20) DEFAULT NULL, --银行名称
  `bankId` varchar(20) DEFAULT NULL, --银行账号
  `htName` varchar(255) DEFAULT NULL, --合同名称
  `signingTime` varchar(255) DEFAULT NULL, --签约时间
  `useTime` varchar(255) DEFAULT NULL, --合同有效期
  `departureTime` varchar(255) DEFAULT NULL, --离职时间
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
