


Ext.define('App.baseui.BaseSearchTools', {
    extend: 'Ext.container.Container',
    alias : 'widget.baseSearchTools',
	requires: [
        'Ext.form.FieldSet'
    ],
    style : 'margin-left: 80px',
	layout: {
        type: 'hbox'
    },
    defaults: {
    	margins: '0 10'
    },
	items: [{
		xtype : 'button',
		text : '搜索',
		iconCls: "icon-search",
        action : 'searchBtn'
	}, {
		xtype : 'button',
		text : '重置',
		iconCls: "icon-reset",
        action : 'resetBtn'
	}],
	initComponent: function(config) {
    	var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		
		this.callParent([cfg]);
	}
});
