package com.cai.mall.enums;

import com.cai.mall.exception.MallException;

public enum UserStatus {
	ENABLE(1, ""), FROZEN(2, ""), UNABLE(3, "");

	private int k;
	private String mString;

	private UserStatus(int k, String mString) {
		this.k = k;
		this.mString = mString;
	}

	public static UserStatus getEnum(int status) {
		for (UserStatus userStatus : UserStatus.values()) {
			if (status == userStatus.getK()) {
				return userStatus;
			}
		}
		
		throw new MallException("没有合适的用户状态");
	}
	
	public int getK() {
		return k;
	}

	public String getmString() {
		return mString;
	}

}
