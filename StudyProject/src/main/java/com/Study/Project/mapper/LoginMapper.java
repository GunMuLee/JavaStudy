package com.Study.Project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.Study.Project.handler.RandomNumber;

@Mapper
public interface LoginMapper {
	
	//로그인시 확인
	int selelctLogin(@Param("id") String id, @Param("passwd") String passwd);
	
	//id 중복확인
	int selectCheckId(String id);
	
	//email 중복확인
	int selectCheckEmail(String email);
	
	//email 인증코드 저장
	int insertEmailAuthCode(@Param("email") String email, @Param("authCode") int authCode);
	
	//인증코드 db에 email 중복확인
	int selectAuthEmailCheck(String email);
	
	//email 인증코드가 db에 저장되어 있을때 update로 변경
	int updateEmailAuthCode(@Param("email") String email, @Param("authCode") int authCode);
	
	//email 인증코드가 일치한지 확인
	int selectEmailAuthCode(@Param("authCode") String authCode,@Param("email") String email);
	
	//email 인증성공시 db에서 데이터 제거
	int deleteEmailAuthCode(String email);
	
}
