<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <title>登录</title>

</head>
<body>
<h2>Hello World!</h2>
<form method="post" id="loginForm">
    用户：<input type="code" name="code"/><br/>
    密码：<input type="password" name="password" autocomplete="false"/><br/>
    <input type="button" value="登录" onclick="login()"/>

</form>
</body>
<script src="js/jquery-3.4.1.min.js"></script>
<script type="application/javascript">
    function login() {
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "<%=application.getContextPath()%>/login",
            data: {code: $("input[name=code]").val(), password: $("input[name=password]").val()},
            success: function (result) {
                if (result == "success") {
                    alert(result);
                    window.location.href = '<%=application.getContextPath()%>/home?code=' + $("input[name=code]").val();
                } else {
                    alert(result);
                }
            },
            error: function () {
                alert("ajax error");
            }
        })
    }
</script>
</html>
