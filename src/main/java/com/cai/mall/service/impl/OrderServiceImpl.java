package com.cai.mall.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cai.mall.constants.Constants;
import com.cai.mall.domain.Address;
import com.cai.mall.domain.Commodity;
import com.cai.mall.domain.Order;
import com.cai.mall.domain.OrderDetail;
import com.cai.mall.dto.CommodityOrderInfoDTO;
import com.cai.mall.dto.CommodityOrderInfoDTO.CommodityInfo;
import com.cai.mall.dto.MyOrderDTO;
import com.cai.mall.dto.MyOrderDTO.OrderGoods;
import com.cai.mall.enums.CommodityStatus;
import com.cai.mall.enums.OrderStauts;
import com.cai.mall.enums.PayTypeEnum;
import com.cai.mall.exception.MallException;
import com.cai.mall.mapper.CommodityMapper;
import com.cai.mall.mapper.OrderDetailMapper;
import com.cai.mall.mapper.OrderMapper;
import com.cai.mall.mapper.ProvinceAndCityMapper;
import com.cai.mall.mapper.UserAddressMapper;
import com.cai.mall.service.OrderService;
import com.cai.mall.utils.DateUtils;
import com.cai.mall.utils.MathUtil;
import com.cai.mall.vo.BuyCommodityVO;
import com.dayuanit.pay.domain.PayOrder;
import com.dayuanit.pay.service.PayService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private CommodityMapper commodityMapper;
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Autowired
	private ProvinceAndCityMapper provinceAndCityMapper;
	
	@Autowired
	private UserAddressMapper userAddressMapper;
	
	@Autowired
	private PayService payService;
