



Ext.define('App.baseui.BasePanel' ,{
    extend: 'Ext.panel.Panel',
    alias : 'widget.BasePanel',
	requires: [
        'Ext.tree.*'
    ],
    layout: "border",
    initComponent: function(config) {
    	var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		
    	this.callParent([cfg]);
    }
});

