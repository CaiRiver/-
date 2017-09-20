package com.cai.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cai.mall.constants.Constants;
import com.cai.mall.domain.Address;
import com.cai.mall.dto.AddressDTO;
import com.cai.mall.exception.MallException;
import com.cai.mall.mapper.ProvinceAndCityMapper;
import com.cai.mall.mapper.UserAddressMapper;
import com.cai.mall.service.UserAddressService;
import com.cai.mall.vo.AddressVO;
import com.sun.corba.se.impl.transport.DefaultIORToSocketInfoImpl;

@Service
public class UserAddressServiceImpl implements UserAddressService {
	
	@Autowired
	private UserAddressMapper userAddressMapper;
	
	@Autowired
	private ProvinceAndCityMapper provinceAndCityMapper;
	
	@Override
	public void address(AddressVO vo, int userId) {
		Address as = new Address();
		as.setAreaCharacter(provinceAndCityMapper.getAreaByCode(vo.getAreaCode()));
		as.setAreaCode(vo.getAreaCode());
		as.setCellPhone(vo.getPhoneNum());
		as.setCityCharacter(provinceAndCityMapper.getCityByCode(vo.getCityCode()));
		as.setCityCode(vo.getCityCode());
		as.setDetailedAddress(vo.getDetailAddress());
		as.setIsDefault(vo.getIsDefault());
		as.setProvinceCharacter(provinceAndCityMapper.getProvinceByCode(vo.getProvinceCode()));
		as.setProvinceCode(vo.getProvinceCode());
		as.setRealName(vo.getRealName());
		as.setStatus(Constants.ENABLESTATUS);
		as.setUserId(userId);
		int rows = userAddressMapper.addAddress(as);
		if (1 != rows) {
			throw new MallException("新增地址失败");
		}
	}

	@Override
	public List<AddressDTO> listAddress(int userId) {
		List<Address> addresses = userAddressMapper.listAddress(userId);
		
		List<AddressDTO> dtoList = new ArrayList<AddressDTO>(addresses.size());
		for (Address address : addresses) {
			AddressDTO dto = new AddressDTO();
			dtoList.add(dto);
			
			dto.setAreaCharacter(address.getAreaCharacter());
			dto.setAreaCode(address.getAreaCode());
			dto.setCellPhone(address.getCellPhone());
			dto.setCityCharacter(address.getCityCharacter());
			dto.setCityCode(address.getCityCode());
			dto.setDetailedAddress(address.getDetailedAddress());
			dto.setId(address.getId());
			dto.setIsDefault(address.getIsDefault());
			dto.setProvinceCharacter(address.getProvinceCharacter());
			dto.setProvinceCode(address.getProvinceCode());
			dto.setRealName(address.getRealName());
			dto.setUserId(address.getUserId());
		}
		return dtoList;
	}

	@Override
	public void modifyAddress(AddressVO vo) {
		Address as = new Address();
		as.setAreaCharacter(provinceAndCityMapper.getAreaByCode(vo.getAreaCode()));
		as.setAreaCode(vo.getAreaCode());
		as.setCellPhone(vo.getPhoneNum());
		as.setCityCharacter(provinceAndCityMapper.getCityByCode(vo.getCityCode()));
		as.setCityCode(vo.getCityCode());
		as.setDetailedAddress(vo.getDetailAddress());
		as.setIsDefault(vo.getIsDefault());
		as.setProvinceCharacter(provinceAndCityMapper.getProvinceByCode(vo.getProvinceCode()));
		as.setProvinceCode(vo.getProvinceCode());
		as.setRealName(vo.getRealName());
		as.setId(vo.getAddressId());
		int rows = userAddressMapper.modifyAddress(as);
		if (1 != rows) {
			throw new MallException("修改地址失败");
		}
		
	}

	@Override
	public void deleteAddress(AddressVO vo, int userId) {
		Address address = userAddressMapper.getAddressById(vo.getAddressId());
		if (address == null) {
			throw new MallException("此项地址不存在");
		}
		
		if (userId != address.getUserId()) {
			throw new MallException("无权删除");
		}
		address.setStatus(Constants.UNABLESTATUS);
		int rows = userAddressMapper.deleteAddress(address);
		if (1 != rows) {
			throw new MallException("删除失败");
		}
	}
	
	
}
