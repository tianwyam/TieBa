<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>搜索贴吧的结果</title>

	<meta http-equiv="keywords" content="search,postbars">
	<meta http-equiv="description" content="search result">
	
	<link rel="stylesheet" href="../Resource/CSS/search.css">

  </head>
  
  <body>
  
  	<div class="content">
  		<div class="head">
  		
  			<div class="search">
	  			<form action="search.do" method="post" name="searchForm">
	  				<img alt="搜索" src="../Resource/images/search.png" class="searchImg" />
	  				
	  				<select name="kind" class="searchContent1">
	  					<option value="搜吧">搜吧</option>
	  					<option value="搜贴">搜贴</option>
	  				</select>
	  				
	  				<input type="search" required="required" class="searchContent2" name="search" placeholder="请输入要搜索的贴吧名"/>
	  				<input type="submit" value="搜索" id="btnSearch" />
	  			</form>
  			</div>
  			
  		</div>
  		
  		<div class="main">
  		
	  		<p id="Popular">搜索结果</p>
	  		
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
