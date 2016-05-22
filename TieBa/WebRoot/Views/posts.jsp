<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
  <head>
  
    <title>贴子</title>
    
	<meta http-equiv="keywords" content="posts">
	<meta http-equiv="description" content="posts">
	
	<link rel="stylesheet" href="../Resource/CSS/posts.css" />
	
	<script type="text/javascript" src="../Resource/JS/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="../Resource/JS/posts.js"></script>
	
  </head>
  
  <body>
   
   <div class="content">
   	
	   	<div class="head">
	   		<img alt="贴吧图片" src="../Resource/images/timg.jpg" id="barImg" />
	   		<p id="barname"><a href="bar.do?bname=${maps.post.bname }">${maps.post.bname }</a></p>
	   		<a href="home.do">
	   			<img alt="主页图标" src="../Resource/images/home.png" title="主页" id="homeImg"/>
	   		</a>
	   	</div>
   	
	   	<div class="main">
	   	
	   		<div class="postAndContent">
	   			<p id="title">${maps.post.title }</p><hr />
	   			<div id="author">
	   				<img alt="发贴作者" src="../Resource/images/photos/${maps.post.userInf.photo }" id="a_photo"/>
	   				<p id="a_name">${maps.post.author }</p>
	   			</div>
	   			<div id="a_content">
	   				<label id="sendtime">${maps.post.sendtime }</label>
	   				<label id="ac">
	   					${maps.post.content }
	   				</label>
	   			</div>
	   		</div>
	   		
	   		<c:forEach var="replay" items="${maps.post.replay }" varStatus="num">
	   		<div class="replay">
	   			<hr>
	   			<div id="r_author">
	   				<img alt="回贴作者" src="../Resource/images/photos/${replay.userInf.photo }" id="r_photo"/>
	   				<p id="r_name">${replay.author }</p>
	   			</div>
	   		
	   			<div id="r_content">
	   			
	   				<!-- 总回复内容 -->
	   				<div id="firstReplay${num.index }">
		   				<label id="r_sendtime">${replay.sendtime }</label>
		   				<label id="r_ac">
		   					${replay.content }
		   				</label>
	   				</div>
	   				
	   				<!-- 二级回复 -->
	   				<c:forEach items="${replay.replay }" var="replaypost">
	   				<div id="secondReplay">
			   			<img alt="回复人" src="../Resource/images/photos/${replaypost.userInf.photo }" id="reImg">
	   					
	   					<label id="reName">${replaypost.author }</label>
	   					<label id="reContent">: ${replaypost.content }</label>
	   				</div>
	   				</c:forEach>
	   				
	   				<!-- 子回复 + 表情 -->
	   				<div class="secondrep">
	   				<p id="r_rep" class="r_rep${num.index}" onclick="showReplay('${num.index}')">点击回复</p>
	   				<div id="r_repn" class="r_repn${num.index}">
	   					
	   					<form action="" method="post">
	   						<input type="text" class="r_rname${num.index }" value="${userinf.uname }" hidden="true" />
	   						<input type="text" class="r_rphoto${num.index }" value="${userinf.photo }" hidden="true" />
	   						<input type="text" class="r_parent_id${num.index }" value="${replay.pid }" hidden="true" />
		   					<div id="r_repcontent" class="r_repcontent${num.index}" contenteditable="true"></div>
		   				</form>
		   				
		   				<div id="r_facebtn">
		   					<img alt="表情图片" src="../Resource/images/face/1.gif" id="r_face" onclick="showFace('${num.index}')">
		   					<a id="r_btn" href="javascript:return(0)" onclick="submitReplay('${num.index}')">发表</a>
		   				</div>
	   				</div>
	   				
	   				<!-- 表情 -->
	   				<div id="facelist1" class="facelists${num.index}">
			   			<ul>
			   				<li>
			   					<img src="../Resource/images/face/2.gif"/>
			   				</li>
			   			</ul>
		   			</div>
		   			</div>
	   			</div>
	   			
	   		</div>
	   		</c:forEach>
	   		
	   		
	   		<div id="clearfloat"></div>
	   		
	   		<div class="sendMsg">
	   			<hr>
	   			<h2>发表回复</h2>
	   			
	   			<!-- 表情 start -->
	   			<a href="javascript:return(0)">
		   				<img alt="表情" src="../Resource/images/face/1.gif" title="表情" id="face">
		   		</a>
		   		<div id="facelist">
		   			<ul>
		   				<li>
		   					<img src="../Resource/images/face/2.gif"/>
		   				</li>
		   			</ul>
		   		</div>
		   		<!-- 表情end -->
		   		
	   			<form action="sendreplay.do" method="post">
	   				<input type="text" name="parent_id" value="${ maps.post.pid}" hidden="true"/>
		   			<textarea class="sContent" name="content" hidden="true"></textarea>
		   			
		   			<div class="sendContent" contenteditable="true" id="scon"></div>
		   			<input type="submit" value="发表" id="btn_ok" />
	   			</form>
	   		</div>
	   		
	   	</div>
   	
   </div>
   
  </body>
</html>
