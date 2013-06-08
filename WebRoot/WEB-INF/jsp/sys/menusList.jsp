<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div style="margin:3px;padding:3px;border:1px solid #8000ff;" layoutH="14">
	<div>
		<h1>菜单管理</h1>
		<div>
			<ul class="tree treeFolder">
				<li><a href="javascript:;">框架面板</a>
					<ul>
						<li><a href="javascript:;">我的主页</a></li>
					</ul>
				</li>
				<li><a href="javascript:;">面板</a></li>
			</ul>
		</div>
	</div>
	<div>
		<p>表单</p>
	</div>
</div>
