package com.cai.mall.domain;

import java.util.Date;

public class Order {
	private Integer id;
	private Integer userId;
	private Integer status;
	private Integer orderFrom;
	private String amount;
	private Date createTime;
	private Date modifyTime;
	private Integer payChannel;
	private String cellPhone;
	private String realName;
	private String provinceCharacter;
	private String cityCharacter;
	private String areaCharacter;
	private String detailAddress;

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Integer getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(Integer payChannel) {
		this.payChannel = payChannel;
	}

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(Integer orderFrom) {
		this.orderFrom = orderFrom;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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
