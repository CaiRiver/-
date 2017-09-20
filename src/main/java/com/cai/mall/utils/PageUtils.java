package com.cai.mall.utils;

import java.util.List;
import java.util.Map;

public class PageUtils<T> {
	
	public static final int PER_PAGE_NUM = 2;
	
	private int totalPageNum;
	private int currentPageNum;
	private List<Map<String, Object>> data;
	
	
	public PageUtils () {
		
	}
	
	public PageUtils (int currentPageNum, int totalDataNum) {
		this.currentPageNum = currentPageNum;
		this.totalPageNum = getTotalPageNum(totalDataNum);
	}
	
	private int getTotalPageNum(int totalDataNum) {
		return totalDataNum % PER_PAGE_NUM == 0 ? (totalDataNum / PER_PAGE_NUM) : (totalDataNum / PER_PAGE_NUM + 1);
	}
	
	public int getOffset() {
		return (currentPageNum - 1) * PER_PAGE_NUM;
	}
	
	
	
	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	
	
}
