<%@ page import="com.dgut.group11.gwz.javabean.gwz_Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>历史沿革</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
    </head>
    
    <body>
        <div class="x-nav">
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
                <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
            </a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">

                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                                <thead>
                                    <tr>
                                        <th>课程ID</th>
                                        <th>课程名字</th>
                                        <th>历史沿革</th>
                                        <th>操作</th></tr>
                                </thead>
                                <%
                                    List<gwz_Course> courseList=(List<gwz_Course>)request.getSession().getAttribute("LiShi_courseList");
                                    System.out.println(courseList);
                                    for (gwz_Course course:courseList){
                                %>
                                <tbody>
                                    <tr>
                                        <td><%=course.getCourse_id()%></td>
                                        <td><%=course.getCourse_name()%></td>
                                        <td><%=course.getCourse_history()%></td>
                                        <td class="td-manage">
                                            <a title="查看" onclick="xadmin.open('编辑','/course/EditLiShi?course_id=<%=course.getCourse_id()%>')" href="javascript:;">
                                                <i class="layui-icon">&#xe63c;</i></a>
                                            <a title="删除" href="/course/delete_LiShi?course_id=<%=course.getCourse_id()%>">
                                                <i class="layui-icon">&#xe640;</i></a>
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






        function delAll(argument) {

            var data = tableCheck.getData();

            layer.confirm('确认要删除吗？' + data,
            function(index) {
                //捉到所有被选中的，发异步进行删除
                layer.msg('删除成功', {
                    icon: 1
                });
                $(".layui-form-checked").not('.header').parents('tr').remove();
            });
        }</script>

</html>