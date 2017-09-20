package com.cai.mall.enums;

import com.cai.mall.exception.MallException;

public enum OrderStauts {
	WAITTOPAY(0, "待结算"), UNPAY(1, "待付款"), ALREADYPAY(2, "已付款"), OUTOFTIME(3, "失效"), CANCEL(4, "取消");

	private int k;
	private String mString;

	private OrderStauts(int k, String mString) {
		this.k = k;
		this.mString = mString;
	}
	
	public static OrderStauts getEnum(int status) {
		for (OrderStauts orderStauts : OrderStauts.values()) {
			if (orderStauts.getK() == status) {
				return orderStauts;
			}
		}
		
		throw new MallException("没有合适的订单状态");
	}
	
	public int getK() {
		return k;
	}

	public String getmString() {
		return mString;
	}

}
