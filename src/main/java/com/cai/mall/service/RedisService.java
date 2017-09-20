package com.cai.mall.service;

import java.util.List;
import java.util.Map;

public interface RedisService {
	
	boolean hasKey(String key);
	
	List<Map<String, String>> getProvince(String key);
	
	void setProvince(String key, List<Map<String, String>> value);
	
	List<Map<String, String>> getCity(String key);
	
	void setCity(String key, List<Map<String, String>> value);
}
