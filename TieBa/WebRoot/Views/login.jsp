<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link href="../Resource/CSS/style.css" rel="stylesheet">
</head>
<body>
<div class="main">
    <h1>用户登录</h1>
    <form action="login.do" method="post">
        <fieldset>
            
            <div class="fields">
            	<label id="info">${info }</label>
                <p class="row">
                    <label>用户名</label>
                    <input type="text" name="uname" id="uname" required/>
                </p>
                <p class="row">
                    <label>密  &nbsp;码</label>
                    <input type="password" name="password" id="password" required/>
                </p>
            </div>
        </fieldset>

        <input type="submit" value="登录--用户" class="btn" />
        <a href="register.jsp" class="btn_register">注册</a>
    </form>
</div>
</body>
</html>