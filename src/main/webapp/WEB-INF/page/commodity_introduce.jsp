<%@page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" >
	<title>京西(JX.COM)-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
	<link rel="stylesheet" href="/introduceCss/reset.css" type="text/css">
	<link rel="stylesheet" href="/introduceCss/style.css" type="text/css">
</head>
<body class="grey">

		<div class="wrap clearfix">
			<div class="leftArea">
				<a href="#" id="collection">收藏京西</a>
			</div>
			<div class="rightArea">欢迎来到京西网！
			<c:if test="${empty login_user}">
					<a href="/user/toLogin.do">[登录]</a>
					 <a href="/user/toRegist.do">[免费注册]</a>
				</c:if>
				
				<c:if test="${not empty login_user}">  
				   	 吨精的拥护：<h1>${login_user.username}</h1>
				     <a href="/user/logout.do">[注销]</a>
				</c:if>  
			
		</div>
	</div>
	<div class="search">
		<div class="wrap">
			<div class="logo">
				<a href="#"><img src="/introduceImages/logo.png" alt="京西商城"></a>
			</div>
			<div class="search_box">
				
			</div>
			<div class="shop_car">
				
			</div>
		</div>
	</div>
	<div class="bread wrap"><a class="index" href="/index.jsp">首页</a><em>&gt;</em><a href="#">平板电脑</a>&gt;<a href="#">Apple 苹果</a>&gt;<a href="#">MD531CH/A</a></div>
<div>
	
	<div class="commodity_info wrap clearfix">
	<div class="info_left">
		<div class="commodity_img"><img src="/introduceImages/sp.jpg" alt="商品图片"></div>
		<ul class="clearfix">
			<li class="imgOn"><img src="/introduceImages/img_list.jpg" alt="缩略图"></li>
			<li><img src="/introduceImages/img_list.jpg" alt="缩略图"></li>
			<li><img src="/introduceImages/img_list.jpg" alt="缩略图"></li>
			<li><img src="/introduceImages/img_list.jpg" alt="缩略图"></li>
			<li><img src="/introduceImages/img_list.jpg" alt="缩略图"></li>
		</ul>
	</div>
	
	<div class="info_right">
		<h3 class="shop_name" id="shopName"></h3>
		<dl class="price">
			<dt>京西价</dt>
			<dd id="commodityPrice"><b>￥</b></dd>
		</dl>
		<dl class="favourable">
			<dt>优惠</dt>
			<dd><span>满换购</span>购ipad加价优惠够配件或USB充电插座</dd>
		</dl>
		<div class="selection">
			<dl class="address">
				<dt>送到</dt>
				<dd><h3>北京市 海淀区 五环内<i></i></h3>有货，可当日出库</dd>
			</dl>
			<dl class="color_select">
				<dt>选择颜色</dt>
				<dd class="clearfix"><a class="active" href="#">白色</a><a href="#">黑色</a><a href="#">灰色</a></dd>
			</dl>
			<dl class="specification">
				<dt>选择规格</dt>
				<dd class="clearfix"><a class="active" href="#">WIFI 16G</a><a href="#">WIFI 64G</a><a href="#">WIFI 32G</a><a href="#">WIFI Cellular 64G</a><a href="#">WIFI Cellular 32G</a><a href="#">WIFI Cellular 16G</a>
				</dd>
			</dl>
			<dl>
				<dt>数量</dt>
				<dd class="clearfix">
					<div class="num_select">
						<span>-</span>
						<input type="text" value="1" id="purchaseNum" name="purchaseNum">
						<span>+</span>
					</div>
					<span class="limit_num">限购<b>9</b>件</span>
				</dd>
			</dl>
		</div>
		<div class="buy">
			<h4 class="selected">已选择<span>“白色|WIFI 16G”</span></h4>
			<div class="buy_btn">
				<a href="#" onclick="intoCart();">加入购物车</a>
				<span class="ver_line"></span>
				<a href="#">立即购买</a>
			</div>
			<p class="notice">注意：此商品可提供普通发票，不提供增值税发票。</p>
		</div>
	</div>
