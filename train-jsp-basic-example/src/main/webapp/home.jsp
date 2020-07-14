<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/13
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="cn">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://bossoft.com/userTag" prefix="ut" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<head>
    <title>主页</title>
</head>
<body>
<ut:userTag></ut:userTag>
<h2>Login Success!</h2>
<h3>在线人数：<%=session.getServletContext().getAttribute("numOnline")%></h3>
<%--    <a href="add">增加测试</a>--%>
<%--    <a href="remove">删除测试</a>--%>
<%--    <a href="update">修改测试</a>--%>
<%--    <a href="query">查询测试</a>--%>

<h2>增加</h2>
<form method="post" id="addForm">
    ID：<input type="id" name="id"/><br/>
    姓名：<input type="name" name="name"/><br/>
    账号：<input type="code" name="code"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="button" value="增加" onclick="add()"/>
</form>

<h2>删除</h2>
<form method="post" id="removeForm">
    ID：<input type="id" name="id"/><br/>
    <input type="button" value="删除" onclick="remove()"/>
</form>

<h2>修改</h2>
<form method="post" id="updateForm">
    ID：<input type="id" name="id"/><br/>
    姓名：<input type="name" name="name"/><br/>
    账号：<input type="code" name="code"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="button" value="修改" onclick="update()"/>
</form>

<h2>查询</h2>
<form method="post" id="searchForm">
    ID：<input type="id" name="id"/>
    账号：<input type="code" name="code"/>
    <input type="button" value="查询" onclick="search()"/>
</form>
<h3>结果</h3>
<table id="queryTable">
    <caption>queryTable</caption>
    <thead>
    <tr>
        <th id="thId">ID</th>
        <th id="thName">name</th>
        <th id="thCode">code</th>
        <th id="thPsswd">password</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
</body>

<script src="js/jquery-3.4.1.min.js"></script>
<script type="application/javascript">
    function add() {
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "<%=application.getContextPath()%>/add",
            data: $("#addForm").serialize(),
            success: function (result) {
                alert(result);
            },
            error: function () {
                alert("ajax error");
            }
        })
    }

    function remove() {
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "<%=application.getContextPath()%>/remove",
            data: $("#removeForm").serialize(),
            success: function (result) {
                alert(result);
            },
            error: function () {
                alert("ajax error");
            }
        })
    }

    function update() {
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "<%=application.getContextPath()%>/update",
            data: $("#updateForm").serialize(),
            success: function (result) {
                alert(result);
            },
            error: function () {
                alert("ajax error");
            }
        })
    }

    function search() {
        //alert($("#searchForm").serialize());
        $.ajax({
            type: "POST",
            url: "<%=application.getContextPath()%>/query",
            data: $("#searchForm").serialize(),
            success: function (result) {
                //刷新表格
                reloadTable(result);
            },
            error: function () {
                alert("ajax error");
            }
        })
    }

    function reloadTable(result) {
        var list = JSON.parse(result);
        var tb = document.getElementById('queryTable');
        var rowNum = tb.rows.length;
        for (i = 1; i < rowNum; i ++)
        {
            tb.deleteRow(i);
            rowNum=rowNum - 1;
            i = i - 1;
        }

        for (var x in list) {
            //获取table
            var tab = document.getElementById("queryTable");
//              创建元素
            var tr = document.createElement("tr");
            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            var td4 = document.createElement("td");
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tab.appendChild(tr);
            td1.innerHTML = list[x].id;
            td2.innerHTML = list[x].name;
            td3.innerHTML = list[x].code;
            td4.innerHTML = list[x].password;
        }
    }
</script>
</html>