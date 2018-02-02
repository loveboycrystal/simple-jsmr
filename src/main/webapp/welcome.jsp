<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>控制面板</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link rel="stylesheet" href="<%=basePath %>weblib/layer3.0/layerui/layui/css/layui.css" media="all" />
		<style type="text/css">
			body{
				padding : 20px;
			}
		</style>
	</head>
	<body>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		  <legend>欢迎归来</legend>
		</fieldset>
		<blockquote class="layui-elem-quote">
			 <font color="red">${ sessionScope.loginUserInfo.name } </font>, 您好!  欢迎您回来.<br/>
			 <div>您上一次登录时间是：${sessionScope.loginUser.lastLoginTime } </div>
		</blockquote>
		
		<fieldset class="layui-elem-field">
		  <legend>预留信息</legend>
		  <div class="layui-field-box"> <br/>
		      号码：${ sessionScope.loginUserInfo.phone } <br/> <br/>
		      地址：${ sessionScope.loginUserInfo.address } 
		  </div>
		</fieldset>
		<script src="./weblib/layer3.0/layerui/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="./weblib/layer3.0/layerui/layui/layui.js" type="text/javascript" ></script>
		<script src="./weblib/layer3.0/layerui/js/jbase64.js" type="text/javascript" charset="utf-8"></script>
		<script src="./weblib/common/const.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
