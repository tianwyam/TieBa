<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>贴吧</title>
    
	<meta http-equiv="keywords" content="postbars,posts">
	<meta http-equiv="description" content="postbars">

	<link rel="stylesheet" href="../Resource/CSS/postBars.css" />
	
	<script type="text/javascript" src="../Resource/JS/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="../Resource/JS/postbars.js"></script>

  </head>
  
  <body>
  	
  	<div class="content">
  		<div class="head">
  			<img id="barphoto" alt="头像" src="../Resource/images/barImg.jpg">
	  		<p id="barname">${maps.bar.bname }</p>
	  		
	  		<c:choose>
		  		<c:when test="${maps.isExist}">
		  			<p id="subattention" onclick="subattention()">&radic;已关注 | 取消</p>
		  		</c:when>
		  		<c:otherwise>
		  			<p id="addattention" onclick="attention()">+关注</p>
		  		</c:otherwise>
	  		</c:choose>
	  		
	  		<div id="sendPost">
	  			<p>
		  			<a href="home.do" title="主页">
		  				<img alt="主页" src="../Resource/images/home.png" id="homeImg" />
		  			</a>
	  			</p>
	  			<p>
		  			<a href="sendpost.do?bname=${maps.bar.bname }" title="发贴">
		  				<img alt="发贴" src="../Resource/images/send.png" id="sendImg" />
		  			</a>
	  			</p>
	  		</div>
  		</div>
  		
  		<div class="main">
  			<p id="Popular">贴子</p>
  			
  			<c:forEach var="post" items="${maps.postsList }">
	  		<div id="postsMssg">
	  			<hr/>
	  			<img alt="回消息图片" src="../Resource/images/msg.png" id="msg"/>
	  			<label id="pnum">${post.pnum }</label>
	  			<span id="title"><a href="post.do?pid=${post.pid }">${post.title }</a></span>
	  			<label id="sendtime">${post.sendtime }</label>
	  		</div>
	  		</c:forEach>
	  		
  		</div>
	
  	</div>
  	
  </body>
</html>
