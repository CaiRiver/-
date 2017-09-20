
<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" >
	<title>京西(JX.COM)-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
	<link rel="stylesheet" href="/registCss/reset.css" type="text/css">
	<link rel="stylesheet" href="/registCss/style.css" type="text/css">
</head>
<body>
<div id="head">
	<div class="wrap">
		<div class="logo">
			<a href="#"><img src="/registImages/logo.png" alt="京西商城"></a>
		</div>
		<h3>欢迎注册</h3>
	</div>
</div>
<div class="register">
	<form id="registForm">
	<ul class="register_box">
		<li class="user_info"><span><b>*</b>账户名：</span><input type="text" id="username" name="username" placeholder="邮箱/用户名/手机号" class="login_name"></li>
		<li class="user_info"><span><b>*</b>请设置密码：</span><input type="password" id="password" name="password" class="login_password"></li>
		<li class="user_info"><span><b>*</b>其确认密码：</span><input type="password" id="confirmPassword" name="confirmPassword" class="login_password"></li>
		
		<li class="user_info"><span><b>*</b>验证码：</span><input type="text" id="code" name="code" class="login_password"></li>
		
		<li></li>
		<li><img id="codeImg" alt="" src="/code/create.do" onclick="createImg();"></li>
		
		<li class="user_info"><span><b>*</b> 邮箱：</span><input type="text" id="email" name="email"></li>
		<li class="user_info"><span><b>*</b> 地址：</span><input type="text" id="address" name="mail"></li>
		<li class="user_info"><span><b>*</b> 手机：</span><input type="text" id="phoneNum" name="phoneNum"></li>
		<li class="user_info"><span><b></b> 生日：</span><input type="text" id="birthday" name="birthday"></li>
		<li class="user_info"><span><b></b> 性别：</span><input type="text" id="sex" name="sex"></li>
		<li class="agree"><input type="checkbox" checked="checked" id="agreement"><label for="agreement">我已阅读并同意</label><a href="#">《用户注册协议》</a></li>
		<li class="submit"><input type="button" value="提交" onclick="regist();" class="submit_btn"></li>
	</ul>
	</form>
</div>
<div id="footer">
	<p>慕课简介|慕课公告| 招纳贤士| 联系我们|客服热线：400-675-1234</p>
	<p>Copyright © 2006 - 2014 慕课版权所有   京ICP备09037834号   京ICP证B1034-8373号   某市公安局XX分局备案编号：123456789123</p>
	<div class="credit_rating">
		<a href="#"><img src="/registImages/pj.jpg" alt="信用评价"></a>
		<a href="#"><img src="/registImages/pj.jpg" alt="信用评价"></a>
		<a href="#"><img src="/registImages/pj.jpg" alt="信用评价"></a>
		<a href="#"><img src="/registImages/pj.jpg" alt="信用评价"></a>
	</div>
</div>

 <script type="text/javascript" src="/js/jquery-mini.js"></script>
    <script type="text/javascript" src="/js/jquery-validate.min.js"></script>
	<script type="text/javascript" src="/js/messages_zh.js"></script>
    <script type="text/javascript">
    
    function createImg() {
    	var token = Date.parse(new Date())/1000;
    	$("#codeImg").attr("src", "/code/create.do?" + token);
    }
    
    $(document).ready(function() {
    	$("#registForm").validate({
    	    rules: {
    	    	username: "required",
    	    	password: {
    		        required: true,
    		        minlength: 1,
    		        maxlength: 6
    		      },
		    	confirmPassword: {
			        required: true,
			        minlength: 1,
			        maxlength: 6
			      }
    	    },
    	    messages: {
    	    	username: "请输入用户名",
    	    	password: {
    	    		required : "请输入密码",
    	    		minlength : "密码最小长度为1",
    	    		maxlength : "密码最大长度为6"
    	    	},
    	    confirmPassword: {
		    		required : "请输入确认密码",
		    		minlength : "密码最小长度为1",
		    		maxlength : "密码最大长度为6"
		    	}
    	    }
    	});
    });
    
    function regist() {
    	
    	
    	
    	if (!$("#registForm").valid()) {
    		return false;
    	}
    	
    	$.ajax({
            url:'/user/regist.do',
            type:'POST', //GET
            async:true,    //或false,是否异步
            data:{
            	username:$('#username').val(),
            	password:$('#password').val(),
            	confirmPassword:$('#confirmPassword').val(),
            	code:$('#code').val(),
            	email:$('#email').val(),
            	phoneNum:$('#phoneNum').val(),
            	birthday:$('#birthday').val(),
            	sex:$('#sex').val()
            },
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend:function(xhr){
                console.log(xhr)
                console.log('发送前')
            },
            success:function(data,textStatus,jqXHR){
                var obj = data;
                alert(obj.success);
                
                if (!data.success) {
                	alert(data.message);
                	createImg();
                	return;
                }
                
                window.location.href='/user/toLogin.do';
                
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