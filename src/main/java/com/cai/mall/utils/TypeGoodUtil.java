package com.cai.mall.utils;

import java.util.List;

public class TypeGoodUtil<T> {
	private String name;
	private Integer id;
	private List<T> data;
	
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	
	
}
