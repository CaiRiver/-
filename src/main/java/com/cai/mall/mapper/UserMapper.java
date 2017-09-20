package com.cai.mall.mapper;


import org.apache.ibatis.annotations.Param;

import com.cai.mall.domain.User;

public interface UserMapper {
	
	int addUser(User user);
	
	User getUserByUsername(
			@Param("username")String username, 
			@Param("phoneNum")String phoneNum,
			@Param("email")String email);
	
}
