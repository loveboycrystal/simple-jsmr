<%@ page language="java" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Restful login</title>
<link rel="stylesheet" href="<%= basePath %>css/login/login.css"/>
<script type="text/javascript" src="<%= basePath %>weblib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%= basePath %>weblib/vue/vue.min.js"></script>
<script type="text/javascript" src="<%= basePath %>weblib/secretJs/jbase64.js"></script>
<script type="text/javascript" src="<%= basePath %>weblib/layer3.0/layer.js"></script>
<script type="text/javascript" src="<%= basePath %>weblib/common/const.js"></script>

</head>
<body>
<div class="container">
	<section id="content">
		<form action="ajax">
			<h1>Welcome Login</h1>
			<div>
				<input type="text" placeholder="Username" v-model="username"  required="" id="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" v-model="password"/>
			</div>
			<div>
				<input type="button" class="fromSubmit" value="Log in" v-on:click="toLogin"/>
				<a href="#">Lost your password?</a>
				<a href="#">Register</a>
			</div>
		</form><!-- form -->
		<div class="button">
			<a href="#">@copyright netvour restful test login </a>
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->

<script type="text/javascript">
http://192.168.0.130:8080/eg_manage/demo/login/touloginGrnCard/?paramsJson=eyJ1c2VyQWNjb3VudCI6ImNoZW5lcyIsInVzZXJQd2QiOiIxMTExMTEifQ==
   new Vue({
      el:'#content',
      data:{
    	  loginUrl : '<%= basePath %>demo/login/touloginGrnCard/',
    	  data:"",
    	  username : "chenes",
    	  password : "111111"
       },
       methods :{
    	   toLogin : function(){
    		   var vm = this;
    		   var base64 = BASE64.encoder(vm.username);//返回编码后的字符  
    		   var unicode= BASE64.decoder(base64);//返回会解码后的unicode码数组。  
    		   var tmpInfo = BASE64.encoder('{"userAccount":"'+vm.username+'","userPwd":"'+vm.password+'"}');
    		   $.ajax({
                   url: vm.loginUrl,
                   type: 'GET',
                   dataType: 'json',
                   data: {paramsJson:tmpInfo},
                   success: function(data) {
                      // vm.msg = '注册成功！'
	                      if(data.resCode == Const.SUCCESS){
	                    	  layer.msg("登录成功,系统正在跳转中...");
		                      setTimeout(function(){
				                      window.location.href = "view/bossList.jsp";
		                      },1000);
	                      }else{
	                    	  layer.msg(data.resMsg);
	                      }
                   }
               })
    	   }
    	   
       },
      created:function(){
    	 /* 
        var url="json.jsp";
        var _self=this;
        $.get(url,function(data){
          _self.data=eval("(" + data +")");
        })
        this.$http.get(url).then(function(data){
          var json=data.body;
          this.data=eval("(" + json +")");
        },function(response){
          console.info(response);
        })*/
      }
     });
  </script>
</body>
</html>