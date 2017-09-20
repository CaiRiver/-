package com.cai.mall.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cai.mall.dto.AddressDTO;
import com.cai.mall.dto.AjaxResultDTO;
import com.cai.mall.exception.MallException;
import com.cai.mall.service.ProvinceService;
import com.cai.mall.service.UserAddressService;
import com.cai.mall.vo.AddressVO;


@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private ProvinceService provinceService;
	
	@Autowired
	private UserAddressService userAddressService;
	
	@RequestMapping("/toMyAddress")
	public ModelAndView toMyAddress() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("address");
		return mv;
	}
	
	@RequestMapping("/listProvince")
	@ResponseBody
	public AjaxResultDTO listProvince() {
		try {
			logger.info("listProvince");
			List<Map<String, String>> list = provinceService.listProvince();
			return AjaxResultDTO.success(list);
		} catch (MallException me) {
			logger.error("省查找失败,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error("省查找失败,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("系统异常,请练习客服");
		}
		
	}
	
	@RequestMapping("/listCity")
	@ResponseBody
	public AjaxResultDTO listCity(String provinceCode) {
		try {
			logger.info("listCity");
			List<Map<String, String>>  list = provinceService.listCity(provinceCode);
			return AjaxResultDTO.success(list);
		} catch (MallException me) {
			logger.error("市查找失败,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error("市查找失败,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("查找市失败,请联系客服");
		}
		
	}
	
	@RequestMapping("/listArea")
	@ResponseBody
	public AjaxResultDTO listArea(String cityCode) {
		try {
			logger.info("listArea");
			return AjaxResultDTO.success(provinceService.listArea(cityCode));
		} catch (MallException me) {
			logger.error("区查找失败,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error("区查找失败,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("查找区失败,请练习客服");
		}
		
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public AjaxResultDTO add(AddressVO vo, HttpServletRequest request) {
		try {
			logger.info("addAddress");
			userAddressService.address(vo, getUserId(request));
			return AjaxResultDTO.success();
		} catch (MallException me) {
			logger.error("新增地址失败,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error("新增地址失败,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("新增地址失败，请联系客服");
		}
		
	}
	
	@RequestMapping("/listAddress")
	@ResponseBody
	public AjaxResultDTO listAddress(HttpServletRequest request) {
		try {
			logger.info("listAddress");
			List<AddressDTO> addressList = userAddressService.listAddress(getUserId(request));
			return AjaxResultDTO.success(addressList);
		} catch (MallException me) {
			logger.error("获取地址失败,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error("获取地址失败,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("获取地址失败，请联系客服");
		}
	}
	
	@RequestMapping("/modify")
	@ResponseBody
	public AjaxResultDTO modify(AddressVO vo) {
		try {
			logger.info("modify");
			userAddressService.modifyAddress(vo);
			return AjaxResultDTO.success();
		} catch (MallException me) {
			logger.error("修改地址异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error("修改地址异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("修改地址异常,请联系客服");
		}
		
	}
	//TODO 完善catch EXCEPTION 部分
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResultDTO delete(AddressVO vo, HttpServletRequest request) {
		try {
			logger.info("delete");
			userAddressService.deleteAddress(vo, getUserId(request));
			return AjaxResultDTO.success();
		} catch (MallException me) {
			logger.error("删除地址异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error("删除地址异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("删除地址异常，请联系客服");
		}
		
	}
}
