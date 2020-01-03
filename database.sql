
-- 教师表
DROP table if exists teacher;
create table teacher(
    teacher_id int primary key AUTO_INCREMENT not null,
    teacher_name varchar (255) DEFAULT NULL,
    academy_id int ,
    teacher_birth date DEFAULT NULL,
    teacher_sex varchar(55) DEFAULT NULL check(teacher_sex='male' or teacher_sex = 'female'),
    teacher_rank varchar(255) DEFAULT NULL ,
    teacher_phone varchar(255) DEFAULT NULL,
    teacher_email varchar(30) DEFAULT NULL,
    teacher_qualification varchar(255) DEFAULT NULL,
    teacher_domain varchar(255) DEFAULT NULL,
    teacher_job varchar(255) DEFAULT NULL,
    teacher_address varchar(255) DEFAULT NULL,
    teacher_resdire varchar(255) DEFAULT NULL,
    teacher_resume varchar(255) DEFAULT NULL,
    teacher_photo varchar(255) DEFAULT NULL,
    foreign key (academy_id) references academy(academy_id)
);
-- 课程表
DROP table if exists course;
create table course(
    course_id int primary key AUTO_INCREMENT not null,
    course_name varchar (255) DEFAULT NULL,
    course_introduction varchar (255) DEFAULT NULL,
    course_feature varchar (255) DEFAULT NULL,
    course_material varchar (255) DEFAULT NULL,
    course_history varchar (255)DEFAULT NULL,
    course_principal int ,
    course_credit varchar(255) DEFAULT NULL,
    course_period varchar(255) DEFAULT NULL,
    foreign key (course_principal) references teacher(teacher_id)
);
-- 开课表
DROP table if exists succes5sCourse;
create table successCourse(
    success_id int primary key AUTO_INCREMENT not null,
    course_id int ,
    teacher_id int ,
    time varchar (255) DEFAULT NULL,
    success_myself varchar (255) DEFAULT NULL,
    success_student varchar (255) DEFAULT NULL,
    success_society varchar (255) DEFAULT NULL,
    success_evaluation varchar (255) DEFAULT NULL,
    success_wechat varchar (255) DEFAULT NULL,
    success_QQ varchar (255) DEFAULT NULL,
    success_port varchar (255) DEFAULT NULL,
    foreign key (course_id) references course(course_id),
    foreign key (teacher_id) references teacher(teacher_id)
);

-- 上课班级表
DROP table if exists sclass;
create table sclass(
    sclass_id int primary key  AUTO_INCREMENT not null,
    sclass_position varchar (255) DEFAULT NULL,
    sclass_time varchar (255) DEFAULT NULL
);
-- 教师团队表
DROP table if exists team;
create table team
(
    team_id int auto_increment not null,
    team_name varchar(255) DEFAULT NULL,
    course_id int ,
    photo_team varchar(255) DEFAULT NULL ,
    constraint team_id_pk
        primary key (team_id),
    constraint team_course_fk
        foreign key (course_id) references course(course_id)
);
-- 学生表
DROP table if exists student;
create table student
(
    student_id int auto_increment not null,
    student_name varchar(255) DEFAULT NULL,
    student_grade varchar(255) DEFAULT NULL,
    class_id int ,
    student_sex varchar(2) DEFAULT NULL check(student_sex='male' or student_sex = 'female'),
    student_birth date DEFAULT NULL,
    student_natplace varchar(255) DEFAULT NULL, -- 籍贯
    student_email varchar(30) DEFAULT NULL,
    student_phone varchar(255) DEFAULT NULL,
    constraint student_id_pk
        primary key (student_id),
    constraint student_class_fk
        foreign key (class_id) references class
);

-- 教师与团队从属关系表
DROP table if exists tbelongt;
create table tbelongt
(
    tbelongt_id int auto_increment not null,
    teacher_id int DEFAULT NULL,
    team_id int DEFAULT NULL,
    constraint tbelongt_id_pk
        primary key (tbelongt_id),
    constraint tbelongt_teacher_fk
        foreign key (teacher_id) references teacher,
    constraint tbelongt_team_fk
        foreign key (team_id) references team
);
-- 学生选课表
DROP table if exists selectcourse;
create table selectcourse
(
    select_id int auto_increment not null,
    score int check(score<=100) ,
    ususcore int   check(ususcore<=100),
    midscore int   check(midscore<=100),
    finalscore int check(finalscore<=100) ,
    bigworkscore int check(bigworkscore<=100) ,
    student_id int,
    success_id int,

    constraint select_id_pk
        primary key (select_id),
    constraint selectcourse_student_fk
        foreign key (student_id) references student,
    constraint selectcourse_success_fk
        foreign key (success_id) references successCourse
);


