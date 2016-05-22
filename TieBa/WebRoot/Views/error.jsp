<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>


<!DOCTYPE HTML>
<html>
  <head>
   
    <title>错误界面</title>
    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="../Resource/CSS/style.css" rel="stylesheet">
	<script type="text/javascript" src="../Resource/JS/jquery-2.0.3.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready(function(){
		
			$("#inf").click(function(){
				$("#errorInfo").toggle();
			});
		});
		
	</script>
	
  </head>
  
  <body>
  
  	<div class="a_result">
  		<img alt="哭泣" src="../Resource/images/error.gif" />
  		<p>对不起！这个页面没有你所需要的东西，请返回.....</p><br/>
    	<a href="javascript:history.back(-1)">返回上一步</a><br/><br/>
    	
    	<a href="javascript:return(0)">
    		<p id="inf" style="font-size: 0.6em;color:red;">点击-查看详细信息</p>
    	</a>
    	<div id="errorInfo">
    		<p><%=exception %></p>
    	</div>
    </div>
    
  </body>
</html>
