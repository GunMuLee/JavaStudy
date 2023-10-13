package com.Study.Project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
	
	//로그인시 확인
	int selelctLogin(@Param("id") String id, @Param("passwd") String passwd);
	
	//id 중복확인
	int selectCheckId(String id);
	
	//email 중복확인
	int selectCheckEmail(String email);
	
}
