-- 学院表
DROP TABLE IF EXISTS academy;
CREATE TABLE academy
(
    academy_id   int NOT NULL auto_increment,
    academy_name varchar(255) DEFAULT NULL,
    primary key (academy_id)
);

-- 上课班级表
DROP table if exists sclass;
create table sclass
(
    sclass_id       int AUTO_INCREMENT not null,
    sclass_position varchar(255) DEFAULT NULL,
    sclass_time     varchar(255) DEFAULT NULL,
    primary key (sclass_id)
);


-- 教师表
DROP table if exists teacher;
create table teacher
(
    teacher_id            int AUTO_INCREMENT not null,
    teacher_name          varchar(255) DEFAULT NULL,
    academy_id            int,
    teacher_birth         date         DEFAULT NULL,
    teacher_sex           varchar(55)  DEFAULT NULL check (teacher_sex = 'male' or teacher_sex = 'female'),
    teacher_rank          varchar(255) DEFAULT NULL,
    teacher_phone         varchar(255) DEFAULT NULL,
    teacher_email         varchar(30)  DEFAULT NULL,
    teacher_qualification varchar(255) DEFAULT NULL,
    teacher_domain        varchar(255) DEFAULT NULL,
    teacher_job           varchar(255) DEFAULT NULL,
    teacher_address       varchar(255) DEFAULT NULL,
    teacher_resdire       varchar(255) DEFAULT NULL,
    teacher_resume        varchar(255) DEFAULT NULL,
    teacher_photo         varchar(255) DEFAULT NULL,
    foreign key (academy_id) references academy (academy_id),
    primary key (teacher_id)
);
-- 课程表
DROP table if exists course;
create table course
(
    course_id           int AUTO_INCREMENT not null,
    course_name         varchar(255) DEFAULT NULL,
    course_introduction varchar(255) DEFAULT NULL,
    course_feature      varchar(255) DEFAULT NULL,
    course_material     varchar(255) DEFAULT NULL,
    course_history      varchar(255) DEFAULT NULL,
    course_principal    int,
    course_credit       varchar(255) DEFAULT NULL,
    course_period       varchar(255) DEFAULT NULL,
    foreign key (course_principal) references teacher (teacher_id),
    primary key (course_id)
);
-- 开课表
DROP table if exists successCourse;
create table successCourse
(
    success_id         int AUTO_INCREMENT not null,
    course_id          int,
    teacher_id         int,
    time               varchar(255) DEFAULT NULL,
    success_myself     varchar(255) DEFAULT NULL,
    success_student    varchar(255) DEFAULT NULL,
    success_society    varchar(255) DEFAULT NULL,
    success_evaluation varchar(255) DEFAULT NULL,
    success_wechat     varchar(255) DEFAULT NULL,
    success_QQ         varchar(255) DEFAULT NULL,
    success_port       varchar(255) DEFAULT NULL,
    foreign key (course_id) references course (course_id),
    foreign key (teacher_id) references teacher (teacher_id),
    primary key (success_id)
);


-- 教师团队表
DROP table if exists team;
create table team
(
    team_id    int auto_increment not null,
    team_name  varchar(255) DEFAULT NULL,
    course_id  int,
    photo_team varchar(255) DEFAULT NULL,
    primary key (team_id),
    foreign key (course_id) references course (course_id)
);
-- 班级表
DROP TABLE IF EXISTS class;
CREATE TABLE class
(
    class_id   int NOT NULL auto_increment,
    academy_id int,
    class_name varchar(255) DEFAULT NULL,
    primary key (class_id),
    FOREIGN KEY (academy_id) REFERENCES academy (academy_id)
);
-- 学生表
DROP table if exists student;
create table student
(
    student_id       int auto_increment not null,
    student_name     varchar(255) DEFAULT NULL,
    student_grade    varchar(255) DEFAULT NULL,
    class_id         int,
    student_sex      varchar(25)  DEFAULT NULL check (student_sex = 'male' or student_sex = 'female'),
    student_birth    date         DEFAULT NULL,
    student_natplace varchar(255) DEFAULT NULL, -- 籍贯
    student_email    varchar(30)  DEFAULT NULL,
    student_phone    varchar(255) DEFAULT NULL,
    primary key (student_id),
    foreign key (class_id) references class (class_id)
);

