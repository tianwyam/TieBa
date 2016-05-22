<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>我关注的贴吧</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="../Resource/CSS/mypostbars.css">

  </head>
  
  <body>
    
    	<div class="content">
    		<div class="head">
    			<img alt="头像" src="../Resource/images/photos/${userinf.photo }" class="photo" />
    			<p class="uname">${user.uname }</p>
    			<p class="mypost">我关注的贴吧</p>
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
    			<p id="Popular">贴吧。。。</p>
  			
	  		<c:forEach var="postbar" items="${postbars }">
	  		
	  			<div class="bar">
	  				<div class="barImg">
	  					<img id="img" alt="贴吧" src="../Resource/images/bar.jpg">
	  				</div>
	  				<div class="barname">
	  					<a href="bar.do?bname=${postbar.bname }">${postbar.bname }</a>
	  				</div>
	  				<div class="barbreif">${postbar.breif }</div>
	  			</div>
	  			<div class="clearfloat"></div>
	  			<hr/>
	  		</c:forEach>
  		
    		</div>
    	</div>
    
  </body>
</html>
