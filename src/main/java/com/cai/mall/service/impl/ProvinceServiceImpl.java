package com.cai.mall.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cai.mall.mapper.ProvinceAndCityMapper;
import com.cai.mall.service.ProvinceService;
import com.cai.mall.service.RedisService;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProvinceServiceImpl.class);
	
	@Autowired
	private ProvinceAndCityMapper provinceAndCityMapper;
	
	@Resource(name="redisServiceImpl")
	private RedisService redisService;
	
	@Override
	public List<Map<String, String>> listProvince() {
		String provinceKey = "mall:province";
		//先到缓存区查,若存在，则返回,若无， 则去数据库查
		boolean flag = redisService.hasKey(provinceKey);
		if (flag) {
			logger.info(">>>省份走缓存,{}" + provinceKey);
			return redisService.getProvince(provinceKey);
		}
		 List<Map<String, String>> provinceDateList = provinceAndCityMapper.listProvince();
		 redisService.setProvince(provinceKey, provinceDateList);
		 return provinceDateList;
	}


	@Override
	public List<Map<String, String>> listCity(String provinceCode) {
		String cityKey = String.format("mall:city:%s", provinceCode);
		boolean flag = redisService.hasKey(cityKey);
		if (flag) {
			logger.info(">>>城市走缓存,{}" + cityKey);
			return redisService.getCity(cityKey);
		}
		
		List<Map<String, String>> cityDataList = provinceAndCityMapper.listCity(provinceCode);
		redisService.setCity(cityKey, cityDataList);
		return cityDataList;
	
	}


	@Override
	public List<Map<String, String>> listArea(String cityCode) {
		return provinceAndCityMapper.listArea(cityCode);
	}
	
}
