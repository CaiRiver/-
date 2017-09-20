package com.cai.mall.enums;

import com.cai.mall.exception.MallException;

public enum CartStatus {
	NORMAL(1, "正常"), NOGOODS(2, "没货"), OFFSHELVES(3, "商品下架");
	
	private int k;
	private String mString;
	
	private CartStatus(int k, String mString) {
		this.k = k;
		this.mString = mString;
	}
	
	public static CartStatus getEnum(int status) {
		for (CartStatus cartStatus :CartStatus.values()) {
			if (status == cartStatus.getK()) {
				return cartStatus;
			}
		}
		
		throw new MallException("没有合适的购物车商品状态");
		
	}
	
	public int getK() {
		return k;
	}
	public String getmString() {
		return mString;
	}
	
	
}
