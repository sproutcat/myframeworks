



Ext.define('App.view.sys.User', {
	extend : 'App.baseui.BaseSearchGrid',
	alias : 'widget.sysUser',
	requires : [
		"App.baseui.BaseGrid"
	],
	getSearchItems: function() {
		return [{
			name : 'test1',
			fieldLabel : 'test1',
			labelAlign : 'right'
		}, {
			name : 'test2',
			fieldLabel : 'test2',
			labelAlign : 'right'
		}, {
			name : 'test3',
			fieldLabel : 'test3',
			labelAlign : 'right'
		}, Ext.create("App.baseui.BaseSearchTools")];
	},
	getGridTools: function() {
		return [{
			text: "新增",
			iconCls : 'icon-add',
            action : 'addBtn'
		}, {
			text: "删除",
			iconCls : 'icon-remove',
            action : 'delBtn',
            disabled: true
		}];
	},
	getGridColumns: function() {
		return [{
			header : '用户名',
			dataIndex : 'name',
			flex : 1
		}, {
			header: "密码",
			dataIndex: 'pwd',
			flex: 1
		}, {
			header: "用户类型",
			dataIndex: 'userType',
			flex: 1
		}, {
			header : '姓名',
			dataIndex : 'realName',
			flex : 1
		}, {
			header: "手机",
			dataIndex: 'mobile',
			flex: 1
		}, {
			header : '状态',
			dataIndex : 'status',
			flex : 1
		}]
	}
});

