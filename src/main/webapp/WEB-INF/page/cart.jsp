<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="utf-8" />
		<title>cart</title>
		<link rel="stylesheet" type="text/css" href="/css/public.css"/>
		<link rel="stylesheet" type="text/css" href="/css/proList.css" />
	</head>
	<body>
		<!--------------------------------------cart--------------------->
		
		<div class="cart mt">
			<!-----------------logo------------------->
			<!--<div class="logo">
				<h1 class="wrapper clearfix">
					<a href="index.html"><img class="fl" src="/img/temp/logo.png"></a>
					<img class="top" src="/img/temp/cartTop01.png">
				</h1>
			</div>-->
			<!-----------------site------------------->
			<div class="site">
				<p class=" wrapper clearfix">
					<span class="fl">购物车</span>
					<img class="top" src="/img/temp/cartTop01.png">
					<a href="/" class="fr">继续购物&gt;</a>
				</p>
			</div>
			<!-----------------table------------------->
			<div class="table wrapper">
				<div class="tr">
					<div>商品</div>
					<div>单价</div>
					<div>数量</div>
					<div>小计</div>
					<div>操作</div>
				</div>
				
				<div id="cartShow">
						<div class="th" v-for = "(arrayComponent, index) in category">
							<div class="pro clearfix" >
								<label class="fl">
									<input type="checkbox" v-bind:id="index" v-on:click="commodityChecked"/>
		    						<span></span>
								</label>
								<a class="fl" href="#">
									<dl class="clearfix">
										<dt class="fl"><img src="/img/temp/cart01.jpg"></dt>
										<dd class="fl">
											<p>{{arrayComponent.commodity.name}}</p>
											<p>颜色分类:</p>
											<p>白色瓷瓶+白色串枚</p>
										</dd>
									</dl>
								</a>
							</div>
							<div class="price">￥{{arrayComponent.commodity.unitPrice}}</div>
							<div class="number">
								<p class="num clearfix">
									<img class="fl sub" src="/img/temp/sub.jpg" v-on:click="subCount(index)">
									<span class="fl">{{arrayComponent.shoppingTrolleyDTO.purchaseNum}}</span>
									<img class="fl add" src="/img/temp/add.jpg" v-on:click="plusCount(index)">
								</p>
							</div>
							<div class="price sAll">￥20.00</div>
							<div class="price"><a class="del" href="#2">删除</a></div>
						</div>
				
				
				
					<div class="goOn">空空如也~<a href="index.html">去逛逛</a></div>
					<div class="tr clearfix">
						<label class="fl">
							<input class="checkAll" type="checkbox" id="selectAll" onclick="selectAll();"/>
							<span></span>
						</label>
						<p class="fl">
							<a href="#" >全选</a>
							<a href="#" class="del">删除</a>
						</p>
						<p class="fr">
							<span>共<small id="sl">0</small>件商品</span>
							<span>合计:&nbsp;<small id="totalAmount">￥0.00</small></span>
							<a href="###" class="count" onclick="settlement();">结算</a>
						</p>
				
					</div>
				</div>
			</div>
		</div>
		<div class="mask"></div>
		<div class="tipDel">
			<p>确定要删除该商品吗？</p>
			<p class="clearfix">
				<a class="fl cer" href="#">确定</a>
				<a class="fr cancel" href="#">取消</a>
			</p>
		</div>
		<!--返回顶部-->
		<div class="gotop">
			<a href="cart.html">
			<dl>
				<dt><img src="/img/gt1.png"/></dt>
				<dd>去购<br />物车</dd>
			</dl>
			</a>
			<a href="#" class="dh">
			<dl>
				<dt><img src="/img/gt2.png"/></dt>
				<dd>联系<br />客服</dd>
			</dl>
			</a>
			<a href="mygxin.html">
			<dl>
				<dt><img src="/img/gt3.png"/></dt>
				<dd>个人<br />中心</dd>
			</dl>
			</a>
			<a href="#" class="toptop" style="display: none;">
			<dl>
				<dt><img src="/img/gt4.png"/></dt>
				<dd>返回<br />顶部</dd>
			</dl>
			</a>
			<p>400-800-8200</p>
		</div>
		
		
		
		<!--footer-->
		<div class="footer">
			<div class="top">
				<div class="wrapper">
					<div class="clearfix">
						<a href="#2" class="fl"><img src="/img/foot1.png"/></a>
						<span class="fl">7天无理由退货</span>
					</div>
					<div class="clearfix">
						<a href="#2" class="fl"><img src="/img/foot2.png"/></a>
						<span class="fl">15天免费换货</span>
					</div>
					<div class="clearfix">
						<a href="#2" class="fl"><img src="/img/foot3.png"/></a>
						<span class="fl">满599包邮</span>
					</div>
					<div class="clearfix">
						<a href="#2" class="fl"><img src="/img/foot4.png"/></a>
						<span class="fl">手机特色服务</span>
					</div>
				</div>
			</div>
			<p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br />
			违法和不良信息举报电话：188-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
		</div>
		<!----------------mask------------------->
		<div class="mask"></div>
		<!-------------------mask内容------------------->
		<div class="proDets">
			<img class="off" src="/img/temp/off.jpg" />
			<div class="proCon clearfix">
				<div class="proImg fr">
					<img class="list" src="/img/temp/proDet.jpg"  />
					<div class="smallImg clearfix">
						<img src="/img/temp/proDet01.jpg" data-src="/img/temp/proDet01_big.jpg">
						<img src="/img/temp/proDet02.jpg" data-src="/img/temp/proDet02_big.jpg">
						<img src="/img/temp/proDet03.jpg" data-src="/img/temp/proDet03_big.jpg">
						<img src="/img/temp/proDet04.jpg" data-src="/img/temp/proDet04_big.jpg">
					</div>
				</div>
				<div class="fl">
					<div class="proIntro change">
						<p>颜色分类</p>
						<div class="smallImg clearfix">
							<p class="fl on"><img src="/img/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花" data-src="/img/temp/proBig01.jpg"></p>
							<p class="fl"><img src="/img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草" data-src="/img/temp/proBig02.jpg"></p>
							<p class="fl"><img src="/img/temp/prosmall03.jpg" alt="20支快乐花" data-src="/img/temp/proBig03.jpg"></p>
							<p class="fl"><img src="/img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="/img/temp/proBig04.jpg"></p>
						</div>
					</div>
					<div class="changeBtn clearfix">
						<a href="#2" class="fl"><p class="buy">确认</p></a>
						<a href="#2" class="fr"><p class="cart">取消</p></a>
					</div>
				</div>
			</div>
		</div>
		<div class="pleaseC">
			<p>请选择宝贝</p>
			<img class="off" src="/img/temp/off.jpg" />
		</div>
		
	
	
