

/**
 * base grid
 */
Ext.define('App.baseui.BaseGrid', {
    extend: 'Ext.grid.Panel',
    alias : 'widget.baseGrid',
	requires: [
        'Ext.grid.*',
        "App.baseui.BasePaging"
    ],
    layout: "fit",
    columns: [],
    initComponent: function(config) {
    	var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		Ext.apply(me, {
			store: me.getGridStore(),
			selModel : Ext.create('Ext.selection.CheckboxModel', {
				listeners : {
					selectionchange : function(sm, selections) {
						//grid.down('#delBtn').setDisabled(selections.length == 0);
					}
				}
			}),
			bbar: Ext.widget('basePaging', {
				store: me.getGridStore()
			})
		});
    	this.callParent([cfg]);
    },
	getGridStore: function() {
		return [];
	}
});
