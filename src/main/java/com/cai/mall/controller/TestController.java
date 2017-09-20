package com.cai.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cai.mall.domain.User;


@Controller
@RequestMapping("/test")
public class TestController {
	
	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@ModelAttribute
	public void userModel3(String username, String password, ModelAndView mv) {
		logger.info("userModel3");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			mv.addObject("user", user);
	}
	
	@RequestMapping("/login3")
	public ModelAndView login3(ModelAndView mv) {
		logger.info("login3");
		User user = (User)mv.getModel().get("user");
		System.out.println(user);
		user.setEmail("测试");
		mv.setViewName("test");
		return mv;
	}
	
}