-- 9.青年教师培养
DROP table if exists young;
create table young(
 young_id int not null primary key auto_increment,
 teacher_id int,
 content varchar(255) DEFAULT NULL,
 foreign key (teacher_id) references teacher(teacher_id)
);

-- 10.教学改革措施
DROP table if exists measure;
create table measure(
measure_id varchar(255) not null primary key ,
measure_title varchar(255) DEFAULT NULL,
measure_time time DEFAULT NULL,
measure_address varchar(255) DEFAULT NULL
);




-- 12.教师改革立项
DROP table if exists approval;
create table approval(
approval_id varchar(255) not null primary key,
approval_title varchar(255) DEFAULT NULL,
approval_time time DEFAULT NULL,
approval_address varchar(255) DEFAULT NULL
);

-- 改革成果表
DROP TABLE IF EXISTS achievement;
CREATE TABLE achievement(
    achievement_id  int NOT NULL auto_increment,
    achievement_title varchar(255) DEFAULT NULL,
    achievement_time time DEFAULT NULL,
    achievement_address   varchar(255) default NULL,
    PRIMARY KEY  (  achievement_id  )
);
-- 改革奖励表
DROP TABLE IF EXISTS  award ;
CREATE TABLE  award  (
   award_id  int NOT NULL auto_increment,
   award_title varchar(255) DEFAULT NULL,
   award_time time DEFAULT NULL,
   award_address  varchar(255) default NULL,
  PRIMARY KEY  (award_id)
);
-- 资源表
DROP TABLE IF EXISTS  resource ;
CREATE TABLE  resource  (
   resource_id  int NOT NULL auto_increment,
   success_id  int ,
   resource_textbook  varchar(255) DEFAULT NULL,   #课程课件
   resource_video  varchar(255) DEFAULT NULL,	   #教学视频
   resource_base  varchar(255) DEFAULT NULL,       #习题库
   resource_experiment  varchar(255) DEFAULT NULL, #案例库
   resource_document  varchar(255) DEFAULT NULL,   #文档
   PRIMARY KEY  ( resource_id ),
   FOREIGN KEY ( success_id ) REFERENCES  successCourse  ( success_id )
);
-- 班级表
DROP TABLE IF EXISTS  class ;
CREATE TABLE  class  (
   class_id  int NOT NULL auto_increment,
   academy_id  int ,
   class_name  varchar(255) DEFAULT NULL,
   PRIMARY KEY  ( class_id ),
   FOREIGN KEY ( academy_id ) REFERENCES  academy  ( academy_id )
);
-- 实验案例库表
DROP TABLE IF EXISTS experiment_house;
CREATE TABLE experiment_house(
	 experiment_id int NOT NULL auto_increment,         #主键
	 experiment_huanj varchar(255) DEFAULT NULL,        #实验环境
	 experiment_operation varchar(255) DEFAULT NULL,    #实验安装
	 experiment_xit varchar(255) DEFAULT NULL,          #实验系统代码
	 resource_id  int,
	 PRIMARY KEY  (experiment_id),
	 FOREIGN KEY (resource_id) REFERENCES resource(resource_id)
);
-- 家庭作业表
DROP TABLE IF EXISTS homework;
CREATE TABLE homework(
	 homework_id int NOT NULL auto_increment,
	 homework varchar(255) DEFAULT NULL,
	 student_id int ,
	 success_id int ,
	 PRIMARY KEY  (homework_id),
	 FOREIGN KEY (student_id) REFERENCES student(student_id),
	 FOREIGN KEY (success_id) REFERENCES successCourse(success_id)
);
-- 学院表
DROP TABLE IF EXISTS academy;
CREATE TABLE academy(
	 academy_id int NOT NULL auto_increment,
	 academy_name varchar(255) DEFAULT NULL,
	 PRIMARY KEY  (academy_id)
);
-- 家庭作业案例表
DROP TABLE IF EXISTS homeworkcase;
CREATE TABLE homeworkcase(
	 homework_case_id int NOT NULL auto_increment,
	 homework_id int ,
	 success_id int ,
	 PRIMARY KEY  (homework_case_id),
	 FOREIGN KEY (homework_id) REFERENCES homework(homework_id),
	 FOREIGN KEY (success_id) REFERENCES successCourse(success_id)
);

-- 日历表
DROP TABLE IF EXISTS calendar;
CREATE TABLE calendar(
	 calendar_id int NOT NULL auto_increment primary key,
   calendar_title varchar(255) DEFAULT NULL,
   calendar_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successCourse(success_id)
);

