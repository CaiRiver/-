package com.cai.mall.service;

import com.cai.mall.domain.User;

public interface UserService {
	
	User regist(String username, String password, String phoneNum, 
			String email, String birthday, String sex, String confirmPassword);
	
	User login(String username, String password, String phoneNum, String email);
}	
