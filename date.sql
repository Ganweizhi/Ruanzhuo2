insert into course(course_name, course_introduction, course_feature, course_material, course_history, course_principal, course_credit, course_period )
values ('大物1','很难很难的物理','毫无特色','同济大学出版社书籍之物理','已开课5年','2','3.0','18');
insert into course(course_name, course_introduction, course_feature, course_material, course_history, course_principal, course_credit, course_period )
values ('数学1','很难很难的物理','毫无特色','同济大学出版社书籍之物理','已开课5年','2','3.0','18');
insert into teacher(teacher_name, academy_id, teacher_birth, teacher_sex, teacher_rank, teacher_phone, teacher_email, teacher_qualification, teacher_domain, teacher_job, teacher_address, teacher_resdire, teacher_resume, teacher_photo)
 values('李老师','1','1998-08-27','男','教授','123456','9866@qq.com','一级','domain','job','东莞松山湖','resdire','resume','photo');
insert into successCourse(course_id, teacher_id, time, success_wechat, success_QQ, success_port) values('1','2','2019-10-11','/QQ/images/1.jpg','/wechat/images/1.jpg','1port');
insert into successCourse(course_id, teacher_id, time) values('1','2','2019-10-11');