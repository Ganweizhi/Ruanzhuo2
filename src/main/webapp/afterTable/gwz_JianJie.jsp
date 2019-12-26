<%@ page import="java.util.List" %>
<%@ page import="com.dgut.group11.gwz.javabean.gwz_Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>课程简介</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
    </head>
    
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5" action="/course/AddJianJie">
                                <div class="layui-input-inline layui-show-xs-block">
                                    <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                        <i class="layui-icon">添加课程简介</i></button>
                                </div>
                            </form>
                        </div>

                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                                <thead>
                                    <tr>
                                        <th>课程ID</th>
                                        <th>课程名</th>
                                        <th>教师ID(教师姓名)</th>
                                        <th>学院</th>
                                        <th>课程学分</th>
                                        <th>课程学时</th>
                                        <th>课程简介</th>
                                        <th>操作</th></tr>
                                </thead>
                                <%
                                    List<gwz_Course> courseList=(List<gwz_Course>)request.getSession().getAttribute("JianJie_courseList");
                                    System.out.println(courseList);
                                    for (gwz_Course course:courseList){
                                %>
                                <tbody>
                                    <tr>
                                        <td><%=course.getCourse_id()%></td>
                                        <td><%=course.getCourse_name()%></td>
                                        <td><%=course.getGwzTeacher().getTeacher_id()%>(<%=course.getGwzTeacher().getTeacher_name()%>)</td>
                                        <td><%=course.getGwzTeacher().getGwzAcademy().getAcademy_name()%></td>
                                        <td><%=course.getCourse_credit()%></td>
                                        <td><%=course.getCourse_period()%></td>
                                        <td><%=course.getCourse_introduction()%></td>
                                        <td class="td-manage">
                                            <a title="编辑" onclick="xadmin.open('编辑','/course/EditJianJie?course_id=<%=course.getCourse_id()%>')" href="javascript:;">
                                                <i class="layui-icon">&#xe63c;</i></a>
                                            <a title="删除"  href="/course/delete_JianJie?course_id=<%=course.getCourse_id()%>">
                                                <i class="layui-icon">&#xe640;</i>
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                                <%
                                    }
                                %>
                            </table>
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