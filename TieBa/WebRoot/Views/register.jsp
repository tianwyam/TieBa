<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>用户注册</title>
    <link href="../Resource/CSS/style.css" rel="stylesheet">
    <script type="text/javascript" src="../Resource/JS/jquery-2.0.3.js"></script>
    <script type="text/javascript" src="../Resource/JS/checkData.js"></script>
</head>
<body>
    <div class="main">
        <h1>普通用户注册</h1>
        <form action="save.do" method="post">
            <fieldset>
                <h2>用户基本信息</h2>
                <div class="fields">
                	 <label id="info"></label>
                    <div class="row">
                        <label>用户名</label>
                        <input type="text" name="uname" id="uname" onblur="verify()" required/>
                    </div>
                    <div class="row">
                        <label>密码</label>
                        <input type="password" name="password" required/>
                    </div>
                </div>
            </fieldset>

            <input type="submit" value="添加--用户" class="btn" />
            <a href="login.jsp" class="btn_register">返回</a>
        </form>
    </div>
</body>
</html>