</div>
</div>
<div class="main wrap clearfix">
	<div class="main_left">
		<div class="same_price">
			<h3>同价位</h3>
			<div class="same_item">
				<div class="img_box"><img src="/introduceImages/same_item.jpg" alt="同价位"></div>
				<p>Samsung 三星 GALAXY Tab 3 8.0 WLAN版本 T310平板电话</p>
				<span>￥3588.00</span>
			</div>
			
		</div>
		<div class="recommend">
			<h3>看了最终买</h3>
			<div class="same_item">
				<div class="img_box"><img src="/introduceImages/same_item.jpg" alt="同价位"></div>
				<p>Samsung 三星 GALAXY Tab 3 8.0 WLAN版本 T310平板电话</p>
				<span>￥3588.00</span>
			</div>
			
		</div>
	</div>
	<div class="main_right">
		<div class="main_tab clearfix">
				<h4 class="product_intro">产品介绍</h4>
				<h4 class="product_review active">商品评价</h4>
		</div>
		<div class="intro_comment">
			<div class="intro_img"><img src="/introduceImages/introduce_01.jpg" alt="开春盛典"></div>
			<div class="introduce_text">
				<div class="introduce_title">
					<h4>强烈推荐</h4>
					<span>货比三家，还选</span>
				</div>
				<p>现在就是买mini的好时候！换代清仓直降，但苹果品质不变！A5双核，内置Lightning闪电接口，正反可插，方便人性。小身材，炫丽的7.9英寸显示屏，7.2mm的厚度，薄如铅笔。女生包包随身携带更时尚！facetime视频通话，与密友24小时畅聊不断线。微信倾力打造，你的智能助理。苹果的牌子就不用我说了，1111补仓，存货不多哦！</p>
			</div>
			<div class="introduce_text">
				<div class="introduce_title">
					<h4>精美图片</h4>
				</div>
				<p>苹果iPad7.9 英寸显示屏可带来新的iPad体验，绚丽的显示屏，在每一寸画面中呈现灵动鲜活的美妙影像。<br/>苹果miniMD528CH/A采用500 万像素 iSight 摄像头，清晰记录每一次的幸福。</p>
			</div>
			<div class="intro_img"><img src="/introduceImages/introduce_02.jpg" alt="开春盛典"></div>
		</div>
		<div class="intro_comment">
			<h3>商品评价</h3>
			<div class="score_box clearfix">
				
			</div>
			<div class="review_tab">
				
			</div>
			<div class="review_box">
				<div class="review_item clearfix">
					
				</div>
				<div class="review_item clearfix">
					<div class="user_info">
						<img src="/introduceImages/user.jpg" alt="用户头像">
						<p>61***42</p>
						<p>金色会员</p>
					</div>
					<div class="review_content">
						
						<p>挺不错的，信赖京西</p>
						<a href="#">踩（0）</a><a href="#">顶（0）</a>
					</div>
				</div>
			</div>
			<div class="page clearfix">
				<div class="page_box clearfix">
					<a href="#" class="first">上一页</a>
					<a href="#" class="pageOn">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<span class="blue">…</span>
					<a href="#" class="blue">1879</a>
					<a href="#" class="blue">下一页&gt;</a>
					<span class="pageTo">到第<input type="text" value="1">页</span>
					<a href="#" class="confirm">确定</a>
				</div>
			</div>
		</div>
		<div class="consult">
			<div class="consult_title clearfix">
				<h3 class="all_consult">全部咨询</h3>
				<h3 class="express_consult">发表咨询</h3>
			</div>
			<p class="tip">提示:因厂家更改产品包装、产地或者更换随机附件等没有任何提前通知，且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</p>
			<div class="consult_box">
				<div class="consult_item clearfix">
					<div class="consult_user">
						<img src="/introduceImages/consult_user.jpg" alt="用户头像">
						<p>61***42</p>
						<p>金色会员</p>
					</div>
					<div class="consult_content">
						<h4>[商品咨询]<span class="consult_time">2014-03-07 17:41:44</span></h4>
						<p class="ask">还能再便宜点吗？</p>
						<div class="reply">
							<i></i>
							<span>京西网回复：</span>
							<p>您好，现在已经是活动价了</p>
						</div>
					</div>
				</div>
				<div class="consult_item clearfix">
					<div class="consult_user">
						<img src="/introduceImages/consult_user.jpg" alt="用户头像">
						<p>61***42</p>
						<p>金色会员</p>
					</div>
					<div class="consult_content">
						<h4>[商品咨询]<span class="consult_time">2014-03-07 17:41:44</span></h4>
						<p class="ask">还能再便宜点吗？</p>
						<div class="reply">
							<i></i>
							<span>京西网回复：</span>
							<p>您好，现在已经是活动价了</p>
						</div>
					</div>
				</div>
			</div>
			<div class="page clearfix">
				<div class="page_box clearfix">
					<a href="#" class="first">上一页</a>
					<a href="#" class="pageOn">1</a>
					<a href="#" class="blue">2</a>
					<span class="pageTo">到第<input type="text" value="1">页</span>
					<a href="#" class="confirm">确定</a>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="footer">
	
</div>
<script type="text/javascript" src="/js/jquery-mini.js"></script>
<script type="text/javascript" src="/js/vue.min.js"></script>
<script type="text/javascript" charset="utf-8">

 	var goodId='${comId}';
 	commodityIntroduce();
 
	function intoCart() {
		$.ajax({
            url:'/cart/intoCart.do',
            type:'POST', //GET
            async:true,    //或false,是否异步
            data:{
            	comId:goodId,
            	purchaseNum:$('#purchaseNum').val(),
            	
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
               	
                alert("添加购物车成功");
               
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
	
 	
 	function commodityIntroduce() {
		$.ajax({
            url:'/commodity/introduce.do',
            type:'POST', //GET
            async:true,    //或false,是否异步
            data:{
            	
            	comId:goodId,
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
                var good = data.data;
                $('#shopName').html(good.name);
                $('#commodityPrice').html(good.unitPrice);
                //$('#shopName').val(good.name);
                
                
               
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