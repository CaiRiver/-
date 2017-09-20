package com.cai.mall.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cai.mall.dto.AjaxResultDTO;
import com.cai.mall.exception.MallException;
import com.cai.mall.service.CartService;


@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/intoCart")
	@ResponseBody
	public AjaxResultDTO intoCart(HttpServletRequest request, 
			@RequestParam("comId")int comId,
			@RequestParam("purchaseNum")int purchaseNum) {
		try {
			cartService.joinCart(comId, getUserId(request), purchaseNum);
			return AjaxResultDTO.success();
		} catch (MallException me) {
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return AjaxResultDTO.failed("系统异常练习连客服");
		}
		
	}
	
	@RequestMapping("/goToCart")
	public String goToCart() {
		logger.info("goToCart");
		return "cart";
	}
	
	@RequestMapping("/listCart")
	@ResponseBody
	public AjaxResultDTO listCart(HttpServletRequest request) {
		try {
			logger.info("listCart");
			List<Map<String, Object>> list = cartService.listCartCom(getUserId(request));
			return AjaxResultDTO.success(list);
		} catch (MallException me) {
			logger.error(me.getMessage());
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return AjaxResultDTO.failed("系统异常，请联系客服");
		}
	}
}
