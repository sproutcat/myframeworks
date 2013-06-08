<%@ page language="java" import="java.util.*,com.fw.demo.model.Menus" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="js/dwz/themes/default/style.css">
	<link rel="stylesheet" type="text/css" href="js/dwz/themes/css/core.css">
	
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/dwz/source/jquery.validate.js"></script>
	<script type="text/javascript" src="js/dwz/source/jquery.bgiframe.js"></script>
	<script type="text/javascript" src="js/dwz/dwz.js"></script>
	<script type="text/javascript" src="js/dwz/source/dwz.regional.zh.js"></script>
	<script type="text/javascript" src="js/common/common.util.js"></script>
	<script type="text/javascript">
		$(function(){
			DWZ.init("js/dwz/dwz.frag.xml", {
				loginUrl:"login", 
				loginTitle:"登录",	// 弹出登录对话框
				statusCode:{ok:200, error:300, timeout:301}, //【可选】
				pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
				debug:true,	// 调试模式 【true|false】
				callback:function(){
					initEnv();
					$("#themeList").theme({themeBase:"js/dwz/themes"}); // themeBase 相对于index页面的主题base路径
				}
			});
		});
	</script>
  </head>
  
  <body scroll="no">
  	<div id="layout">
  		<div id="header">
			<div class="headerNav">
				<a class="logo" href="#">标志</a>
				<ul class="nav">
					<li id="switchEnvBox"><a href="javascript:">（<span>北京</span>）切换城市</a>
						<ul>
							<li><a href="sidebar_1.html">北京</a></li>
							<li><a href="sidebar_2.html">上海</a></li>
							<li><a href="sidebar_2.html">南京</a></li>
							<li><a href="sidebar_2.html">深圳</a></li>
							<li><a href="sidebar_2.html">广州</a></li>
							<li><a href="sidebar_2.html">天津</a></li>
							<li><a href="sidebar_2.html">杭州</a></li>
						</ul>
					</li>
					<li><a href="#" target="_blank">捐赠</a></li>
					<li><a href="#" target="dialog" width="600">设置</a></li>
					<li><a href="#" target="_blank">博客</a></li>
					<li><a href="#" target="_blank">微博</a></li>
					<li><a href="#" target="_blank">论坛</a></li>
					<li><a href="#">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		</div>
		
		<!-- 左边开始 -->
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			
			<div id="sidebar">
				<div class="toggleCollapse"><h2>导航菜单</h2><div>收缩</div></div>
				<div class="accordion" fillSpace="sidebar">
					<%				
						List<Menus> menus = (List<Menus>)request.getAttribute("menus");
						if(menus != null && menus.size() > 0) {
							for(Menus m1 : menus) {
					%>
					<div class="accordionHeader">
						<h2><span>Folder</span><%=m1.getText() %></h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
					<%
								if(m1.getChildren() != null && m1.getChildren().size() > 0) {
									for(Menus m2 : m1.getChildren()) {
										if(m2.getChildren() != null && m2.getChildren().size() > 0) {
					%>
									<li><a href="<%=m2.getTarget() %>"><%=m2.getText() %></a>
										<ul>
					<%
											for(Menus m3 : m2.getChildren()) {
					%>
											<li><a href="<%=m3.getTarget() %>" target="navTab" rel="<%=m3.getId() %>"><%=m3.getText() %></a></li>
					<%					
											}
					%>	
										</ul>
									</li>
					<%
										} else {
					%>
									<li><a href="<%=m2.getTarget() %>" target="navTab" rel="<%=m2.getId() %>"><%=m2.getText() %></a></li>
					<%		
										}
									}
								} else {
					%>
							<li><a href="<%=m1.getTarget() %>" target="navTab" rel="<%=m1.getId() %>"><%=m1.getText() %></a></li>
					<%
								}
					%>
						</ul>
					</div>
					<%
							}
						} else {
					%>
					<div class="accordionHeader">
						<h2><span>Folder</span>系统管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="#" target="navTab">系统管理</a>
								<ul>
									<li><a href="user/list" target="navTab" rel="page1">用户管理</a></li>
									<li><a href="auth/list" target="navTab" rel="page2">权限管理</a></li>
									<li><a href="login" target="navTab" rel="page3">角色管理</a></li>
									<li><a href="login" target="navTab" rel="page4">部门管理</a></li>
									<li><a href="login" target="navTab" rel="page5">图标管理</a></li>
								</ul>
							</li>
							<li><a href="" target="navTab" >系统设置</a>
								<ul>
									<li><a href="login" target="navTab" rel="login">系统备份</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<%
						}
					%>
					
				</div>
			</div>
		</div>
		<!-- 左边结束 -->
		
		
		<!-- 中间开始 -->
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent tabsPageHeaderMargin"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="#"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
				</div>
				<div class="navTab-panel tabsPageContent layoutBox" >
					<div class="page unitBox">
						<iframe width="100%" height="100%" class="share_self"  frameborder="0" scrolling="no" src="http://www.baidu.com"></iframe>
					</div>
					
					
				</div>
			</div>
		</div>
  	</div>
  	<!-- 中间结束 -->
  	
  	
  	
	<div id="footer">Copyright &copy; 2013 <a href="javascripts:;">TL团队</a> Tel：####-#######</div>
  </body>
</html>
