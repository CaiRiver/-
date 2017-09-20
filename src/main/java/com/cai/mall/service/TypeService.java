package com.cai.mall.service;

import java.util.List;
import java.util.Map;

import com.cai.mall.domain.Type;
import com.cai.mall.utils.TypeGoodUtil;


public interface TypeService {
	TypeGoodUtil<Type> listType(int typeId);
	
	
}
