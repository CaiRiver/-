package com.cai.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cai.mall.domain.ShoppingTrolley;

public interface CartMapper {
	
	int addCom(ShoppingTrolley shoppingTrolley);
	
	List<ShoppingTrolley> ListCart(@Param("userId")Integer userId, @Param("offset")Integer offset, @Param("pageNum")Integer pageNum);

	int countCart(@Param("userId")Integer userId);
	
	List<ShoppingTrolley> listCart(@Param("userId") Integer userId);
}
