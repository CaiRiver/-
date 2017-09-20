package com.cai.mall.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cai.mall.domain.Commodity;
import com.cai.mall.domain.ShoppingTrolley;
import com.cai.mall.dto.CommodityDTO;
import com.cai.mall.dto.ShoppingTrolleyDTO;
import com.cai.mall.enums.CartStatus;
import com.cai.mall.enums.CommodityStatus;
import com.cai.mall.exception.MallException;
import com.cai.mall.mapper.CartMapper;
import com.cai.mall.mapper.CommodityMapper;
import com.cai.mall.service.CartService;
import com.cai.mall.utils.PageUtils;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private CommodityMapper commodityMapper;
	
	@Override
	public void joinCart(int comId, int userId, int purchaseNum) {
		
		ShoppingTrolley shoppingTrolley = new ShoppingTrolley();
		shoppingTrolley.setCommodityId(comId);
		shoppingTrolley.setPurchaseNum(purchaseNum);
		shoppingTrolley.setStatus(CartStatus.NORMAL.getK());
		shoppingTrolley.setUserId(userId);
		int rows = cartMapper.addCom(shoppingTrolley);
		if (1 != rows) {
			throw new MallException("加入购物车失败");
		}
		
	}

	//不用分页了！！！！！！！！！！
	@Override
	public PageUtils<List<Map<String, Object>>> listCartCom2(int userId, int currentPageNum) {
		int totalNum = cartMapper.countCart(userId);
		PageUtils<List<Map<String, Object>>> pageUtils = new PageUtils<List<Map<String, Object>>>(currentPageNum, totalNum);
		
		
		List<ShoppingTrolley> carts = cartMapper.ListCart(userId, pageUtils.getOffset(), PageUtils.PER_PAGE_NUM);
		
		
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (ShoppingTrolley cart : carts) {
			ShoppingTrolleyDTO std = new ShoppingTrolleyDTO();
			std.setCommodityId(cart.getCommodityId());
			std.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cart.getCreateTime()));
			std.setId(cart.getId());
			std.setModifyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cart.getModifyTime()));
			std.setPurchaseNum(cart.getPurchaseNum());
			
			
			std.setStatus(CartStatus.getEnum(cart.getStatus()).getmString());
			std.setUserId(cart.getUserId());
			Commodity commodity = commodityMapper.getComByComId(cart.getCommodityId());
			
			CommodityDTO cd = new CommodityDTO();
			cd.setComDesc(commodity.getComDesc());
			cd.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(commodity.getCreateTime()));
			cd.setId(commodity.getId());
			cd.setInventory(commodity.getInventory());
			cd.setModifyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(commodity.getModifyTime()));
			cd.setName(commodity.getName());
			cd.setPicture(commodity.getPicture());
			cd.setSoldNum(commodity.getSoldNum());
			cd.setStatus(CommodityStatus.getEnum(commodity.getStatus()).getmString());
			//TODO 此处返回时候 应该市 类目所对应的名称才是？
			cd.setTypeId(commodity.getTypeId());
			cd.setUnitPrice(commodity.getUnitPrice());
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("commodity", cd);
			map.put("shoppingTrolleyDTO", std);
			list.add(map);
		}
		//TODO 这map 放list中 泛型怎么定义？
		pageUtils.setData(list);
		return pageUtils;
	}

	@Override
	public List<Map<String, Object>> listCartCom(int userId) {
		
		List<ShoppingTrolley> carts = cartMapper.listCart(userId);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (ShoppingTrolley cart : carts) {
			ShoppingTrolleyDTO std = new ShoppingTrolleyDTO();
			std.setCommodityId(cart.getCommodityId());
			std.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cart.getCreateTime()));
			std.setId(cart.getId());
			std.setModifyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cart.getModifyTime()));
			std.setPurchaseNum(cart.getPurchaseNum());
			
			
			std.setStatus(CartStatus.getEnum(cart.getStatus()).getmString());
			std.setUserId(cart.getUserId());
			Commodity commodity = commodityMapper.getComByComId(cart.getCommodityId());
			
			CommodityDTO cd = new CommodityDTO();
			cd.setComDesc(commodity.getComDesc());
			cd.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(commodity.getCreateTime()));
			cd.setId(commodity.getId());
			cd.setInventory(commodity.getInventory());
			cd.setModifyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(commodity.getModifyTime()));
			cd.setName(commodity.getName());
			cd.setPicture(commodity.getPicture());
			cd.setSoldNum(commodity.getSoldNum());
			cd.setStatus(CommodityStatus.getEnum(commodity.getStatus()).getmString());
			//TODO 此处返回时候 应该市 类目所对应的名称才是？
			cd.setTypeId(commodity.getTypeId());
			cd.setUnitPrice(commodity.getUnitPrice());
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("commodity", cd);
			map.put("shoppingTrolleyDTO", std);
			list.add(map);
		}
		return list;
	}

	
}
