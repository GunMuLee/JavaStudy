package com.Study.Project.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Study.Project.handler.RandomNumber;
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

	public int emailAuthCode(String email, int authCode) {
		return loginMapper.insertEmailAuthCode(email,authCode);
	}

	public int isEmailEmpty(String email) {
		return loginMapper.selectAuthEmailCheck(email);
	}
	
	public int emailAuthCodeUpdate(String email, int authCode) {
		return loginMapper.updateEmailAuthCode(email, authCode);
	}

	public boolean isEmailAuthCodeCheck(String authCode, String email) {
		
		int isAuthCode = loginMapper.selectEmailAuthCode(authCode, email);
		
		if(isAuthCode > 0) {
			return true;
		}
		
		return false;
	}

	public boolean removeEmailAuthCode(String email) {
		
		int deleteCount = loginMapper.deleteEmailAuthCode(email);
		
		if(deleteCount > 0) {
			return true;
		}
		
		return false;
	}

	public boolean inputPhoneAuthCode(int authCode, String phone) {
		
		int insertCount = loginMapper.insertPhoneAuthCode(authCode, phone);
		
		if(insertCount > 0) {
			return true;
		}
		
		return false;
	}

	public boolean selectPhoneNumber(String phone) {
		
		int selectCount = loginMapper.selectPhoneNumber(phone);
		
		if(selectCount > 0) {
			return true;
		}
		
		return false;
	}

	public boolean updatePhoneAuthCode(int authCode, String phone) {
		

		int updateCount = loginMapper.updatePhoneAuthCode(authCode, phone);
		
		if(updateCount > 0) {
			return true;
		}
		
		return false;
	}

	public boolean selectSMSAuthCode(int authCode, String phone) {
		
		int selectCount = loginMapper.selectAuthSMSCheck(authCode, phone);
		
		if(selectCount > 0) {
			return true;
		}
		
		return false;
	}

	public boolean removeSMSAuthCode(String phone) {
		
		int deleteCount = loginMapper.deleteSMSAuthCode(phone);
		
		if(deleteCount > 0) {
			return true;
		}
		
		return false;
	}

	public boolean isNicknameCheck(String nickname) {
		
		int selectCount = loginMapper.selectNickname(nickname);
		
		if(selectCount > 0) {
			return false;
		}
		
		return true;
	}

	public int addMemberJoin(Map<String, String> member, String passwd) {
		
		return loginMapper.insertJoinMember(member, passwd);
		
	}

}
