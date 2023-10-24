package com.Study.Project.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Study.Project.handler.MyPasswordEncoder;
import com.Study.Project.handler.RandomNumber;
import com.Study.Project.handler.SendMailClient;
import com.Study.Project.handler.coolSMSAPI;
import com.Study.Project.service.LoginService;

import net.nurigo.sdk.message.response.MultipleDetailMessageSentResponse;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@GetMapping("Login")
	public String Login(HttpSession session, Model model) {
		
		if(session.getAttribute("id") != null) {
			model.addAttribute("false", "잘못된 접근입니다.");
			return "false";
		}
		
		return "login/login";
		
	}
	
	@PostMapping("LoginPro")
	public String LoginPro(HttpSession session, Model model, String id, String passwd) {
		
		if(session.getAttribute("id") != null) {
			model.addAttribute("home", "잘못된 접근입니다.");
			return "false";
		}
		
		boolean isLogin = loginService.isLogin(id,passwd);
		
		
		
		return "main";
	}
	
	@GetMapping("Join")
	public String Join(HttpSession session, Model model) {
		
		if(session.getAttribute("id") != null) {
			model.addAttribute("home", "잘못된 접근입니다.");
			return "false";
		}
		
		return "login/join";
	}
	
	@ResponseBody
	@PostMapping("idCheck")
	public String idCheck (String id, Model model) {
		
		boolean isCheck = loginService.isIdCheck(id);
		
		System.out.println(isCheck);
		
		if(isCheck) {
			return "true";
		}
		
		return "false";
	}
	
	@ResponseBody
	@PostMapping("SendEmail")
	public String SendEmail (String email, Model model) {
		
		//1.가입되어 있는지 확인
		boolean isCheck = loginService.isEmailCheck(email);
		
		if(!isCheck) {
			return "false";
		}
		
		//2.랜덤 번호 생성
		RandomNumber randomNumber = new RandomNumber();
		int authCode = randomNumber.randomNumber(4);
		
		//3. 코드 저장 db에 이메일이 있는지 확인
		int isEmail = loginService.isEmailEmpty(email);
		
		
		if(isEmail > 0) {
			int updateCount = loginService.emailAuthCodeUpdate(email,authCode);
			if(updateCount <= 0) {
				return "false";
			}
		} else {
			int insertCount = loginService.emailAuthCode(email,authCode);
			if(insertCount <= 0) {
				return "false";
			}
		}
		
		System.out.println("if문 빠져나옴");
		
		// 4. 메일 전송
		SendMailClient mailClient = new SendMailClient();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("실행");
				mailClient.sendMail(email,"회원가입 인증번호 입니다.", authCode);
				System.out.println("완료");
			}
		}).start();
		
		return "true";
	}
	
	@ResponseBody
	@PostMapping("isEmailAuthCode")
	public String isEmailAuthCode(String authCode, String email) {
		
		boolean isEmailAuthCode = loginService.isEmailAuthCodeCheck(authCode, email);
		
		if(isEmailAuthCode) {
			
			boolean removeEmailAuthCode = loginService.removeEmailAuthCode(email);
			
			if(removeEmailAuthCode) {
				return "true";
			}
			
		}
		
		return "false";
	}
	
	@ResponseBody
	@PostMapping("sendSMS")
	public String sendSMS(String phone) {
		
		coolSMSAPI sms = new coolSMSAPI();
		
		RandomNumber randomNumber = new RandomNumber();
		
		int number = randomNumber.randomNumber(4);
		
		boolean isPhoneNumber = loginService.selectPhoneNumber(phone);
		
		if(isPhoneNumber) {
			
			boolean isUpdatePhoneNumber = loginService.updatePhoneAuthCode(number,phone);
			
			if(isUpdatePhoneNumber) {
				
				MultipleDetailMessageSentResponse response = sms.sendAuthCode(number, phone);
					
				if(response != null) { 
					
					return "true";
					
				}
			}
			
		} else {
			
			boolean isSavePhoneNumber = loginService.inputPhoneAuthCode(number,phone);
			
			if(isSavePhoneNumber) {
				
				MultipleDetailMessageSentResponse response = sms.sendAuthCode(number, phone);
					
				if(response != null) { 
					
					return "true";
					
				}
			}
		}
		
		return "false";
	}
	
	@ResponseBody
	@PostMapping("SMSAuthCode")
	public String SMSAuthCode(int authCode, String phone) {
		
		boolean isAuthCode = loginService.selectSMSAuthCode(authCode, phone);
		
		if(isAuthCode) {
			boolean deleteCount = loginService.removeSMSAuthCode(phone);
			
			if(deleteCount) {
				return "true";
			}
			
		}
		
		return "false";
	}
	
	@ResponseBody
	@PostMapping("nicknameCheck")
	public String nicknameCheck(String nickname) {
		
		boolean isCheck = loginService.isNicknameCheck(nickname);
		
		if(isCheck) {
			return "true";
		}
		
		return "false";
	}
	
	@PostMapping("joinPro")
	public String joinPro(@RequestParam Map<String, String> member, HttpSession session, Model model) {
		
		if(session.getAttribute("id") != null) {
			model.addAttribute("home", "잘못된 접근입니다.");
			
			return "false";
		}
		
		MyPasswordEncoder encoder = new MyPasswordEncoder();
		
		String passwd = encoder.getCryptoPassword(member.get("passwd"));
		
		int insertCount = loginService.addMemberJoin(member, passwd);
		
		if(insertCount <= 0) {
			
			model.addAttribute("false", "회원가입실패");
			
			return "false";
			
		}
		
		return "redirect:/";
	}
	
}
