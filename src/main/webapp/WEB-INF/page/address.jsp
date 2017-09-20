<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="utf-8" />
		<title>最家</title>
		<link rel="stylesheet" type="text/css" href="/css/public.css"/>
		<link rel="stylesheet" type="text/css" href="/css/mygxin.css" />
		<link rel="stylesheet" type="text/css" href="/css/jquery-ui-css.css" />
	</head>
	<body>
		<!------------------------------head------------------------------>
		<jsp:include page="common/header.jsp"></jsp:include>
		<!------------------------------idea------------------------------>
		<div class="address mt">
			<div class="wrapper clearfix">
				<a href="index.html" class="fl">首页</a>
				<span>/</span>
				<a href="mygxin.html">个人中心</a>
				<span>/</span>
				<a href="address.html" class="on">地址管理</a>
			</div>
		</div>
		
		<!------------------------------Bott------------------------------>
		<div class="Bott">
			<div class="wrapper clearfix">
				<jsp:include page="common/leftMenu.jsp"></jsp:include>
				<div class="you fl" id="addreShow">
					<h2>收货地址</h2>
					<div class="add">
						<div>
							<a href="#2" id="addxad"><img src="/img/jia.png"/></a>
							<span>添加新地址</span>
						</div>
					</div>
					<div class="add" v-for="(address, index) in addresses">
						<div>
							<p>{{address.realName}}</p>
							<p>{{address.cellPhone}}</p>
							<p>{{address.provinceCharacter}}{{address.cityCharacter}}{{address.areaCharacter}}</p>
							<p>{{address.detailedAddress}}</p>
							<span v-on:click="modifyAddress(index)">修改</span>
							<span v-on:click="deleteAddress(index)">删除</span>
						</div>
						
					</div>
						
							
				</div>
			</div>
		</div>
		<!--编辑弹框-->
		<!--遮罩-->
		<div class="mask"></div>
		<div class="adddz">
			<form action="#" method="get">
				<input type="text" placeholder="姓名" class="on" id="realName"/>
				<input type="text" placeholder="手机号" id="phoneNum"/>
				<div class="city">
					<select name="" id="addProvince" onchange="listCity();">
						<option value="x">省份/自治区</option>
					</select>
					<select name="" id="addCity" onchange="listArea();">
						<option value="xx">城市/地区</option>
					</select>
					<select name="" id="addArea">
						<option value="xxx">区/县</option>
					</select>
				</div>
				默认地址：<br>
				否:<input type="radio" id="xx" name="isDefault" value="0" style="width: 20px;height: 20px">
				是:<input type="radio" id="xxx" name="isDefault" value="1" style="width: 20px;height: 20px">
				<textarea name="" rows="" cols="" placeholder="详细地址" id="detailAddress"></textarea>
				<div class="bc">
					<input type="button" value="保存" id="save"/>
					<input type="button" value="取消" />
				</div>
			</form>
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
			<a href="#" class="toptop" style="display: none">
			<dl>
				<dt><img src="/img/gt4.png"/></dt>
				<dd>返回<br />顶部</dd>
			</dl>
			</a>
			<p>400-800-8200</p>
		</div>
		
		
		
		
		<div id="del-confirm" title="删除地址">
			
		</div>
		
		<!--footer-->
		<jsp:include page="common/footer.jsp"></jsp:include>
		
		
		<script type="text/javascript" src="/js/jquery-mini.js"></script>
		<script type="text/javascript" src="/js/vue.min.js"></script>
		<script type="text/javascript" src="/js/jquery-ui-js.js"></script>
		<script type="text/javascript">
			var actionFlag = false;
			var modifyAddressId = -1; 
			var delAddressIndex = -1;
			var showAddress = {};
			
			$(document).ready(function() {
				
				showAddress = new Vue({
					el : '#addreShow',
					data : {
						addresses : []
					},
					methods : {
						modifyAddress : function(index) {
							$('.mask').show();
							$('.adddz').show();
							var address = this.addresses[index];
							initModify(address);
							actionFlag = false;
							
						},
					
						deleteAddress : function (index) {
							var address = this.addresses[index];
							delAddressIndex = index;
							$('#del-confirm').html(address.realName + '-' + address.phoneNum);
							$( "#del-confirm" ).dialog( "open" );
						}
					}
				});
				
				$('#addxad').click(function(){
					initAddAddress();
					$('.mask').show();
					$('.adddz').show();
					listProvince();
					actionFlag = true;
				});
				
				$('.bc>input').click(function(){
					$('.mask').hide();
					$('.adddz').hide();
				});
				
				$('#save').click(function(){
					choseAction();
				});
				
				listAddress();
				initDelDialog();
			});
			
			function initDelDialog() {
			    $( "#del-confirm" ).dialog({
			        resizable: false,
			        height:140,
			        modal: true,
			        autoOpen: false,
			        buttons: {
			          "删除": function() {
			           del();
			           $( this ).dialog( "close" );
			          },
			          "取消": function() {
			           $( this ).dialog( "close" );
			          }
			        }
			      });
			}
			
			function del() {
				var delAdd = showAddress.addresses[delAddressIndex];
				
				$.ajax({
		            url:'/address/delete.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
		            data:{
		            	addressId : delAdd.id
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
		            	 
		            	 alert('success');
		            	 //loadAddress();
		            	 showAddress.addresses.splice(delAddressIndex, 1);
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
			
			function choseAction() {
				if (actionFlag) {
					add();
				} else {
					modifyAddress();
				}
			}
			
			function initModify(address) {
				listProvince();
				$('#realName').val(address.realName);
				$('#phoneNum').val(address.cellPhone);
				$('#addProvince').val(address.provinceCode);
				listCity();
				$('#addCity').val(address.cityCode);
				listArea();
				$('#addArea').val(address.areaCode);
				$('#detailAddress').val(address.detailedAddress);
				
				if (1 === address.isDefault) {
					$('input:radio[name="isDefault"][value="1"]').prop('checked', true);
				} else {
					$('input:radio[name="isDefault"][value="0"]').prop('checked', true);
				}
				
				
				modifyAddressId = address.id;
			}
			
			function initAddAddress() {
				$('#realName').val('');
				$('#phoneNum').val('');
				$('#addProvince').val('x');
				$('#addCity').val('xx');
				$('#addArea').val('xxx');
				$('#detailAddress').val('');
				
			}
			
			function modifyAddress() {
				$.ajax({
		            url:'/address/modify.do',
		            type:'POST', //GET
		            async:true,    //或false,是否异步
		            data:{
		            	realName : $('#realName').val(),
		            	phoneNum : $('#phoneNum').val(),
						provinceCode : $('#addProvince').val(),
						cityCode : $('#addCity').val(),
						areaCode : $('#addArea').val(),
		            	detailAddress : $('#detailAddress').val(),
		            	isDefault : $('input:radio[name="isDefault"]:checked').val(),
		            	addressId : modifyAddressId
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
		                 
		            	 alert("success");
		            	 listAddress();
		               
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
			
			function listAddress() {
				$.ajax({
		            url:'/address/listAddress.do',
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
		                 
		            	 showAddress.addresses = data.data;
		               		
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
			
			function add() {
				$.ajax({
		            url:'/address/add.do',
		            type:'POST', //GET
		            async:true,    //或false,是否异步
		            data:{
		            	realName : $('#realName').val(),
		            	phoneNum : $('#phoneNum').val(),
						provinceCode : $('#addProvince').val(),
						cityCode : $('#addCity').val(),
						areaCode : $('#addArea').val(),
		            	detailAddress : $('#detailAddress').val(),
		            	isDefault : $('input:radio[name="isDefault"]:checked').val()
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
		                 
		            	 alert("success");
		            	 listAddress();
		               
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
			
			function listArea() {
				$.ajax({
		            url:'/address/listArea.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
		            data:{
		            	cityCode : $('#addCity').val()
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
		                 
		                var results = data.data;
		                var msg = '<option value="区/县">区/县</option>';
		               	for (var i=0; i<results.length; i++) {
		               		var area = results[i];
		               		msg += '<option value="'+area.code+'">'+ area.name+'</option>'; 
		               	}
		               	
		               	$('#addArea').html(msg);
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
			
			function listCity() {
				$.ajax({
		            url:'/address/listCity.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
		            data:{
		            	provinceCode:$('#addProvince').val()
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
		                 
		                var results = data.data;
		                var msg = '<option value="城市/地区">城市/地区</option>';
		               	for (var i=0; i<results.length; i++) {
		               		var city = results[i];
		               		msg += '<option value="'+city.code+'">'+ city.name+'</option>'; 
		               	}
		               	
		               	$('#addCity').html(msg);
		               	$('#addArea').html('<option value="区/县">区/县</option>');
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
			
			
			function listProvince() {
				$.ajax({
		            url:'/address/listProvince.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
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
		                 
		                var results = data.data;
		                var msg = '';
		               	for (var i=0; i<results.length; i++) {
		               		var pro = results[i];
		               		msg += '<option value="'+pro.code+'">'+ pro.name+'</option>'; 
		               	}
		               	
		               	$('#addProvince').append(msg);
		               	
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
