<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    

  </head>
  
  <body>
   
	<form action="index" method="POST"> 
		用户名<input type="text" name="name"></input></br>
		<span></span>
		密码<input type="text" name="pwd"></input></br>
		<input type="submit" value="登录">
		
	</form>




  </body>
</html>
