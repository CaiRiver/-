package com.cai.mall.constants;

import redis.clients.jedis.Jedis;

public class Constants {
	/*
	 * address中字段status的状态
	 * 1-可用 2-不可用
	 */
	public static final Integer ENABLESTATUS = 1;
	public static final Integer UNABLESTATUS = 2;
	//TODO vo 在service层 避免用DO 来直接接收
	
	/*
	 * mall_commodity中字段status
	 * 1-上架 2-下架
	 * 
	 */
	public static final Integer ONSELLSTATUS = 1;
	public static final Integer OFFSELLSTATUS = 2;
	
	/*
	 * mall_order中order_from 订单来源
	 * 1-来自立即购买 2-来自购物车
	 * 
	 */
	public static final Integer FROMBUYING = 1;
	public static final Integer FROMSHOPPINGTROLLEY = 2;
	
	/*
	 * mall_order中status 
	 * 状态 0-待付款 1-已付款 2-失效 3-取消
	 */
	public static final Integer WAITTOPAY = 0;
	public static final Integer ALREADYPAY = 1;
	public static final Integer OUTOFTIME = 2;
	public static final Integer CANCEL = 3;
	
	public static void main(String[] args) {
		Jedis jedis = null;
		try {
			jedis = new Jedis("192.168.31.167", 6379);
			System.out.println(jedis.get("test:redis"));
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	
		
	}
}
