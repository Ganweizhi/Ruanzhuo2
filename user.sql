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
  `signingTime` Date DEFAULT NULL, --签约时间
  `useTime` Date DEFAULT NULL, --合同有效期
  `departureTime` Date DEFAULT NULL, --离职时间
);
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');
INSERT INTO STAFF(name) VALUES ('ming');

DROP TABLE IF EXISTS `file`;
CREATE  table file(
                    wid int references staff(wid), --外键关联职工编号
                    fileId VARCHAR(20) primary key , --文件id
                    fileName varchar(255) default null, --文件名
                    fileSize   varchar(255)  default null,   --文件大小
                    fileClass varchar(20) default null, --文件类型
)
