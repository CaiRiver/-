package com.cai.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cai.mall.domain.Commodity;
import com.cai.mall.dto.AjaxResultDTO;
import com.cai.mall.exception.MallException;
import com.cai.mall.service.CommodityService;


@Controller
@RequestMapping("/commodity")
public class CommodityIntroduceController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommodityIntroduceController.class);
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping("/toIntroduce/{comId}")
	public String toIntroduce(@PathVariable Integer comId) {
		//request.setAttribute("comId", comId);
		//session.getAttribute("login_user");
		return "commodity_introduce";
	}
	
	@RequestMapping("/introduce")
	@ResponseBody
	public AjaxResultDTO introduce( @RequestParam("comId")Integer comId, HttpServletRequest request) {
		logger.info("introduce");
		try {
			Commodity com = commodityService.getComByComId(comId);
			return AjaxResultDTO.success(com);
		} catch (MallException me) {
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return AjaxResultDTO.failed("系统异常请联系客服");
		}
		
	}
	
	
}