-- 教师与团队从属关系表
DROP table if exists tbelongt;
create table tbelongt
(
    tbelongt_id int auto_increment not null,
    teacher_id  int DEFAULT NULL,
    team_id     int DEFAULT NULL,
    primary key (tbelongt_id),
    foreign key (teacher_id) references teacher (teacher_id),
    foreign key (team_id) references team (team_id)
);
-- 学生选课表
DROP table if exists selectcourse;
create table selectcourse
(
    select_id    int auto_increment not null,
    score        int check (score <= 100),
    ususcore     int check (ususcore <= 100),
    midscore     int check (midscore <= 100),
    finalscore   int check (finalscore <= 100),
    bigworkscore int check (bigworkscore <= 100),
    student_id   int,
    success_id   int,
    primary key (select_id),
    foreign key (student_id) references student (student_id),
    foreign key (success_id) references successCourse (success_id)
);


-- 9.青年教师培养
DROP table if exists young;
create table young
(
    young_id   varchar(200) not null,
    teacher_id int,
    content    varchar(255) DEFAULT NULL,
    foreign key (teacher_id) references teacher (teacher_id),
    primary key (young_id)
);

-- 10.教学改革措施
DROP table if exists measure;
create table measure
(
    measure_id      varchar(255) not null,
    measure_title   varchar(255) DEFAULT NULL,
    measure_time    time         DEFAULT NULL,
    measure_address varchar(255) DEFAULT NULL,
    primary key (measure_id)
);


-- 12.教师改革立项
DROP table if exists approval;
create table approval
(
    approval_id      varchar(255) not null,
    approval_title   varchar(255) DEFAULT NULL,
    approval_time    time         DEFAULT NULL,
    approval_address varchar(255) DEFAULT NULL,
    primary key (approval_id)
);

-- 改革成果表
DROP TABLE IF EXISTS achievement;
CREATE TABLE achievement
(
    achievement_id      int NOT NULL auto_increment,
    achievement_title   varchar(255) DEFAULT NULL,
    achievement_time    time         DEFAULT NULL,
    achievement_address varchar(255) default NULL,
    primary key (achievement_id)
);
-- 改革奖励表
DROP TABLE IF EXISTS award;
CREATE TABLE award
(
    award_id      int NOT NULL auto_increment,
    award_title   varchar(255) DEFAULT NULL,
    award_time    time         DEFAULT NULL,
    award_address varchar(255) default NULL,
    primary key (award_id)
);
-- 资源表
DROP TABLE IF EXISTS resource;
CREATE TABLE resource
(
    resource_id         int NOT NULL auto_increment,
    success_id          int,
    resource_textbook   varchar(255) DEFAULT NULL, #课程课件
    resource_video      varchar(255) DEFAULT NULL, #教学视频
    resource_base       varchar(255) DEFAULT NULL, #习题库
    resource_experiment varchar(255) DEFAULT NULL, #案例库
    resource_document   varchar(255) DEFAULT NULL, #文档
    primary key (resource_id),
    FOREIGN KEY (success_id) REFERENCES successCourse (success_id)
);
-- 实验案例库表
DROP TABLE IF EXISTS experiment_house;
CREATE TABLE experiment_house
(
    experiment_id        int NOT NULL auto_increment, #主键
    experiment_huanj     varchar(255) DEFAULT NULL,   #实验环境
    experiment_operation varchar(255) DEFAULT NULL,   #实验安装
    experiment_xit       varchar(255) DEFAULT NULL,   #实验系统代码
    resource_id          int,
    primary key (experiment_id),
    FOREIGN KEY (resource_id) REFERENCES resource (resource_id)
);
-- 家庭作业表
DROP TABLE IF EXISTS homework;
CREATE TABLE homework
(
    homework_id int NOT NULL auto_increment,
    homework    varchar(255) DEFAULT NULL,
    student_id  int,
    success_id  int,
    primary key (homework_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id),
    FOREIGN KEY (success_id) REFERENCES successCourse (success_id)
);

