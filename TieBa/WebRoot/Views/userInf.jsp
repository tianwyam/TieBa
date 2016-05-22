<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
  <head>
   
    <title>设置个人信息</title>
    
	<meta http-equiv="keywords" content="user,information,setting">
	<meta http-equiv="description" content="setting user information">
	
	<link href="../Resource/CSS/userinf.css" rel="stylesheet">
	
	<script type="text/javascript" src="../Resource/JS/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="../Resource/JS/userInf.js"></script>

  </head>
  
  <body>
   
   <div class="content">
   		
   		<div class="nav">
   			<h4>个人信息</h4><hr/>
   			<div id="n_userinfo">
   			
   			<c:choose>
   				<c:when test="${inf.photo!=null }">
   					<img alt="用户头像" src="../Resource/images/photos/${inf.photo }" id="n_photo">
   				</c:when>
   				<c:otherwise>
   					<img alt="默认头像" src="../Resource/images/defaultUser.jpg" id="n_photo">
   				</c:otherwise>
   			</c:choose>
   			
   				<div id="n_info">
   					<ul>
   						<li id="uname">${inf.uname }</li>
   						<li id="age">${inf.age }</li>
   						<li id="sex">${inf.sex }</li>
   					</ul>
   				</div>
   			</div>
   			<div class="aside">
   				<hr>
   				<p><a href="home.do">首页</a></p>
   				<p><a href="myposts.do">我的贴子</a></p>
   				<p><a href="mypostbars.do">我的贴吧</a></p>
   				<p>
   					<a href="javascript:return(0)" title="请点击-填写信息">
   						<img alt="填写信息" src="../Resource/images/pen.png" id="pen" />
   					</a>
   				</p>
   			</div>
   		</div>
   		
   		<div class="body">
   			<div class="b_form">
   				<form action="saveinf.do" method="post" enctype="multipart/form-data">
   					<p class="b_row">
   						<label>年龄：</label>
   						<input type="text" name="age" value="${inf.age }" />
   						<input type="text" name="uname" value="${inf.uname }" hidden="true" />
   					</p>
   					<p class="b_row">
   						<label>性别：</label>
   						<input type="radio" name="sex" value="男" checked="checked"/>
   						<label>男</label>
   						<input type="radio" name="sex" value="女"/>
   						<label>女</label>
   					</p>
   					<p class="b_row">
   						<label>头像：</label>
   						<input type="file" name="photofile" />
   					</p>
   					<p class="b_row">
   						<input type="submit" id="b_submit" value="保存" />
   						<a href="home.jsp" id="b_cancel">取消</a>
   					</p>
   				</form>
   			</div>
   		</div>
   		
   </div>
   
  </body>
</html>
