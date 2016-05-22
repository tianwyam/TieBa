

// 文档加载时
$(document).ready(function(){
	
	var li = $("#facelist").find("ul").find("li");
	var li1 = $("#facelist1 ul li ");
	
	for(var i = 3;i<30;i++){
		var lis = "<li><img src='../Resource/images/face/"+i+".gif'/></li>";
		li.after(lis);
		li1.after(lis);
	}
	
	$("#face").click(function(){
		$("#facelist").toggle(1000);
	});
	
	$("#facelist ul li").click(function(){
		var face = $(this).find("img").clone();
		$("#scon").append(face);
	});
	
	$("#btn_ok").click(function(){
		var content = $("#scon").html();
		
		if(content == null){
			$("#scon").focus();
			return;
		}
		
		$(".sContent").text(content);
	});
	
	
});



function showReplay(index){
	$(".r_repn"+index).toggle(1000);
	
	var disp =$(".r_repn"+index).css("display");
	
	if(disp == "block"){
		$(".r_rep"+index).html("收起回复");
		return;
	}
	if(disp == "none"){
		$(".r_rep"+index).html("点击回复");
		return;
	}
}


function showFace(index){
	$(".facelists"+index).toggle(1000);
	
	$(".facelists"+index+" ul li").click(function(){
		var face = $(this).find("img").clone();
		$(".r_repcontent"+index).append(face);
		return;
	});
	
	return;
}


function submitReplay(index){
	$(".facelists"+index).hide();
	
	$.ajax({
		type:"post", //请求方式
		url:"secondreplay.do", //发送请求地址
		data:{ //发送给数据库的数据
			author:$(".r_rname"+index).val(),
			parent_id:$(".r_parent_id"+index).val(),
			content:$(".r_repcontent"+index).html(),
		},
	//请求成功后的回调函数有两个参数
	success:function(data,textStatus){
		
		if(data){
			var name=$(".r_rname"+index).val();
			var photo=$(".r_rphoto"+index).val();
			var content=$(".r_repcontent"+index).html();
			
			var rcontent = "<div id='secondReplay'>" +
					"<img alt='回复人' src='../Resource/images/photos/" +photo+"' id='reImg'>" +
					"<label id='reName'>" +name+"</label>" +
					"<label id='reContent'>: " +content+"</label>" +
					"</div>";
			
			$("#firstReplay"+index).after(rcontent);
		}else{
			$(".r_repcontent"+index).html("");
			$(".r_repcontent"+index).focus();
		}
		
	}
	});
}





