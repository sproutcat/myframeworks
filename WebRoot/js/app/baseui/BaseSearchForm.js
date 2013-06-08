


/**
 * 表单
 */
 Ext.define('App.baseui.BaseForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.baseForm',
	requires: [
    ],
    initComponent: function(config) {
    	var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		Ext.apply(me, {
			
		});
    	this.callParent([cfg]);
    }
});

Ext.define('App.baseui.BaseSearchForm', {
    extend: 'App.baseui.BaseForm',
    alias : 'widget.baseSearchForm',
	requires: [
        'Ext.form.FieldSet'
    ],
    initComponent: function(config) {
    	var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		Ext.apply(me, {
			items: [{
				xtype : 'fieldset',
				margin: 3,
				padding: 5,
				collapsible : true,
				title : '查询条件',
				layout: {
			        type: 'table',
			        columns: 3
			    },
			    columnWidth: 300,
			    defaultType: 'textfield',
        		defaults: {anchor: '100%'},
				items: me.getSearchItems()
			}]
		});
    	this.callParent([cfg]);
    },
    getSearchItems: function() {
    	return [];
    }
});

