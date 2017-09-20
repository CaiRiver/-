package com.cai.mall.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProvinceAndCityMapper {
	
	List<Map<String, String>> listProvince();
	
	List<Map<String, String>> listCity(@Param("provinceCode")String provinceCode);
	
	List<Map<String, String>> listArea(@Param("cityCode")String cityCode);
	
	String getProvinceByCode(@Param("provinceCode")String provinceCode);
	
	String getCityByCode(@Param("cityCode")String cityCode);
	
	String getAreaByCode(@Param("areaCode")String areaCode);
}
