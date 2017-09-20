package com.cai.mall.service;

import java.util.List;
import java.util.Map;

public interface ProvinceService {
	
	List<Map<String, String>> listProvince();
	
	List<Map<String, String>> listCity(String provinceCode);
	
	List<Map<String, String>> listArea(String cityCode);
}
