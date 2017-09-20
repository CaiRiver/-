package com.cai.mall.service;

import java.util.List;
import java.util.Map;

import com.cai.mall.utils.PageUtils;

public interface CartService {
	
	void joinCart(int comId, int userId, int purchaseNum);
	
	PageUtils<List<Map<String, Object>>> listCartCom2(int userId, int currentPageNum);
	
	List<Map<String, Object>> listCartCom(int userId);
}
