<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	
	<title>测试系统</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="js/extjs/resources/css/ext-all.css" />
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/icons.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<div id="mainNorth">
		<div id="logo"><h1>My Test System</h1></div>
		<div id="tipUser">
			<span class="tipImg icon-user"></span>${userName} 已登录！${currentDate}
		</div>
		<div style="clear:both;"></div>
	</div>
	<!--div id="mainFirstPage">
		<p>Hello world! 你好，世界！</p>
	</div-->
	
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="js/common/common.js"></script>
	<script type="text/javascript" src="js/extjs/ext-all-debug.js"></script>
	<script type="text/javascript" src="js/extjs/ext-lang-zh_CN.js"></script>
	<script type="text/javascript">
		var sysMenus = eval('${menus}');
		//util.log("----menus: {0}", sysMenus);
	</script>
	<script type="text/javascript" src="js/FileManager.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>
</html>
