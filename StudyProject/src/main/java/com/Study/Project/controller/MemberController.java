package com.Study.Project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("ChatGPT")
	public String ChatGPT(HttpSession session, Model model){
		
		return "chatGPT/chatGPT";
		
	}
	
	@GetMapping("Chat")
	public String chat(HttpSession session, Model model) {
		if(session.getAttribute("nickName") == null) {
			model.addAttribute("false", "로그인은 필수 입니다.");
			return "false";
		}
		
		return "sockjs/sockjs";
		
	}
	
}
