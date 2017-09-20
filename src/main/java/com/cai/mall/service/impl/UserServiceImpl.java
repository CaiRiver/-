package com.cai.mall.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cai.mall.domain.User;
import com.cai.mall.enums.UserStatus;
import com.cai.mall.exception.MallException;
import com.cai.mall.mapper.UserMapper;
import com.cai.mall.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User regist(String username, String password, String phoneNum, 
			String email, String birthday, String sex, String confirmPassword) {
		User queryUser = userMapper.getUserByUsername(username, phoneNum, email);
		if (null != queryUser) {
			//TODO 怎么让前端弹出 校验用户是 用户名重复 还是 手机号码已经注册 还是email 被注册了呢？
			throw new MallException("该用户名已经存在");
		}
		
		User user = new User();
	
			try {
				user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MallException();
			}
			user.setCellPhone(phoneNum);
			user.setEmail(email);
			
			if (!password.equals(confirmPassword)) {
				throw new MallException("两次密码不一致");
			}
			password += username;
			password = DigestUtils.md5Hex(password);
			
			user.setPassword(password);
			
			user.setSex(sex);
			
			user.setStatus(UserStatus.ENABLE.getK());
			user.setUsername(username);
			int rows = userMapper.addUser(user);
			if (1 != rows) {
				throw new MallException("要入坑，请再来一次注册！");
			}
			
			return user;
	}

	@Override
	public User login(String username, String password, String phoneNum, String email) {
		User queryUser = userMapper.getUserByUsername(username, null, null);
		if (null == queryUser) {
			throw new MallException("米有此用户赶脚注册一个吧！");
		}
		
		if (queryUser.getStatus() != UserStatus.ENABLE.getK()) {
			throw new MallException("g该用户已经GG");
		}
		
		password += username;
		password = DigestUtils.md5Hex(password);
		if (!password.equals(queryUser.getPassword())) {
			throw new MallException("用户名、邮箱、电话号码或者密码错误");
		}
		
		return queryUser;
	}

	

}
