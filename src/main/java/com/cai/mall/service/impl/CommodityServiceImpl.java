package com.cai.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cai.mall.domain.Commodity;
import com.cai.mall.exception.MallException;
import com.cai.mall.mapper.CommodityMapper;
import com.cai.mall.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService{
	
	@Autowired
	private CommodityMapper commodityMapper;

	@Override
	public Commodity getComByComId(int comId) {
		Commodity commodity = commodityMapper.getComByComId(comId);
		if (null == commodity) {
			throw new MallException("没有此商品，正在为您申购");
		}
		return commodity;
	}

	
}