<script type="text/javascript" src="/js/json2.js"></script>
<script type="text/javascript" src="/js/jquery-mini.js"></script>
<script type="text/javascript" src="/js/vue.min.js"></script>
<script type="text/javascript" charset="utf-8">

var cartShow = {};	
 	$(document).ready(function(){
 		cartShow = new Vue({
 			el : '#cartShow',
 			data : {
 				category : [
 	 				]
 			},
 			
	 		
 			
 			methods : {
				plusCount : function(index) {
					var cg = cartShow.category[index];
					cg.shoppingTrolleyDTO.purchaseNum += 1;
					countAmount();
					
				},
				
				subCount : function(index) {
	 				
	 				var cg = cartShow.category[index];
	 				if (cg.shoppingTrolleyDTO.purchaseNum <= 1) {
	 					return;
	 				}
					cg.shoppingTrolleyDTO.purchaseNum -= 1;
					countAmount();
				},
	 			
	 			commodityChecked : function() {
	 				countAmount();
	 			}
			}
 			
 		});
 		
 		listCart();
 	});
	
 	function settlement() {
 		var buyCommodityArray = [];
 		
 		$('.th :checkbox').each(function() {
 			if ($(this).is(':checked')) {
 				var index = $(this).attr('id');
 				var shoppingTrolleyDTO = cartShow.category[index].shoppingTrolleyDTO;
 				buyCommodityArray.push({commodityId : shoppingTrolleyDTO.commodityId, purchaseNum : shoppingTrolleyDTO.purchaseNum});
 			}
 		});
 		
 		var msg = JSON.stringify(buyCommodityArray);
		
 		
		alert(msg);
		$.ajax({
            url:'/order/createOrder4JsonBody.do',
            type:'POST', //GET
            async:true,    //或false,是否异步
            contentType:"application/json",
            data:msg,
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend:function(xhr){
                console.log(xhr)
                console.log('发送前')
            },
            success:function(data,textStatus,jqXHR){
                
                if (!data.success) {
                	alert(data.message);
                	return;
                }
                
                alert('success');
             data.data.id;
              	window.location.href='/order/toOrder.do?orderId=' + data.data.id;
            },
            error:function(xhr,textStatus){
                console.log('错误')
                console.log(xhr)
                console.log(textStatus)
            },
            complete:function(){
                console.log('结束')
            }
        });
 	
 	}
 	
 	function countAmount() {
 		var commodityArray = [];
 		$('.th :checkbox').each(function() {
 			if ($(this).is(':checked')) {
 				var attrValue = $(this).attr('id');
 				commodityArray.push(attrValue);
 			}
 		});
 		
 		var total = 0;
 		for (var i=0; i<commodityArray.length; i++) {
 			var index = commodityArray[i];
 			var arrayElement = cartShow.category[index];
 			var price = arrayElement.commodity.unitPrice;
 			var num = arrayElement.shoppingTrolleyDTO.purchaseNum;
 			total += price * num;
 		}
 		$('#totalAmount').html(total);
 	}
 	
 	 function selectAll() {
 		 
 		   $('.th :checkbox').each(function () {
 			   if ($('#selectAll').is(':checked')) {
 				   $(this).prop('checked', true);
 			   } else {
 				   $(this).prop('checked', false);
 			   }
 		   });
 		   
 		  countAmount();
 	   }
 	
 	
 	function listCart() {
		$.ajax({
            url:'/cart/listCart.do',
            type:'POST', //GET
            async:true,    //或false,是否异步
            data:{
            },
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend:function(xhr){
                console.log(xhr)
                console.log('发送前')
            },
            success:function(data,textStatus,jqXHR){
                
                if (!data.success) {
                	alert(data.message);
                	return;
                }
                cartShow.category = data.data;
               
            },
            error:function(xhr,textStatus){
                console.log('错误')
                console.log(xhr)
                console.log(textStatus)
            },
            complete:function(){
                console.log('结束')
            }
        });
	}
           
 	</script>	
	
	</body>

	
</html>
