Ext.define('App.view.theme.ThemeEdit', {
	extend : 'Ext.window.Window',
	alias : 'widget.themeEdit',
	initComponent : function() {
		var me = this;
		Ext.applyIf(me, {
			layout : 'fit',
			title : '信息修改',
			bodyStyle : 'background:#fff; padding:10px;',
			items : [{
				xtype : 'form',
				border : false
			}],
			buttons : ['->', {
				text : '修改',
				action : 'save',
				scope : this
			}, '-', {
				text : '关闭',
				action : 'close',
				scope : this
			}]
		});
		me.callParent(arguments);
	},

	flushView : function() {
		this.doLayout();
	},

	loadView : function() {
		var formCmp = this.getComponent(0);
		formCmp.add([{
			xtype : 'textfield',
			fieldLabel : '主题名称',
			labelAlign : 'right',
			name : 'theme'
		}, {
			xtype : 'textfield',
			fieldLabel : '样式文件',
			labelAlign : 'right',
			name : 'css'
		}]);

		formCmp.doLayout();
		this.flushView();
	}
});
