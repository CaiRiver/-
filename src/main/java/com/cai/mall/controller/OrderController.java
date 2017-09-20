package com.cai.mall.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.cai.mall.domain.Order;
import com.cai.mall.dto.AjaxResultDTO;
import com.cai.mall.dto.CommodityOrderInfoDTO;
import com.cai.mall.dto.MyOrderDTO;
import com.cai.mall.exception.MallException;
import com.cai.mall.service.OrderService;
import com.cai.mall.vo.BuyCommodityVO;



@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
//	@RequestMapping("/createOrder")
//	@ResponseBody
//	public AjaxResultDTO createOrder(String commodityMsg, HttpServletRequest request) {
//		logger.info(">>>>>>>购物车结算数据");
//		if (StringUtils.isBlank(commodityMsg)) {
//			return AjaxResultDTO.failed("信息不合法");
//		}
//		try {
//			List<BugCommodityDetail> list = orderService.createOrder(commodityMsg, getUserId(request));
//			return AjaxResultDTO.success(list);
//		} catch (MallException me) {
//			logger.error("去结算失败,{}", me.getMessage(), me);
//			return AjaxResultDTO.failed(me.getMessage());
//		} catch (Exception e) {
//			logger.error("去结算失败,{}", e.getMessage(), e);
//			return AjaxResultDTO.failed("创建订单失败");
//		}
//	}
	
//	//data:msg,
//	@RequestMapping("/createOrder")
//	@ResponseBody
//	public AjaxResultDTO createOrder(@RequestBody String msg, HttpServletRequest request) {
//		logger.info(">>>>>>>购物车结算数据");
//		try {
//			logger.info("购买信息:{}", msg);
//			 List<BuyCommodityVO> voList = JSON.parseArray(msg, BuyCommodityVO.class);
//			logger.info(">>>>>>长度" + voList.size());
//			 //List<BugCommodityDetail> list = orderService.createOrder(buyCommodityVO, getUserId(request));
//			return AjaxResultDTO.success();
//		} catch (MallException me) {
//			logger.error("去结算失败,{}", me.getMessage(), me);
//			return AjaxResultDTO.failed(me.getMessage());
//		} catch (Exception e) {
//			logger.error("去结算失败,{}", e.getMessage(), e);
//			return AjaxResultDTO.failed("创建订单失败");
//		}
//	}
	
//	@RequestMapping("/createOrder")
//	@ResponseBody
//	public AjaxResultDTO createOrder(String buyMsg, HttpServletRequest request) {
//		logger.info(">>>>>>>购物车结算数据");
//		try {
//			logger.info("购买信息:{}", buyMsg);
//			 List<BuyCommodityVO> voList = JSON.parseArray(buyMsg, BuyCommodityVO.class);
//			logger.info(">>>>>>长度" + voList.size());
//			 //List<BugCommodityDetail> list = orderService.createOrder(buyCommodityVO, getUserId(request));
//			return AjaxResultDTO.success();
//		} catch (MallException me) {
//			logger.error("去结算失败,{}", me.getMessage(), me);
//			return AjaxResultDTO.failed(me.getMessage());
//		} catch (Exception e) {
//			logger.error("去结算失败,{}", e.getMessage(), e);
//			return AjaxResultDTO.failed("创建订单失败");
//		}
//	}
	
	@RequestMapping("/toOrder")
	public ModelAndView toOrder(String orderId) {
		logger.info("toOrder");
		ModelAndView mv = null;
		//TODO 这儿出异常该如何处理
		mv = new ModelAndView();
		mv.addObject("orderId", orderId);
		mv.setViewName("order");
		return mv;
	
		
	}
	
	@RequestMapping("toMyOrder")
	public ModelAndView toMyOrder() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myorder");
		return mv;
	}
	
	@RequestMapping("/createOrder4JsonBody")
	@ResponseBody
	public AjaxResultDTO createOrder4JsonBody(@RequestBody List<BuyCommodityVO> vos, HttpServletRequest request) {
		logger.info(">>>>" + vos.size());
		for (BuyCommodityVO vo : vos) {
			logger.info(">>>>>"+ vo.getCommodityId());
			logger.info(">>>>>"+ vo.getPurchaseNum());
		}
		
		try {
			Order order = orderService.createOrderFromCart(vos, getUserId(request));
			return AjaxResultDTO.success(order);
		} catch(MallException me) {
			logger.error("订单生成失败,{}", me.getMessage());
			return AjaxResultDTO.failed(me.getMessage());
		} catch(Exception e) {
			logger.error("订单生成失败,{}",e.getMessage(), e);
			return AjaxResultDTO.failed("订单结算失败");
		}
		
	}
	
	
	@RequestMapping("/loadOrderInfo")
	@ResponseBody
	public AjaxResultDTO loadOrderInfo(Integer orderId, HttpServletRequest request) {
		try {
			logger.info("loadOrderInfo");
			CommodityOrderInfoDTO coid = orderService.loadOrderInfo(orderId, getUserId(request));
			return AjaxResultDTO.success(coid);
		} catch (MallException me) {
			logger.error("加载订单失败,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error("加载订单失败,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("加载订单失败,请联系客服");
		}
		
	}
	
	@RequestMapping("/pay")
	@ResponseBody
	public AjaxResultDTO pay(int orderId, int payChannel, int addressId, HttpServletRequest request) {
		try {
			logger.info("pay");
			logger.info("用户确认支付，orderID={}, payChannel={}, addresssId={}", orderId, payChannel, addressId);
			Map<String, Object> map = orderService.pay(orderId, payChannel, addressId, getUserId(request));
			return AjaxResultDTO.success(map);
		} catch (MallException me) {
			logger.error("支付失败,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			logger.error("支付失败,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("系统异常，请联系客服");
		}
		
		
	}
	
	@RequestMapping("/loadOrders")
	@ResponseBody
	public AjaxResultDTO loadOrders(int status, HttpServletRequest request) {
		try {
			List<MyOrderDTO> listUnPayOrder = orderService.listEffectivedOrder(getUserId(request), status);
			return AjaxResultDTO.success(listUnPayOrder);
		} catch(MallException se) {
			return AjaxResultDTO.failed(se.getMessage());
		} catch(Exception e) {
			logger.error("查询我的订单异常", e);
			return AjaxResultDTO.failed("查询我的订单失败");
		}
	}
}
