package com.cai.mall.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

public class UserVO {
	// username, password, phoneNum, email, birthday, sex, code, confirmPassword
	@NotBlank
	@Length(min=1, max=6, message="名字长度1~6")
	private String username;
	
	@NotBlank
	@Length(min=1, max=6, message="密码长度1~6")
	private String password;
	
	
	private String phoneNum;
	
	@Email(message="必须是合法的邮箱地址")
	private String email;
	
	//@Past(message="生日过去式")
	private String birthday;
	
	@NotNull
	private String sex;
	
	@NotNull
	private String code;
	
	@NotNull
	@Length(min=1, max=6, message="密码长度1~6")
	private String confirmPassword;

	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
