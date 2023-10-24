$(function(){
	
	$("form").submit(function(){
		
		let id = $("#id").val();
		let passwd = $("#passwd").val();
		
		$.ajax({
			type:"Post"
			, url:"loginCheck"
			, data:{
				id:id
				,passwd:passwd
			}
			, dataTyape:"text"
			, success: function(data){
				if(data == "true"){
					
				} else {
					Swal.fire({
					  icon: 'error',
					  title: '로그인 실패'
					})
					
					return false;
				}
			}
			, error:function(){
				Swal.fire({
				  icon: 'error',
				  title: '오류'
				})
			}
		})
		
	});	
	
});