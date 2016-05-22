
// JavaScript Documentt
document.charset="utf-8";
function verify(){
	document.charset="utf-8";
	$.ajax({
		type:"post", //请求方式
		url:"verify.do", //发送请求地址
		data:{ //发送给数据库的数据
		uname:$("#uname").val(),
		},
	//请求成功后的回调函数有两个参数
	success:function(data,textStatus){
		var info = '用户名验证正确》_《';
		
		if(data){
			info='用户名已存在^_^';
			$("#info").html(info);
			$("#info").focus();
		}else{
			$("#info").html(info);
		}
		
	}
	});
	
}







