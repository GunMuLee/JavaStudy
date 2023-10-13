package com.Study.Project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Study.Project.service.LoginService;

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
	
}
