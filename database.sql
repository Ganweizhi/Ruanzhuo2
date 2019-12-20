-- 课程表
DROP table if exists course;
create table course(
    course_id int primary key AUTO_INCREMENT not null,
    course_name varchar (255) DEFAULT NULL,
    course_introduction varchar (255) DEFAULT NULL,
    course_feature varchar (255) DEFAULT NULL,
    course_material varchar (255) DEFAULT NULL,
    course_history varchar (255)DEFAULT NULL,
    course_principal varchar (255) DEFAULT NULL,
    course_credit varchar(255) DEFAULT NULL,
    course_period varchar(255) DEFAULT NULL
);
-- 教师表
DROP table if exists teacher;
create table teacher(
    teacher_id int primary key AUTO_INCREMENT not null,
    teacher_name varchar (255) DEFAULT NULL,
    academy_id int ,
    teacher_birth date DEFAULT NULL,
    teacher_sex varchar(2) DEFAULT NULL check(teacher_sex='male' or teacher_sex = 'female'),
    teacher_rank varchar(255) DEFAULT NULL ,
    teacher_phone int DEFAULT NULL,
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
-- 开课表
DROP table if exists successCourse;
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


insert into academy(academy_name) values ( "test" );
insert into teacher(teacher_name,academy_id) values ( "钟大师",1 );
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
    student_phone int DEFAULT NULL,
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
        foreign key (success_id) references successcourse
);


-- 9.青年教师培养
DROP table if exists young;
create table young(
 young_id varchar(200) not null primary key,
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
   resource_textbook  varchar(255) DEFAULT NULL,
   resource_video  varchar(255) DEFAULT NULL,
   resource_base  varchar(255) DEFAULT NULL,
   resource_experiment  varchar(255) DEFAULT NULL,
   resource_document  varchar(255) DEFAULT NULL,
   PRIMARY KEY  ( resource_id ),
   FOREIGN KEY ( success_id ) REFERENCES  successcourse  ( success_id )
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
	 experiment_id int NOT NULL auto_increment,
	 experiment_huanj varchar(255) DEFAULT NULL,
	 experiment_operation varchar(255) DEFAULT NULL,
	 experiment_xit varchar(255) DEFAULT NULL,
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
	 FOREIGN KEY (success_id) REFERENCES successcourse(success_id)
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
	 FOREIGN KEY (success_id) REFERENCES successcourse(success_id)
);

-- 日历表
DROP TABLE IF EXISTS calendar;
CREATE TABLE calendar(
	 calendar_id int NOT NULL auto_increment primary key,
   calendar_title varchar(255) DEFAULT NULL,
   calendar_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successcourse(success_id)
);

-- 教学内容表
DROP TABLE IF EXISTS contentb;
CREATE TABLE contentb(
	 contentb_id int NOT NULL auto_increment primary key,
   contentb_title varchar(255) DEFAULT NULL,
   contentb_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successcourse(success_id)
);
-- 教学计划表
DROP TABLE IF EXISTS planb;
CREATE TABLE planb(
	 planb_id int NOT NULL auto_increment primary key,
   planb_title varchar(255) DEFAULT NULL,
   planb_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successcourse(success_id)
);
-- 教学难点表
DROP TABLE IF EXISTS problemb;
CREATE TABLE problemb(
	 problemb_id int NOT NULL auto_increment primary key,
   problemb_title varchar(255) DEFAULT NULL,
   problemb_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successcourse(success_id)
);
-- 教学方法表
DROP TABLE IF EXISTS methodb;
CREATE TABLE methodb(
	 methodb_id int NOT NULL auto_increment primary key,
   methodb_title varchar(255) DEFAULT NULL,
   methodb_content varchar(255)DEFAULT NULL,
   success_id int ,
   FOREIGN KEY (success_id) REFERENCES successcourse(success_id)
);
-- 账号表
DROP TABLE IF EXISTS userb;
CREATE TABLE userb(
	 userb_id int not null primary key,
   userb_password varchar(15) DEFAULT NULL,
   userb_type varchar(10) check(userb_type='admin' or userb_type='second' or userb_type = 'teachaer' or userb_type = 'student'),
   userb_phone int DEFAULT NULL,
   userb_email varchar(30) DEFAULT NULL,
   student_id int,
   teacher_id int,
   FOREIGN KEY (student_id) REFERENCES student(student_id),
   FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
   
);
