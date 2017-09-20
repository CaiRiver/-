package com.cai.mall.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cai.mall.controller.GoodController;
import com.cai.mall.domain.Commodity;
import com.cai.mall.domain.Type;
import com.cai.mall.mapper.CommodityMapper;
import com.cai.mall.mapper.TypeMapper;
import com.cai.mall.service.GoodService;


@Service
public class GoodServiceImpl implements GoodService {

	Logger logger = LoggerFactory.getLogger(GoodController.class);
	
	@Autowired
	private CommodityMapper commodityMapper;
	
	@Autowired
	private TypeMapper typeMapper;
	
	@Override
	public List<Map<String, Object>> listGoods() {
		logger.info("listGoods");
		List<Type> types = typeMapper.listType();
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Type type : types) {
			List<Commodity> comList = commodityMapper.listCom(type.getId());
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("goods", comList);
			map.put("typeId", type.getId());
			map.put("typename", type.getTypename());
			list.add(map);
		}
		
		return list;
	}
	

}
