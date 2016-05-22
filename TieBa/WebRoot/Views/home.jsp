<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
  <head>
  
    <title>主页</title>
    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="../Resource/CSS/home.css" rel="stylesheet">
	
	<script type="text/javascript">
		function shut(){
			var cf=confirm("你确定要退出系统？？   ^o_o^");
			if(cf==false){
				return false;
			}else{
				window.location.href="shutdown.do";
				return;
			}
		}
	</script>

  </head>
  
  <body>
  
  <div class="content">
  
  	<div class="top">
  		<c:choose>
  			<c:when test="${userinf.photo==null }">
  		<img id="photo" alt="头像" src="../Resource/images/photos/defaultUser.jpg">
  			</c:when>
  			<c:otherwise>
  		<img id="photo" alt="头像" src="../Resource/images/photos/${userinf.photo }">
  			</c:otherwise>
  		</c:choose>
  		<div id="head">
  		
  			<c:if test="${user.uname != null }">
  			<p id="addInf"><a href="info.do?uname=${user.uname }">编辑资料</a></p>
  			</c:if>
  			
  			<p id="nickname">${user.uname }</p>
  		</div>
  		
  		
  		<c:choose>
  		<c:when test="${user.uname == null }">
  			<div id="logAndReg">
	  			<a href="login.jsp">登录</a>
	  			<a href="register.jsp">注册</a>
  			</div>
  		</c:when>
  		<c:otherwise>
  			<a href="javascript:void(0)" title="退出系统" onclick="shut()">
  				<img alt="退出系统" src="../Resource/images/shutdown.png" title="退出系统" id="shutdown"/>
  			</a>
  		</c:otherwise>
  		</c:choose>
  		
  		<div class="search">
  			<form action="search.do" method="post" name="searchForm">
  				<img alt="搜索" src="../Resource/images/search.png" class="searchImg" />
  				
  				<select name="kind" class="searchContent">
  					<option value="搜吧">搜吧</option>
  					<option value="搜贴">搜贴</option>
  				</select>
  				
  				<input type="search" required="required" class="searchContent" name="search" placeholder="请输入要搜索的贴吧名"/>
  				<input type="submit" value="搜索" id="btnSearch" />
  			</form>
  		</div>
  		
  	</div>
  	
  	<div class="main">
  		<p id="Popular">热门动态</p>
  		
  		<c:forEach var="post" items="${posts }">
  		<div id="barMssg">
  			<hr/>
  			<img alt="贴吧图片" src="../Resource/images/barImg.jpg" id="barImg">
  			<div id="postMssg">
  				<p id="bname"><a href="bar.do?bname=${post.bname }">${post.bname }</a></p>
  				<p id="title"><a href="post.do?pid=${post.pid }">${post.title }</a></p>
  			</div>
  			<div id="msgNum">
  				<img alt="回消息图片" src="../Resource/images/msg.png" id="msg"/>
  				<label id="pnum">${post.pnum }</label>
  				<label id="sendtime">${post.sendtime }</label>
  			</div>
  		</div>
  		</c:forEach>
  		
  	</div>
  	
  </div>
  </body>
</html>
