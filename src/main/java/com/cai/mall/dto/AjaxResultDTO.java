package com.cai.mall.dto;

public class AjaxResultDTO {

	private boolean success;
	private Object data;
	private String message;

	public AjaxResultDTO() {

	}
	
	public AjaxResultDTO(boolean success, Object data, String message) {
		this.success = success;
		this.data = data;
		this.message = message;
	}

	public static AjaxResultDTO success(Object data) {
		return new AjaxResultDTO(true, data, null);
	}
	
	public static AjaxResultDTO success() {
		return new AjaxResultDTO(true, null, null);
	}
	
	public static AjaxResultDTO failed(String message) {
		return new AjaxResultDTO(false, null, message);
	}
	
	public boolean isSuccess() {
		return success;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
