<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>我的贴子</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="../Resource/CSS/myposts.css">
	
  </head>
  
  <body>
    
    	<div class="content">
    		<div class="head">
    			<img alt="头像" src="../Resource/images/photos/${userinf.photo }" class="photo" />
    			<p class="uname">${user.uname }</p>
    			<p class="mypost">我的贴子</p>
    			<p class="home">
		  			<a href="home.do" title="主页">
		  				<img alt="主页" title="主页" src="../Resource/images/home.png" id="homeImg" />
		  			</a>
	  			</p>
	  			<p class="back">
		  			<a href="javascript:history.back(-1)" title="返回">
		  				<img alt="返回" title="返回" src="../Resource/images/back.png" id="backImg" />
		  			</a>
	  			</p>
    			
    		</div>
    		
    		<div class="main">
    			<p id="Popular">贴子。。。</p>
  		
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
