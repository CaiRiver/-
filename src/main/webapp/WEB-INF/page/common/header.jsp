<%@page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="head ding">
			<div class="wrapper clearfix">
				<div class="clearfix" id="top">
					<h1 class="fl"><a href="/index.jsp"><img src="/img/logo.png"/></a></h1>
					<div class="fr clearfix" id="top1">
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
							
						</div>
						<form action="#" method="get" class="fl">
							<input type="text" placeholder="搜索" />
							<input type="button" />
						</form>
						<div class="btn fl clearfix">
							<a href="mygxin.html"><img src="/img/grzx.png"/></a>
							<a href="#" class="er1"><img src="/img/ewm.png"/></a>
							<a href="/cart/goToCart.do"><img src="/img/gwc.png"/></a>
							<p><a href="#"><img src="/img/smewm.png"/></a></p>
						</div>
					</div>
				</div>
					
			</div>
		</div>