//	@Override
//	@Transactional(rollbackFor=Exception.class)
//	public List<BugCommodityDetail> createOrder(String commodityMsg, int userId) {
//		String[] mStrings = commodityMsg.split("\\&");
//
//		List<BugCommodityDetail> detailList = new ArrayList<BugCommodityDetail>();
//		for (String mString : mStrings) {
//			if (StringUtils.isBlank(mString)) {
//				continue;
//			}
//			String[] mStrings2 = mString.split("\\-");
//			String commodityId = mStrings2[0];
//			String purchaseNum = mStrings2[1];
//
//			Commodity commodity = commodityMapper.getComByComId(Integer.valueOf(commodityId));
//			if (null == commodity) {
//				throw new MallException("商品不存在");
//			}
//
//			if (commodity.getStatus() == Constants.OFFSELLSTATUS) {
//				throw new MallException("商品已下架");
//			}
//
//			if (commodity.getInventory() < Integer.valueOf(purchaseNum)) {
//				throw new MallException("库存不足");
//			}
//			
//			BugCommodityDetail bcd = new BugCommodityDetail();
//			bcd.setBuyNum(purchaseNum);
//			bcd.setCommodity(commodity);
//			detailList.add(bcd);
//		}
//		
//		processOrderDetail(detailList, userId);
//		
//		return detailList;
//	}
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<BugCommodityDetail> createOrder(String commodityMsg, int userId) {
		String[] mStrings = commodityMsg.split("\\&");

		List<BugCommodityDetail> detailList = new ArrayList<BugCommodityDetail>();
		for (String mString : mStrings) {
			if (StringUtils.isBlank(mString)) {
				continue;
			}
			String[] mStrings2 = mString.split("\\-");
			String commodityId = mStrings2[0];
			String purchaseNum = mStrings2[1];

			Commodity commodity = commodityMapper.getComByComId(Integer.valueOf(commodityId));
			if (null == commodity) {
				throw new MallException("商品不存在");
			}

			if (commodity.getStatus() == Constants.OFFSELLSTATUS) {
				throw new MallException("商品已下架");
			}

			if (commodity.getInventory() < Integer.valueOf(purchaseNum)) {
				throw new MallException("库存不足");
			}
			
			BugCommodityDetail bcd = new BugCommodityDetail();
			bcd.setBuyNum(purchaseNum);
			bcd.setCommodity(commodity);
			detailList.add(bcd);
		}
		
		processOrderDetail(detailList, userId);
		
		return detailList;
	}
	
	private void processOrderDetail(List<BugCommodityDetail> detailList, int userId) {
		
		//先生成订单， 再管订单详情
		Order order = new Order();
		order.setOrderFrom(Constants.FROMSHOPPINGTROLLEY);
		order.setUserId(userId);
		order.setStatus(Constants.WAITTOPAY);
		String totalAmount = "0";
		for (BugCommodityDetail bugCommodityDetail : detailList) {
			String amount = MathUtil.mul(bugCommodityDetail.buyNum, bugCommodityDetail.commodity.getUnitPrice());
			totalAmount = MathUtil.plus(amount, totalAmount);
		}
		order.setAmount(totalAmount);
		
		int rows = orderMapper.createOrder(order);
		if (1 != rows) {
			throw new MallException("创建订单失败");
		}
		
		for (BugCommodityDetail bugCommodityDetail : detailList) {
			OrderDetail or = new OrderDetail();
			//内部类的私有属性访问 私有类实例化就能.访问了 不用get？？？
			or.setCommodityId(bugCommodityDetail.commodity.getId());
			or.setCommodityName(bugCommodityDetail.commodity.getName());
			or.setOrderId(order.getId());
			or.setQuantity(Integer.valueOf(bugCommodityDetail.buyNum));
			or.setUnitPrice(bugCommodityDetail.commodity.getUnitPrice());
			String amount = MathUtil.mul(bugCommodityDetail.buyNum, bugCommodityDetail.commodity.getUnitPrice());
			
			or.setAmount(amount);
			rows = orderDetailMapper.save(or);
			if (rows != 1) {
				throw new MallException("创建订单失败");
			}
		}
		
	}

	

	public static class BugCommodityDetail {
		private Commodity commodity;
		private String buyNum;

		public Commodity getCommodity() {
			return commodity;
		}

		public void setCommodity(Commodity commodity) {
			this.commodity = commodity;
		}

		public String getBuyNum() {
			return buyNum;
		}

		public void setBuyNum(String buyNum) {
			this.buyNum = buyNum;
		}

	}



	@Override
	@Transactional(rollbackFor=Exception.class)
	public Order createOrderFromCart(List<BuyCommodityVO> vos, int userId) {
		
		List<OrderDetail> orderDetailsList = new ArrayList<OrderDetail>(vos.size());
		
		String totalMoney = "0";
		
		for (BuyCommodityVO vo : vos) {
			Commodity commodity = commodityMapper.getComByComId(vo.getCommodityId());
			if (null == commodity) {
				throw new MallException("没有此商品");
			}
			
			if (commodity.getStatus() == CommodityStatus.SOLDOUT.getK()) {
				throw new MallException(String.format("商品%s已下架", commodity.getName()));
			}
			
			if (commodity.getInventory() < vo.getPurchaseNum()) {
				throw new MallException(String.format("商品%s库存不足", commodity.getName()));
			}
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setCommodityName(commodity.getName());
			orderDetail.setQuantity(vo.getPurchaseNum());
			orderDetail.setUnitPrice(commodity.getUnitPrice());
			String amount = MathUtil.mul(commodity.getUnitPrice(), String.valueOf(vo.getPurchaseNum()));
			orderDetail.setAmount(amount);
			orderDetail.setCommodityId(vo.getCommodityId());
			orderDetailsList.add(orderDetail);
			
			totalMoney = MathUtil.plus(amount, totalMoney);
		}
		
		Order order = new Order();
		
		order.setAmount(totalMoney);
		order.setOrderFrom(Constants.FROMSHOPPINGTROLLEY);
		order.setUserId(userId);
		order.setStatus(OrderStauts.WAITTOPAY.getK());
		int rows = orderMapper.createOrder(order);
		if (rows != 1) {
			throw new MallException("创建订单失败");
		}
		
		for (OrderDetail orderDetail : orderDetailsList) {
			orderDetail.setOrderId(order.getId());
			rows = orderDetailMapper.save(orderDetail);
			if (1 != rows) {
				throw new MallException("创建订单失败");
			}
		}
		
		
		
		return order;
	}

	@Override
	public CommodityOrderInfoDTO loadOrderInfo(int orderId, int userId) {
		Order order = orderMapper.getOrderById(orderId);
		if (null == order) {
			throw new MallException("没有此项订单");
		}
		
		if (order.getUserId() != userId) {
			throw new MallException("无权查看此订单");
		}
		
		CommodityOrderInfoDTO commodityOrderInfoDTO = new CommodityOrderInfoDTO();
		commodityOrderInfoDTO.setTotalAmount(order.getAmount());
		
		List<OrderDetail> orderDetails = orderDetailMapper.listOrderDetail(orderId);
		List<CommodityInfo> commodities = new ArrayList<CommodityInfo>(orderDetails.size());
		
		for (OrderDetail orderDetail : orderDetails) {
			CommodityInfo commodityInfo = new CommodityInfo();
			commodities.add(commodityInfo);
			commodityInfo.setAmount(orderDetail.getAmount());
			commodityInfo.setCommodityName(orderDetail.getCommodityName());
			commodityInfo.setPurchaseNum(orderDetail.getQuantity());
		}
		commodityOrderInfoDTO.setCommodities(commodities);
		
		
		return commodityOrderInfoDTO;
	}

	@Override
	public Map<String, Object> pay(int orderId, int payChannel, int addressId, int userId) {
		Order order = orderMapper.getOrderById(orderId);
		if (null == order) {
			throw new MallException("没有此订单");
		}
		
		if (order.getUserId() != userId) {
			throw new MallException("无权处理此订单");
		}
		
		if (order.getStatus() != OrderStauts.WAITTOPAY.getK()
				&& order.getStatus() != OrderStauts.UNPAY.getK()) {
			throw new MallException("订单不能支付");
		}
		
		//设置订单过期时间
		Date orderTime = order.getModifyTime();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(orderTime);
		calendar.add(Calendar.MINUTE, 30);
		
		Date expirationTime = calendar.getTime();
		if (new Date().after(expirationTime)) {
			throw new MallException("订单超时");
		}
		
		if (order.getStatus() == OrderStauts.WAITTOPAY.getK()) {
			int rows = orderMapper.changeOrderStatus(OrderStauts.UNPAY.getK(), userId, orderId);
			if (1 != rows) {
				throw new MallException("订单更新失败");
			}
		}
		
		order.setPayChannel(payChannel);
		logger.info(">>>>>>>addressid" + addressId);
		Address address = userAddressMapper.getAddressById(addressId);
		logger.info(">>>>>>>adddress" + address.getAreaCharacter());
		order.setAreaCharacter(address.getAreaCharacter());
		order.setCityCharacter(address.getCityCharacter());
		order.setDetailAddress(address.getDetailedAddress());
		order.setCellPhone(address.getCellPhone());
		order.setProvinceCharacter(address.getProvinceCharacter());
		
		int rows = orderMapper.updateOrderInfo(order);
		if (1 != rows) {
			throw new MallException("更新订单失败");
		}
		//请求支付系统 获取支付地址
		PayOrder payOrder = new PayOrder();
		payOrder.setAmount(order.getAmount());
		payOrder.setBankId(null);
		payOrder.setBizId(String.valueOf(order.getId()));
		payOrder.setDetailMsg("大猿商城");
		payOrder.setPayChannel(order.getPayChannel());
		payOrder.setUserId(order.getUserId());
		
		Map<String, Object> map = payService.addPayOrder(payOrder);
		return map;
	}

	@Override
	public List<MyOrderDTO> listEffectivedOrder(Integer userId, Integer status) {
		if (status < 0) {
			status = null;
		}
		List<Order> orders = orderMapper.listOrderByUserIdAndStatus(status, userId);
		List<MyOrderDTO> myOrderDTOs = new ArrayList<>(orders.size());
		for (Order order : orders) {
			MyOrderDTO mDto = new MyOrderDTO();
			myOrderDTOs.add(mDto);
			
			mDto.setAmount(order.getAmount());
			mDto.setCreateTime(DateUtils.dateToString(order.getCreateTime()));
			mDto.setId(order.getId());
			mDto.setPayChannel(PayTypeEnum.getPayType(order.getPayChannel()).getDesc());
			mDto.setUserRealName(order.getRealName());
			
			List<OrderDetail> orderDetails = orderDetailMapper.listOrderDetail(order.getId());
			List<OrderGoods> goodsList =  new ArrayList<>(orderDetails.size());
			for (OrderDetail orderDetail : orderDetails) {
				OrderGoods orderGoods = new OrderGoods();
				orderGoods.setGoodName(orderDetail.getCommodityName());
				orderGoods.setNum(orderDetail.getQuantity());
				orderGoods.setPrice(orderDetail.getUnitPrice());
			}
			mDto.setGoods(goodsList);
		}
		
		return myOrderDTOs;
	}

}
