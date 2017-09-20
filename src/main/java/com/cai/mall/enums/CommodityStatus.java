package com.cai.mall.enums;

import com.cai.mall.exception.MallException;

public enum CommodityStatus {
	PUTAWAY(1, "上架"), SOLDOUT(2, "下架");

	private int k;
	private String mString;
	
	public static CommodityStatus getEnum(int status) {
		for (CommodityStatus cs : CommodityStatus.values()) {
			if (status == cs.getK()) {
				return cs;
			}
		}
		
		throw new MallException("没有合适的商品状态");
	}
	
	private CommodityStatus(int k, String mString) {
		this.k = k;
		this.mString = mString;
	}

	public int getK() {
		return k;
	}

	public String getmString() {
		return mString;
	}

}
