<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src="weblib/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
<% 
//request.getSession().setAttribute("chens","hello world22222222222");
%>
<h2>Hello World  -- <%= request.getRemoteAddr() %> : <%= request.getLocalPort() %> !</h2>
<%=request.getSession().getAttribute("chens") %>
</body>
</html>
