package com.cai.mall.domain;

import java.util.Date;

public class Order备用 {
	private Integer id;
	private Integer userId;
	private Integer commodityId;
	private Integer addressId;
	private String unitPrice;
	private Integer commodityNum;
	private Integer totalPrice;
	private Integer orderStatus;
	private String orderRemark;
	private Integer orderFrom;
	private String provinceCharacter;
	private String cityCharacter;
	private String areaCharacter;
	private String detailedAddress;
	private Date createTime;
	private Date modifyTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getCommodityNum() {
		return commodityNum;
	}

	public void setCommodityNum(Integer commodityNum) {
		this.commodityNum = commodityNum;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public Integer getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(Integer orderFrom) {
		this.orderFrom = orderFrom;
	}

	public String getProvinceCharacter() {
		return provinceCharacter;
	}

	public void setProvinceCharacter(String provinceCharacter) {
		this.provinceCharacter = provinceCharacter;
	}

	public String getCityCharacter() {
		return cityCharacter;
	}

	public void setCityCharacter(String cityCharacter) {
		this.cityCharacter = cityCharacter;
	}

	public String getAreaCharacter() {
		return areaCharacter;
	}

	public void setAreaCharacter(String areaCharacter) {
		this.areaCharacter = areaCharacter;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
