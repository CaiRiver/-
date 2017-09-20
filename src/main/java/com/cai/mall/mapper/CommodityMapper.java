package com.cai.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cai.mall.domain.Commodity;

public interface CommodityMapper {
	List<Commodity> listCom(@Param("typeId")Integer typeId);
	
	Commodity getComByComId(@Param("comId")Integer comId);
	
}
