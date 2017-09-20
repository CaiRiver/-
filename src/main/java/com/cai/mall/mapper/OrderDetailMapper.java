package com.cai.mall.mapper;

import java.util.List;

import com.cai.mall.domain.OrderDetail;

public interface OrderDetailMapper {
	
	int save(OrderDetail orderDetail);
	
	List<OrderDetail> listOrderDetail(Integer orderId);
	
}
