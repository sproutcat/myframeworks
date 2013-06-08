

/**
 * base window
 */
Ext.define('App.baseui.BaseWindow' ,{
    extend: 'Ext.panel.Panel',
    alias : 'widget.BaseWindow',
	requires: [
		"App.baseui.BaseForm"
	],
    width: 900,
    height: 400,
    layout: 'fit',
    modal: true,
    initComponent: function(config) {
    	var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		
    	this.callParent([cfg]);
    }
});

Ext.define('App.baseui.BaseEditWindow' ,{
    extend: 'Ext.panel.Panel',
    alias : 'widget.BaseEditWindow',
	requires: [
		"App.baseui.BaseForm"
	],
    initComponent: function(config) {
    	var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		Ext.apply(me, {
			items: [{
				xtype: "baseForm",
				layout: {
					type: "table",
					columns: 3
				},
				columnWidth: 280
			}]
		});
    	this.callParent([cfg]);
    },
    getFormItems: function() {
    	return [];
    }
});

