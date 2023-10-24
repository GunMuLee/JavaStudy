$(function(){
	let isCheckId = 0;
	let isCheckEmail = 0;
	let isCheckPhone = 0;
	let isCheckPasswd = 0;
	let isCheckNickname = 0;
	
	$("#joinBtn").on("click", function(){
		
		event.preventDefault();
		
		let name = $("#name").val();
		let nickname = $("#nickname").val();
		
		if(name.length == 0){
			Swal.fire({
			  icon: 'question',
			  title: '이름을 작성해주세요'
			})
			
			$("#name").onfocus();
			
			return false;
		}
		
		if(nickname.length == 0){
			Swal.fire({
			  icon: 'question',
			  title: '닉네임을 작성하여주세요'
			})
			
			$("#nickname").onfocus();
			
			return false;
		}
		
		if(isCheckId != 1){
			Swal.fire({
			  icon: 'question',
			  title: '아이디 중복확인 바랍니다.'
			})
			
			$("#id").onfocus();
			
			return false;
		}
		
		if(isCheckNickname != 1){
			Swal.fire({
			  icon: 'question',
			  title: '닉네임 중복확인을 <br> 진행하여야 합니다.'
			})
			
			$("#nickname").onfocus();
			
			return false;
			
		}
		
		if($("#passwd").val().length == 0){
			Swal.fire({
			  icon: 'question',
			  title: '비밀번호를 입력해주세요.'
			})
			
			$("#passwd").onfocus();
			
			return false;
			
		}
		
		if(isCheckPasswd != 1){
			Swal.fire({
			  icon: 'question',
			  title: '비밀번호가 일치하지 않습니다.'
			})
			
			$("#passwd").onfocus();
			
			return false;
		}
		
		if(isCheckEmail != 1){
			
			Swal.fire({
			  icon: 'question',
			  title: '이메일 인증을 해야합니다.'
			})
			
			$("#email").onfocus();
			
			return false;
			
		}
		
		if(isCheckPhone != 1){
			
			Swal.fire({
			  icon: 'question',
			  title: '전화번호 인증을 해야합니다.'
			})
			
			$("#phone").onfocus();
			
			return false;
			
		}
		
		$("#nickname").attr("disabled", false);
		$("#id").attr("disabled", false);
		$("#email").attr("disabled", false);
		$("#phone").attr("disabled", false);
		
		$("#joinPro").submit();
	});
	
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
					
					isId = 1;
					
					$("#idArea").after(
						"<a id='idSuccess' style='color: blue'>아이디 인증에 성공하였습니다.</a>"
					);
					
					isCheckId = 1;
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
			    
			    isCheckPasswd = 0;
			    
			} else if (!regex.test(passwd)) {
			    $("#passwd").after(
			      "<a id='passwdSuccess' style='color: red'>특수문자, 대문자, 소문자 최소 하나씩 포함되어야 합니다.</a>"
			    );
			    isCheckPasswd = 0;
			}
		}
		
		if(isPasswd.length != 0){
			if(isPasswd != passwd){
				$("#isPasswd").after(
					"<a id='isPasswdSuccess' style='color: red'>비밀번호가 동일하지 않습니다.</a>"
				);
			    isCheckPasswd = 0;
			} else {
				$("#isPasswd").after(
					"<a id='isPasswdSuccess' style='color: green'>비밀번호가 동일합니다.</a>"
				);
			    isCheckPasswd = 1;
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
			    isCheckPasswd = 0;
			} else {
				$("#isPasswd").after(
					"<p id='isPasswdSuccess' style='color: green'>비밀번호가 동일합니다.</p>"
				);
			    isCheckPasswd = 1;
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
			,data:{email:email}
			,dataType:"text"
			,success:function(data){
				
				$("#authEmailArea").remove();
				
				if(data=="true"){
					$("#emailArea").after(
						"<div class='input-group' id='authEmailArea'>"
						+"<input type='text' class='form-control' id=emailAuthCode placeholder='인증코드를 입력해주세요'>"
						+"<input type='button' class='btn btn-primary' id='emailAuthBtn' value='인증'>"
						+"</div>"
						);
				} else if(data=="false"){
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
	
	
	
	$(document).on("click", "#emailAuthBtn", function(){
		
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
			, data: {authCode:authCode
					,email:email}
			, dataType:"text"
			, success: function(data){
				
				if(data == "true"){
					
					$("#isEmailBtn").remove();
					
					$("#authEmailArea").remove();
					
					$("#email").attr("disabled", true);
					
					$("#emailArea").after(
						"<b style='color:blue'>이메일 인증 완료</b>"
					);
					
					isCheckEmail=1;
					
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
	
	$("#phone").on("input", function() {
		  let phone = $(this).val();
		
		  // 숫자만 추출
		  phone = phone.replace(/[^0-9]/g, '');
		
		  // 글자 수 제한 (예: 13자까지)
		  if (phone.length > 11) {
		    phone = phone.slice(0, 11);
		  }
		
		  // 전화번호 형식에 맞게 하이픈 추가
		  var formattedPhone = '';
		  for (var i = 0; i < phone.length; i++) {
		    if (i === 0) {
		      formattedPhone += phone[i];
		    } else if (i === 3 || i === 7) {
		      formattedPhone += '-' + phone[i];
		    } else {
		      formattedPhone += phone[i];
		    }
		  }
		
		  $(this).val(formattedPhone);
	});

	$("#phoneBtn").on("click", function(){
		
		let phoneNumber = $("#phone").val();
		
		if(phoneNumber.length == 0){
			Swal.fire({
			  icon: 'question',
			  title: '전화번호를 입력해주세요'
			})
			
			return "";
			
		} else if(phoneNumber.length != 13) {
			Swal.fire({
			  icon: 'question',
			  title: '전화번호를 <br> 정확하게 입력해주세요',
			  text:'(핸트폰 번호만 가능합니다)'
			})
			
			return "";
		}
		
		$.ajax({
			type:"post"
			,url:"sendSMS"
			,data:{phone:phoneNumber}
			,dataType:"text"
			,success:function(data){
				
				$("#authSMSArea").remove();
				
				if(data=="true"){
					
					Swal.fire({
					  icon: 'success',
					  title: '메세지 전송 성공'
					})
										
					$("#phone").attr("disabled", true);
					
					$("#phoneArea").after(
						"<div id='authSMSArea' class='input-group'>"
						+"<input type='text' id='authSMS' class='form-control'>"
						+"<input type='button' id='isAuthSMS' class='btn btn-primary' value='인증'>"
						+"</div>"
					);
					
				} else if(data=="false"){
					Swal.fire({
					  icon: 'error',
					  title: '메세지 전송 실패'
					})
				} else {
					Swal.fire({
					  icon: 'error',
					  title: '실패'
					})
				}
				
			}
			,error:function(data){
				Swal.fire({
				  icon: 'error',
				  title: '실패'
				})
			}
		});
		
		
	});
	
	$(document).on("click", "#isAuthSMS", function(){
		
		let authCode=$("#authSMS").val();
		let phone=$("#phone").val();
		
		$.ajax({
			type:"post"
			,url:"SMSAuthCode"
			,data:{
				authCode:authCode
				, phone:phone
				}
			,dataType:"text"
			,success:function(data){
				
				if(data=="true"){

					$("#phoneBtn").remove();
					
					$("#authSMSArea").remove();
					
					$("#phoneArea").after(
						"<b style='color:blue'> 핸드폰 인증이 완료되었습니다. </b>"
					);
					
					isCheckPhone = 1;
					
				} else if(data=="false"){
					
					Swal.fire({
					  icon: 'error',
					  title: '인증 번호가 일치하지 않습니다.'
					})
					
				} else {
					
					Swal.fire({
					  icon: 'error',
					  title: '실패'
					})
					
				}
				
			}
			,error:function(){
				Swal.fire({
					  icon: 'error',
					  title: '실패'
				})
			}
		});
		
	});
	
	$("#nicknameCheck").on("click", function(){
		
		let nickname = $("#nickname").val();
		let regex = /^[가-힣]{3,}|[a-zA-Z]{6,}$/;
		
		if (!regex.test(nickname)) {
	      
	      Swal.fire({
				  icon: 'error',
				  title: '닉네임은 한글 3글자 이상 또는 영어 6글자 이상이어야 합니다.'
			})
	      
	      
	    } else if(nickname == ""){
			
			Swal.fire({
				  icon: 'question',
				  title: '닉네임을 입력해주세요'
			})
			
		} else {
			
			$.ajax({
				type:"post"
				, url:"nicknameCheck"
				, data:{nickname:nickname}
				, dataType:"text"
				, success:function(data){
					if(data == "true"){
						Swal.fire({
							  icon: 'success',
							  title: '사용가능한 닉네임입니다.'
						})
						
						$("#nickname").attr("disabled", true);
						$("#nicknameCheck").remove();
						
						isCheckNickname = 1;
					} else if(data == "false"){
						Swal.fire({
							  icon: 'error',
							  title: '이미 사용중인 <br> 닉네임입니다.'
						})
					}
				}
				, error:function(){
					Swal.fire({
							  icon: 'error',
							  title: '오류'
					})
				}
			});
			
		}
		
		
		
	});

	
});