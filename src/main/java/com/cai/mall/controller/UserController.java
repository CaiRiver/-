package com.cai.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cai.mall.domain.User;
import com.cai.mall.dto.AjaxResultDTO;
import com.cai.mall.exception.MallException;
import com.cai.mall.handler.RegistEmailHandler;
import com.cai.mall.service.UserService;
import com.cai.mall.vo.UserVO;
import com.cai.mall.vo.LoginVO;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RegistEmailHandler registEmailHandler;
	
	@RequestMapping("/toRegist")
	public String toRegist() {
		return "regist";
	}
	
	private Logger Logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/regist")
	@ResponseBody
	public AjaxResultDTO regist(@Validated UserVO userVO, HttpSession session, BindingResult bindingResult) {
		Logger.info("regist");
		
		if (bindingResult.hasErrors()) {
			String mString = "";
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError fError :errors) {
				mString += fError.getDefaultMessage() + ",";
			}
			return AjaxResultDTO.failed(mString);
		}
		
		String code = null;
		try {
			code = (String)session.getAttribute("code"); 
			if (!code.equals(userVO.getCode())) {
				throw new MallException("验证码不正确");
			}
						
			User user = userService.regist(userVO.getUsername(), userVO.getPassword(), userVO.getPhoneNum(), userVO.getEmail(), userVO.getBirthday(), userVO.getSex(), userVO.getConfirmPassword());
			registEmailHandler.submit(user);
		} catch (MallException me) {
			return AjaxResultDTO.failed(me.getMessage());
		} finally {
			session.removeAttribute("code");
			try {
				registEmailHandler.sendEmail();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return AjaxResultDTO.success();
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		Logger.info("toLogin");
		return "login";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public AjaxResultDTO login(@Validated LoginVO loginVO, HttpSession session, BindingResult bindingResult) {
		Logger.info("login");
		
		if (bindingResult.hasErrors()) {
			String mString = "";
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError fError :errors) {
				mString += fError.getDefaultMessage() + ",";
			}
			return AjaxResultDTO.failed(mString);
		}
		
		String code = null;
		try {
			code = (String)session.getAttribute("code");
			if (!code.equals(loginVO.getCode())) {
				throw new MallException("验证码不正确");
			}
			User user = userService.login(loginVO.getUsername(), loginVO.getPassword(), loginVO.getPhoneNum(), loginVO.getEmail());
			session.setAttribute("login_user", user);
			return AjaxResultDTO.success();
		} catch (MallException me) {
			return AjaxResultDTO.failed(me.getMessage());
		} finally {
			session.removeAttribute("code");
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	
}
