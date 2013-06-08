


/**
 * 分页组件
 */
Ext.define("App.baseui.BasePaging", {
	extend: "Ext.toolbar.Paging",
	alias : 'widget.basePaging',
	displayInfo : true,
	initComponent: function(config) {
		var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		Ext.apply(me, {
			items : ['-', {
				text : '每页显示'
			}, {
				xtype : 'combo',
				displayField : 'pageSize',
				name : 'pageSize',
				typeAhead : true,
				mode : 'local',
				forceSelection : true,
				triggerAction : 'all',
				editable : false,
				value : 15,
				width : 80,
				selectOnFocus : true,
				itemId : '#pageSize',
				store : Ext.create('Ext.data.ArrayStore', {
					fields : ['pageSize'],
					data : [[20], [50], [100]]
				})
			}, {
				text : '条'
			}, '-']
		});
    	this.callParent([cfg]);
	}
});
