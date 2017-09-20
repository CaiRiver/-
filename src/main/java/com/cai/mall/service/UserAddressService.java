package com.cai.mall.service;

import java.util.List;

import com.cai.mall.domain.Address;
import com.cai.mall.dto.AddressDTO;
import com.cai.mall.vo.AddressVO;

public interface UserAddressService {
	
	void address(AddressVO vo, int userId);
	
	List<AddressDTO> listAddress(int userId);
	
	void modifyAddress(AddressVO vo);
	
	void deleteAddress(AddressVO vo, int userId);
}
