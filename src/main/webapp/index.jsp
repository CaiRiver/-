<%@page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" >
	<title>京西(JX.COM)-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
	<link rel="stylesheet" href="css/reset.css" type="text/css">
	<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<div id="head">
	<div class="head_top">
		<div class="wrap clearfix">
			<div class="leftArea">
				<a href="#" id="collection">收藏京西</a>
			</div>
			<div class="rightArea">
				<h5>欢迎来到京西网！</h5>
				<c:if test="${empty login_user}">
					<a href="/user/toLogin.do">[登录]</a>
					 <a href="/user/toRegist.do">[免费注册]</a>
				</c:if>
				
				<c:if test="${not empty login_user}">  
				    	 吨精的拥护：<h1>${login_user.username}</h1>
				     <a href="/user/logout.do">[注销]</a>
				    
				     
				</c:if>  
				 <a href="/cart/goToCart.do">[购物车赶紧区结账了]</a>
				
			</div>
		</div>
	</div>
	<div class="search">
		<div class="wrap">
			<div class="logo">
				<a href="#"><img src="images/logo.png" alt="京西商城"></a>
			</div>
			<div class="search_box">
				
			</div>
			<div class="shop_car">
				
			</div>
		</div>
	</div>
	
	<div class="banner">
		<div class="wrap clearfix">
			
		</div>
	</div>
</div>
<div id="goodShow">
	<div class="shopArea" v-for = "arrayComponent in category">
	<div class="wrap">
		<div class="shop_title">
			<h3>{{arrayComponent.typename}}</h3>
			<span>更多&gt;&gt;</span>
		</div>
		<div class="main clearfix">
			<div class="shop_banner">
				<img src="images/ad01.jpg" alt="shop_banner">
			</div>
			<div class="shop_list">
				<div class="shoplist_box clearfix">
					<div class="shopItem_top" v-for="(good, index) in arrayComponent.goods" v-if="index < 4">
						<div class="shop_img" >
						<a v-bind:href="'/commodity/toIntroduce/' + good.id +'.do'" target="">
							<img src="images/HTC.jpg" alt="商品">
						</a>
						
						</div>
						<h4>{{good.name}}</h4>
						<p>{{good.unitPrice}}元</p>
					</div>
					
					<div class="shopItem_bottom" v-for="(good, index) in arrayComponent.goods" v-if="index >= 4">
						<div class="shop_img">
						
						<a v-bind:href="'/xxx/xx.do?goodid=' + good.id" target="">
							<img src="images/NFC.jpg" alt="商品">
						</a>
						
						</div>
						<div class="shop_text">
							<p>{{good.name}}</p>
							<span>{{good.unitPrice}}￥</span>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>
</div>


<div id="footer">
	<p>慕课简介|慕课公告| 招纳贤士| 联系我们|客服热线：400-675-1234</p>
	<p>Copyright © 2006 - 2014 慕课版权所有   京ICP备09037834号   京ICP证B1034-8373号   某市公安局XX分局备案编号：123456789123</p>
	<div class="credit_rating">
		<a href="#"><img src="images/pj.jpg" alt="信用评价"></a>
		<a href="#"><img src="images/pj.jpg" alt="信用评价"></a>
		<a href="#"><img src="images/pj.jpg" alt="信用评价"></a>
		<a href="#"><img src="images/pj.jpg" alt="信用评价"></a>
	</div>
</div>

<script type="text/javascript" src="/js/jquery-mini.js"></script>
<script type="text/javascript" src="/js/vue.min.js"></script>
<script type="text/javascript" charset="utf-8">
var goodShow = {};	
 	$(document).ready(function(){
 		goodShow = new Vue({
 			el : '#goodShow',
 			data : {
 				category : [
 				]
 				
 			}
 		});
 		
 		listTypes();
 	});
	
 	
 	function listTypes() {
		$.ajax({
            url:'/goods/listGoods.do',
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
                
                goodShow.category = data.data;
               
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
