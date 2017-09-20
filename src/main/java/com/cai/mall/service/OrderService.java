package com.cai.mall.service;

import java.util.List;
import java.util.Map;

import com.cai.mall.domain.Order;
import com.cai.mall.dto.CommodityOrderInfoDTO;
import com.cai.mall.dto.MyOrderDTO;
import com.cai.mall.service.impl.OrderServiceImpl.BugCommodityDetail;
import com.cai.mall.vo.BuyCommodityVO;

public interface OrderService {
	
	List<BugCommodityDetail> createOrder(String commodityMsg, int userId);
	
	Order createOrderFromCart(List<BuyCommodityVO> vos, int userId);
	
	CommodityOrderInfoDTO loadOrderInfo(int orderId, int userId);
	
	Map<String, Object> pay(int orderId, int payChannel, int addressId, int userId);
	
	List<MyOrderDTO> listEffectivedOrder(Integer userId, Integer status);
}
