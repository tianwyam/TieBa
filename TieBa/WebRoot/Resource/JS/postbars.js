
function attention(){

	window.location.href="attention.do?bname="+$("#barname").html();
	
}


function subattention(){

	window.location.href="subattention.do?bname="+$("#barname").html();
	
}


// 申请为吧主
function apply(){
	
	var content = prompt("申请成为吧主\n\n申请理由","");
	
	if(content){
		
		$.ajax({
			
			type:"post",
			url:"apply.do",
			data:{
				bname:$("#barname").html(),
				reason:content
			},
			success:function(data,textStatus){
				if(data){
					alert("提交成功");
					return true;
				}
			}
		});
		
	}
	
	alert("提交失败");
	return false;
}

