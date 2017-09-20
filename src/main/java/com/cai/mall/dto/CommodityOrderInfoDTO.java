package com.cai.mall.dto;

import java.util.List;

public class CommodityOrderInfoDTO {
	private String totalAmount;
	private String freight;
	private String preferentialAmount;
	private List<CommodityInfo> commodities;

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getPreferentialAmount() {
		return preferentialAmount;
	}

	public void setPreferentialAmount(String preferentialAmount) {
		this.preferentialAmount = preferentialAmount;
	}

	public List<CommodityInfo> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<CommodityInfo> commodities) {
		this.commodities = commodities;
	}

	public static class CommodityInfo {
		private String commodityName;
		private int purchaseNum;
		private String amount;

		public String getCommodityName() {
			return commodityName;
		}

		public void setCommodityName(String commodityName) {
			this.commodityName = commodityName;
		}

		public int getPurchaseNum() {
			return purchaseNum;
		}

		public void setPurchaseNum(int purchaseNum) {
			this.purchaseNum = purchaseNum;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

	}
}
