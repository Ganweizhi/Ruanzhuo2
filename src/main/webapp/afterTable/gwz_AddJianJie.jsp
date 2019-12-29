<%@ page import="java.util.List" %>
<%@ page import="com.dgut.group11.gwz.javabean.gwz_teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>添加课程简介</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
    </head>
    
    <body>
    <%
        List<gwz_teacher> teacherList=(List<gwz_teacher>) request.getSession().getAttribute("AddJianJie_teacherList");
    %>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5" action="/course/JianJie">
                                <div class="layui-input-inline layui-show-xs-block">
                                    <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                        <i class="layui-icon">返回</i></button>
                                </div>
                            </form>
                        </div>

                        <div class="layui-fluid">
                            <div class="layui-row">
                                <form class="layui-form" action="/course/accept_AddJianJie">

                                    <div class="layui-form-item">
                                        <label for="course_name" class="layui-form-label">
                                            <span class="x-red">*</span>课程名字</label>
                                        <div class="layui-input-inline">
                                            <input type="text" id="course_name" name="course_name" required="" autocomplete="off" class="layui-input"></div>
                                    </div>

                                    <div class="layui-form-item">
                                        <label class="layui-form-label">
                                            <span class="x-red">*</span>负责教师</label>
                                        <div class="layui-input-inline layui-show-xs-block">
                                            <select name="teacher_id">
                                                <%for ( gwz_teacher teacher:teacherList){%>
                                                <option value="<%=teacher.getTeacher_id()%>"><%=teacher.getTeacher_name()%>(<%=teacher.getGwzAcademy().getAcademy_name()%>)</option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="layui-form-item">
                                        <label for="course_credit" class="layui-form-label">
                                            <span class="x-red">*</span>课程学分</label>
                                        <div class="layui-input-inline">
                                            <input type="number" id="course_credit" name="course_credit" required="" autocomplete="off" class="layui-input"></div>
                                    </div>

                                    <div class="layui-form-item">
                                        <label for="course_period" class="layui-form-label">
                                            <span class="x-red">*</span>课程时长</label>
                                        <div class="layui-input-inline">
                                            <input type="number" id="course_period" name="course_period" required="" autocomplete="off" class="layui-input"></div>
                                    </div>



                                    <div class="layui-form-item layui-form-text">
                                        <label for="course_introduction" class="layui-form-label">课程简介</label>
                                        <div class="layui-input-block">
                                            <textarea placeholder="请输入内容" id="course_introduction" name="course_introduction" class="layui-textarea"></textarea>
                                        </div>
                                    </div>

                                    <div class="layui-form-item">
                                        <label for="L_repass" class="layui-form-label"></label>
                                        <button class="layui-btn" lay-filter="add" lay-submit="" id="L_repass">添加</button></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>layui.use(['laydate', 'form'],
        function() {
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#start' //指定元素
            });

            //执行一个laydate实例
            laydate.render({
                elem: '#end' //指定元素
            });
        });




    </script>

</html>