-- 教学内容表
DROP TABLE IF EXISTS contentb;
CREATE TABLE contentb(
	 contentb_id int NOT NULL auto_increment primary key,
   contentb_title varchar(255) DEFAULT NULL,
   contentb_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successCourse(success_id)
);
-- 教学计划表
DROP TABLE IF EXISTS planb;
CREATE TABLE planb(
	 planb_id int NOT NULL auto_increment primary key,
   planb_title varchar(255) DEFAULT NULL,
   planb_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successCourse(success_id)
);
-- 教学难点表
DROP TABLE IF EXISTS problemb;
CREATE TABLE problemb(
	 problemb_id int NOT NULL auto_increment primary key,
   problemb_title varchar(255) DEFAULT NULL,
   problemb_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successCourse(success_id)
);
-- 教学方法表
DROP TABLE IF EXISTS methodb;
CREATE TABLE methodb(
	 methodb_id int NOT NULL auto_increment primary key,
   methodb_title varchar(255) DEFAULT NULL,
   methodb_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successCourse(success_id)
);
-- 账号表
DROP TABLE IF EXISTS userb;
CREATE TABLE userb(
	 userb_id int not null primary key,
   userb_password varchar(15) DEFAULT NULL,
   userb_type varchar(10) check(userb_type='admin' or userb_type='second' or userb_type = 'teachaer' or userb_type = 'student'),
   userb_phone varchar(255) DEFAULT NULL,
   userb_email varchar(30) DEFAULT NULL,
   student_id int,
   teacher_id int,
   FOREIGN KEY (student_id) REFERENCES student(student_id),
   FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
   
);
drop table if exists question;
drop table if exists question;
create table question(
                         question_id int primary key NOT NULL auto_increment,
                         name varchar(20) not null ,
                         title varchar(255) not null,
                         times date default null,
                         content varchar(5000) default null,
                         answer varchar(5000) default null
)

-- insert into academy(academy_name) values('aa');
-- insert into academy(academy_name) values('aa');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('aa','bb','cc','dd','ee','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('aa','bb','cc','dd','ee','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('aa','bb','cc','dd','ee','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('aa','bb','cc','dd','ee','1','ff','gg');
-- insert into teacher(teacher_name,academy_id,teacher_birth,teacher_sex,teacher_rank,teacher_phone,teacher_email,teacher_qualification,teacher_domain,teacher_job,teacher_address,teacher_resdire,teacher_resume) values('aa','1',now(),'1','ee','1111','ff','gg','ff','gg','ff','gg','ff');
-- insert into teacher(teacher_name,academy_id,teacher_birth,teacher_sex,teacher_rank,teacher_phone,teacher_email,teacher_qualification,teacher_domain,teacher_job,teacher_address,teacher_resdire,teacher_resume) values('aa','2',now(),'2','ee','1111','ff','gg','ff','gg','ff','gg','ff');
-- insert into teacher(teacher_name,academy_id,teacher_birth,teacher_sex,teacher_rank,teacher_phone,teacher_email,teacher_qualification,teacher_domain,teacher_job,teacher_address,teacher_resdire,teacher_resume) values('aa','1',now(),'1','ee','1111','ff','gg','ff','gg','ff','gg','ff');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件1','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件2','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件3','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件4','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件5','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件6','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件7','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件8','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件9','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件10','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- insert into course(course_name,course_introduction,course_feature,course_material,course_history,course_principal,course_credit,course_period) values('软件11','好好看书','努力学习','哈哈哈','没历史','1','ff','gg');
-- INSERT into team(team_name,course_id,photo_team) VALUES('team1','1','images/teacher_img2.jpg');
-- INSERT into team(team_name,course_id,photo_team) VALUES('team2','2', 'images/teacher_img2.jpg');
-- insert into tbelongt(teacher_id,team_id) VALUES('1','3');
-- insert into tbelongt(teacher_id,team_id) VALUES('2','3');
-- insert into tbelongt(teacher_id,team_id) VALUES('24','1');
-- insert into tbelongt(teacher_id,team_id) VALUES('33','1');

-- INSERT successCourse(success_id,course_id,teacher_id,time,success_myself,success_student,success_society,success_evaluation,success_wechat,success_QQ,success_port) VALUES('1','1','1','2018','aa','bb','cc','dd','ee','ff','gg');
-- INSERT successCourse(success_id,course_id,teacher_id,time,success_myself,success_student,success_society,success_evaluation,success_wechat,success_QQ,success_port) VALUES('2','2','1','2018','aa','bb','cc','dd','ee','ff','gg');
-- INSERT successCourse(success_id,course_id,teacher_id,time,success_myself,success_student,success_society,success_evaluation,success_wechat,success_QQ,success_port) VALUES('3','3','2','2018','aa','bb','cc','dd','ee','ff','gg');

-- insert young(young_id,teacher_id,content) VALUES('1','1','哈哈哈');
-- insert young(young_id,teacher_id,content) VALUES('2','2','啦啦啦');
-- insert young(young_id,teacher_id,content) VALUES('3','3','拉拉');
-- insert young(young_id,teacher_id,content) VALUES('4','4','哦哦哦');