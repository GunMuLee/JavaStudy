$(function(){
	
			
	$("#emailAuthBtn").on("click", function(){
		
		let authCode = $("#emailAuthCode").val();
		let email = $("#email").val();
		
		if(authCode == ""){
			Swal.fire({
			  icon: 'question',
			  title: '인증번호를 입력해주세요'
			})
			
			return "";
		}
		
		$.ajax({
			type:"post"
			, url:"isEmailAuthCode"
			, data: {authCode:authcode
					,email:email}
			, dataType:"text"
			, success: function(data){
				
				if(data == "true"){
					
					$("#isEmailBtn").remove();
					
					$("#email").attr("disabled", true);
					
					$("#emailArea").after(
						"<b color='blue'>이메일 인증 완료</b>"
					);
					
				} else {
					Swal.fire({
					  icon: 'error',
					  title: '코드가 일치하지 않습니다.'
					})
				}
				
			}
			, error: function(){
				Swal.fire({
				  icon: 'error',
				  title: '실패'
				})
			}
		});
		
	});
	
});