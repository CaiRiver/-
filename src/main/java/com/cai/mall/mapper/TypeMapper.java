package com.cai.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cai.mall.domain.Type;

public interface TypeMapper {
	Type getTypeById(@Param("typeId")Integer typeId, @Param("typename")String typename);
	
	List<Type> listType();

}
