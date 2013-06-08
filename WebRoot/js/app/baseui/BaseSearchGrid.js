



Ext.define('App.baseui.BaseSearchGrid', {
    extend: 'App.baseui.BasePanel',
    alias : 'widget.baseSearchGrid',
	requires: [
        'App.baseui.BaseSearchForm',
        'App.baseui.BaseGrid'
    ],
    layout: "border",
    searchRegion: "north",
    initComponent: function(config) {
    	var me = this;
		var cfg = config || {};
		Ext.apply(me, cfg);
		Ext.apply(me, {
			autoShow : true,
			items: [{
				region: me.searchRegion,
				border: false,
				items: [{
					xtype: "baseSearchForm",
					getSearchItems: me.getSearchItems,
					margin: "0 0 3 0"
				}]
			}, {
				region: "center",
				xtype: "baseGrid",
				columns: me.getGridColumns(),
				getGridStore: me.getGridStore,
				dockedItems : [{
					xtype : 'toolbar',
					items: me.getGridTools()
				}]
			}]
		});
    	this.callParent([cfg]);
    },
    /**
     * 搜索栏
     * @return {}
     */
    getSearchItems: function() {
    	return [];
    },
    /**
     * grid的工具栏
     * @return {}
     */
    getGridTools: function() {
    	return [];
    },
    /**
     * grid列表
     * @return {}
     */
    getGridColumns: function() {
    	return []
    },
    /**
     * grid store
     * @return {}
     */
    getGridStore: function() {
    	return []
    },
    loadView : function() {}
});

