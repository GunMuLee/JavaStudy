$(function(){
	$("#idCheck").on("click", function(){
		
		let id = $("#id").val();
		
		if(id == ""){
			Swal.fire({
			  icon: 'question',
			  title: '아이디를 작성해주세요'
			})
			
			return "";
			
		} else if(id.length < 5 || id.length > 21) {
			Swal.fire({
			  icon: 'error',
			  title: '아이디는 5~20 사이로 <br> 작성해주세요.'
			})
			
			return "";
		}
		
		$.ajax({
			type:"post"
			, url:"idCheck"
			, data: {id:id}
			, dataType: "text"
			, success : function(data) {
				
				if(data == "true"){
					$("#idArea").after(
						"<a id='idSuccess' style='color: blue'>아이디 인증에 성공하였습니다.</a>"
					);
					$("#idCheck").remove();
					$("#id").attr("disabled", true);
				} else {
					Swal.fire({
					  icon: 'error',
					  title: '현제 사용중인 아이디 입니다.'
					})
				}
				
			}
			, error : function(){
				Swal.fire({
				  icon: 'error',
				  title: '실패'
				})
			}
		});
		
	});
	
	$("#passwd").on("keyup", function () {
	
	  let passwd = $("#passwd").val();
	  let isPasswd = $("#isPasswd").val();
	  $("#isPasswdSuccess").remove();
	  $("#passwdSuccess").remove();
	
	  let regex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[\W_]).+$/;
	  
		if(passwd.length != 0){
			if(passwd.length < 7 || passwd.length > 21){
			  $("#passwd").after(
			      "<a id='passwdSuccess' style='color: red'>8~20자 이내로 작성해 주세요</a>"
			    );
			} else if (!regex.test(passwd)) {
			    $("#passwd").after(
			      "<a id='passwdSuccess' style='color: red'>특수문자, 대문자, 소문자 최소 하나씩 포함되어야 합니다.</a>"
			    );
			}
		}
		
		if(isPasswd.length != 0){
			if(isPasswd != passwd){
				$("#isPasswd").after(
					"<a id='isPasswdSuccess' style='color: red'>비밀번호가 동일하지 않습니다.</a>"
				);
			} else {
				$("#isPasswd").after(
					"<a id='isPasswdSuccess' style='color: green'>비밀번호가 동일합니다.</a>"
				);
			}
		}
	
	});
	
	$("#isPasswd").on("keyup", function(){
		
		let passwd = $("#passwd").val();
		let isPasswd = $("#isPasswd").val();
		$("#isPasswdSuccess").remove();
		
		if(isPasswd.length != 0){
			if(isPasswd != passwd){
				$("#isPasswd").after(
					"<p id='isPasswdSuccess' style='color: red'>비밀번호가 동일하지 않습니다.</p>"
				);
			} else {
				$("#isPasswd").after(
					"<p id='isPasswdSuccess' style='color: green'>비밀번호가 동일합니다.</p>"
				);
			}
		}
		
	});
	
	$("#isEmailBtn").on("click", function(){
		let email = $("#email").val();
		
		let isEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	
		if(!isEmail.test(email)){
			Swal.fire({
			  icon: 'question',
			  title: '이메일 형식이 아닙니다.'
			})
			
			return "";
		}
		
		$.ajax({
			type:"post"
			,url:"SendEmail"
			,data:{email=email}
			,dataType:"text"
			,success:function(data){
				
				if(data="true"){
					$("#email").after(
						"<input type='text' class='form-control' id=emailAuthCode>"
						);
				} else if(data="false"){
					Swal.fire({
					  icon: 'error',
					  title: '이미 가입된 이메일 입니다.'
					})
				} else {
					
				}
				
			}
			,error:function(){
				alert("이메일 보내기 실패!");
			}
		});
	});
	
});