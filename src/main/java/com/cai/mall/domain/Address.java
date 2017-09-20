package com.cai.mall.domain;

import java.util.Date;

public class Address {
	private Integer id;
	private Integer userId;
	private String provinceCode;
	private String cityCode;
	private String areaCode;
	private String detailedAddress;
	private String provinceCharacter;
	private String cityCharacter;
	private String areaCharacter;
	private String realName;
	private String cellPhone;
	private Integer status;
	private Integer isDefault;
	private Date createTime;
	private Date modifyTime;

	
	
	public String getAreaCharacter() {
		return areaCharacter;
	}

	public void setAreaCharacter(String areaCharacter) {
		this.areaCharacter = areaCharacter;
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

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
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