-- 家庭作业案例表
DROP TABLE IF EXISTS homeworkcase;
CREATE TABLE homeworkcase
(
    homework_case_id int NOT NULL auto_increment,
    homework_id      int,
    success_id       int,
    primary key (homework_case_id),
    FOREIGN KEY (homework_id) REFERENCES homework (homework_id),
    FOREIGN KEY (success_id) REFERENCES successCourse (success_id)
);
-- 教学大纲
DROP TABLE IF EXISTS teaching_program;
CREATE TABLE teaching_program
(
    teaching_program_id      int NOT NULL auto_increment,
    teaching_program_title   varchar(255) DEFAULT NULL,
    teaching_program_content varchar(255) DEFAULT NULL,
    success_id               int,
    primary key (teaching_program_id),
    FOREIGN KEY (success_id) REFERENCES successCourse (success_id)
);
-- 日历表
DROP TABLE IF EXISTS calendar;
CREATE TABLE calendar
(
    calendar_id      int NOT NULL auto_increment,
    calendar_title   varchar(255) DEFAULT NULL,
    calendar_content varchar(255) DEFAULT NULL,
    success_id       int,
    primary key (calendar_id),
    FOREIGN KEY (success_id) REFERENCES successCourse (success_id)
);

-- 教学内容表
DROP TABLE IF EXISTS contentb;
CREATE TABLE contentb
(
    contentb_id      int NOT NULL auto_increment,
    contentb_title   varchar(255) DEFAULT NULL,
    contentb_content varchar(255) DEFAULT NULL,
    success_id       int,
    primary key (contentb_id),
    FOREIGN KEY (success_id) REFERENCES successCourse (success_id)
);
-- 教学计划表
DROP TABLE IF EXISTS planb;
CREATE TABLE planb
(
    planb_id      int NOT NULL auto_increment,
    planb_title   varchar(255) DEFAULT NULL,
    planb_content varchar(255) DEFAULT NULL,
    success_id    int,
    primary key (planb_id),
    FOREIGN KEY (success_id) REFERENCES successCourse (success_id)
);
-- 教学难点表
DROP TABLE IF EXISTS problemb;
CREATE TABLE problemb
(
    problemb_id      int NOT NULL auto_increment,
    problemb_title   varchar(255) DEFAULT NULL,
    problemb_content varchar(255) DEFAULT NULL,
    success_id       int,
    primary key (problemb_id),
    FOREIGN KEY (success_id) REFERENCES successCourse (success_id)
);
-- 教学方法表
DROP TABLE IF EXISTS methodb;
CREATE TABLE methodb
(
    methodb_id      int NOT NULL auto_increment,
    methodb_title   varchar(255) DEFAULT NULL,
    methodb_content varchar(255) DEFAULT NULL,
    success_id      int,
    primary key (methodb_id),
    FOREIGN KEY (success_id) REFERENCES successCourse (success_id)
);
-- 账号表
DROP TABLE IF EXISTS userb;
CREATE TABLE userb
(
    userb_id       int not null,
    userb_password varchar(15)  DEFAULT NULL,
    userb_type     varchar(10) check (userb_type = 'admin' or userb_type = 'second' or userb_type = 'teachaer' or
                                      userb_type = 'student'),
    userb_phone    varchar(255) DEFAULT NULL,
    userb_email    varchar(30)  DEFAULT NULL,
    student_id     int,
    teacher_id     int,
    primary key (userb_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id),
    FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id)

);
