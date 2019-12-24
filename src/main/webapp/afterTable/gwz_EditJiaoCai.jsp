<%@ page import="com.dgut.group11.gwz.service.gwz_KeChengGaiKuangService" %>
<%@ page import="com.dgut.group11.gwz.javabean.gwz_Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>编辑教材</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]--></head>
    
    <body>
    <%
        gwz_Course course=(gwz_Course) request.getSession().getAttribute("EditJiaoCai_course");
    %>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" action="/course/accept_EditJiaoCai">

                    <div class="layui-form-item">
                        <label for="course_id" class="layui-form-label">
                            <span class="x-red">*</span>课程ID</label>
                        <div class="layui-input-inline">
                            <input type="text" id="course_id" name="course_id" value="<%=course.getCourse_id()%>" required="" autocomplete="off" class="layui-input" readonly="readonly"></div>
                    </div>



                    <div class="layui-form-item">
                        <label for="course_name" class="layui-form-label">
                            <span class="x-red">*</span>课程名字</label>
                        <div class="layui-input-inline">
                            <input type="text" id="course_name" name="course_name" value="<%=course.getCourse_name()%>" required="" autocomplete="off" class="layui-input"></div>
                    </div>


        <div class="layui-form-item layui-form-text">
            <label for="course_material" class="layui-form-label">教材资料</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" value="<%=course.getCourse_material()%>" id="course_material" name="course_material" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"></label>
            <button class="layui-btn" lay-filter="add" lay-submit="" id="L_repass">编辑</button></div>
        </form>
        </div>
        </div>
        <script>layui.use(['form', 'layer'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;



                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    layer.alert("增加成功", {
                        icon: 6
                    },
                    function() {
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                    });
                });

            });</script>
        <script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
    </body>

</html>