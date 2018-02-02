<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>网威课堂管理平台</title>
		<link rel="stylesheet" href="weblib/layer3.0/layerui/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="weblib/layer3.0/layerui/css/login.css" />
	</head>

	<body class="beg-login-bg">
		<div class="beg-login-box">
			<header>
				<h1>网威课堂管理平台</h1>
			</header>
			<div class="beg-login-main">
				<form action="api/yh/sysUser/toLogin" class="layui-form" method="get">
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
						<input type="text" name="account"  lay-verify="userName" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input type="password" name="pwd" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input">
					</div>
					<div class="layui-form-item">
						<div class="beg-pull-left beg-login-remember">
							<label>记住帐号？</label>
							<input type="checkbox" name="rememberMe" value="true" lay-skin="switch" checked title="记住帐号">
						</div>
						<div class="beg-pull-right">
							<button class="layui-btn layui-btn-primary" id="tologin" lay-submit lay-filter="login">
                            <i class="layui-icon">&#xe650;</i> 登录
                        </button>
						</div>
						<div class="beg-clear"></div>
					</div>
				</form>
			</div>
			<footer>
				<p>广州市网威信息技术有限公司 @研发部</p>
			</footer>
		</div>
		<script src="weblib/layer3.0/layerui/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="weblib/layer3.0/layerui/layui/layui.js"></script>
		<script src="weblib/layer3.0/layerui/js/jbase64.js" type="text/javascript" charset="utf-8"></script>
		<script src="weblib/layer3.0/layerui/js/config.js" type="text/javascript" charset="utf-8"></script>
		<script>
			layui.use(['layer', 'form'], function() {
				var layer = layui.layer,
					$ = layui.jquery,
					form = layui.form();
					
				form.on('submit(login)',function(data){
					var logindata=data.field;
					$.ajax({
						type:"get",
						url:"api/yh/sysUser/toLogin",
						async:true,
						data:{
							paramsJson:BASE64.encoder(JSON.stringify(logindata))
						},
						success:function(data) {
							if(data.resCode==1){
								$("#tologin").attr("disabled","true");
								layer.msg("登录成功,系统进入中...");
								setTimeout(function(){
									window.location.href="index.html"
								},1000);
							}else{
								layer.msg(data.resMsg);
							}
						}
					});
					return false;
				});
			});
		</script>
	</body>

</html>