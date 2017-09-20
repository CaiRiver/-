package com.cai.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.cai.mall.domain.User;
import com.cai.mall.exception.MallException;

@Controller
public class BaseController {
	
	
	protected int getUserId(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		if (null == session) {
//			throw new MallException("用户未登录");
//		}
//		Object object = session.getAttribute("login_user");
//		if (null == object) {
//			throw new MallException("用户未登录");
//		}
//		
//		User user = (User)object;
		return 9;
	}
	
}
