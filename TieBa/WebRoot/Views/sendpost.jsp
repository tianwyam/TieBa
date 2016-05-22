<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
  
    <title>发送贴子</title>
    
	<meta http-equiv="keywords" content="send,posts,postbars">
	<meta http-equiv="description" content="sendpost">

	<link rel="stylesheet" href="../Resource/CSS/sendPost.css" />
	
  </head>
  
  <body>
   
   		<div class="content">
   			
   			<div class="top">
   				<h1>发表新贴</h1>
   			</div>
   			<div class="sendMsg">
   				<form action="sendpost.do" method="post">
   					<p>
   						<label>标题：</label>
	   					<input type="text" name="title" id="title" />
	   					<input type="text" name="bname" id="bname" value="${param.bname }" hidden="true" />
   					</p>
   					<div>
   						<label>内容：</label><br><br>
   						<textarea id="content" name="content"></textarea>
   					</div>
   					<input type="submit" value="保存" id="btn_ok" />
   					<a href="javascript:history.back(-1);" id="btn_cancel">取消</a>
   				</form>
   			</div>
   			
   		</div>
   
  </body>
</html>
