package com.cai.mall.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cai.mall.dto.AjaxResultDTO;
import com.cai.mall.service.GoodService;


@Controller
@RequestMapping("/goods")
public class GoodController {
	
	
	
	@Autowired
	private GoodService goodService;
	
	@RequestMapping("/listGoods")
	@ResponseBody
	public AjaxResultDTO listGoods() {
		try {
			List<Map<String, Object>> list = goodService.listGoods();
			return AjaxResultDTO.success(list);
		} catch (MailException me) {
			return AjaxResultDTO.failed(me.getMessage());
		}
		
	}
	
}
