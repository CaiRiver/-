package com.cai.mall.vo;

import javax.validation.constraints.NotBlank;

public class LoginVO {
	
	@NotBlank(message="用户名不能为空")
	private String username;
	
	@NotBlank(message="密码不能为空")
	private String password;
	
	@NotBlank(message="验证码不能为空")
	private String code;
	
	private String phoneNum;
	
	
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
