package com.cai.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cai.mall.domain.Order;

public interface OrderMapper {
	
	int createOrder(Order order);
	
	Order getOrderById(Integer orderId);
	
	int changeOrderStatus(@Param("status")Integer status, @Param("userId")Integer userId, @Param("orderId")Integer orderId);
	
	int updateOrderInfo(Order order);
	
	List<Order> listOrderByUserIdAndStatus(@Param("status")Integer status, @Param("userId")Integer userId);
}
