package com.Study.Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Study.Project.mapper.LoginMapper;

@Service
public class LoginService {

	@Autowired
	LoginMapper loginMapper;
	
	public boolean isLogin(String id, String passwd) {
		
		int isLogin = loginMapper.selelctLogin(id,passwd);
		
		if(isLogin > 0) {
			return true;
		}
		
		return false;
	}

	public boolean isIdCheck(String id) {
		
		int i = loginMapper.selectCheckId(id);
		
		System.out.println(i);
		
		if(i <= 0) {
			return true;
		}
		
		return false;
	}

	public boolean isEmailCheck(String email) {
		
		int i = loginMapper.selectCheckEmail(email);
		
		System.out.println(email);
		
		if(i <= 0) {
			return true;
		}
		
		return false;
	}

}
