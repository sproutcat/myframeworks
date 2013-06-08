
/**
 * 主题管理
 */
Ext.define('App.view.theme.Theme', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.themeTheme',
	requires : [
		'App.view.theme.ThemeQuery',
		'App.view.theme.ThemeList',
		'App.view.theme.ThemeAdd',
		'App.view.theme.ThemeEdit'
	],
	initComponent : function(config) {
		var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		Ext.apply(me, {
			autoShow : true,
			layout: "border",
			items : [{
				region: 'north',
				xtype : 'themeQuery'
			}, {
				region: "center",
				xtype : 'themeList',
				autoShow : true
			}]
		});
		me.callParent([cfg]);
	}
});
