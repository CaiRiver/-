package com.cai.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cai.mall.domain.Address;

public interface UserAddressMapper {
	
	int addAddress(Address address);
	
	List<Address> listAddress(@Param("userId")Integer userId);
	
	int modifyAddress(Address address);
	
	int deleteAddress(Address address);
	
	Address getAddressById(@Param("addressId")Integer addressId);
}
