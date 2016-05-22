
function attention(){
	
//	$.ajax({
//		type:"get",
//		url:"attention.do",
//		data:{
//			bname:$("#barname").html()
//		},
//		success:function(data){
//			if(data){
//				$("#addattention").css("display","none");
//				$("#subattention").css("display","inline-block");
//				return;
//			}
//		}
//	});
	
	window.location.href="attention.do?bname="+$("#barname").html();
	
}