

var baseUIPaths = {
	//----------------------baseUI js---------------------------------
	"basePanel": "js/app/baseui/BasePanel.js",
	"basePaging": "js/app/baseui/BasePaging.js",
	"baseGrid": "js/app/baseui/BaseGrid.js",
	"baseForm": "js/app/baseui/BaseSearchForm.js",
	"baseSearchForm": "js/app/baseui/BaseSearchForm.js",
	"baseSearchTools": "js/app/baseui/BaseSearchTools.js",
	"baseSearchGrid": "js/app/baseui/BaseSearchGrid.js",
	"baseWindow": "js/app/baseui/BaseWindow.js",
	"baseController": "js/app/baseui/BaseController.js",
	
	//-----------------------app js--------------------------------
	"mainModule": "js/app/controller/MainModule.js",
	"main": "js/app/view/Main.js"
};

/**
 * JS动态加载
 */
Ext.Loader.setConfig({
	enabled : true,
	paths : {
		'Ext' : 'js/extjs',
		'App' : 'js/app'
	}
});

/**
 * 载入js文件
 */
util.loadJs(baseUIPaths);


Ext.create('Ext.data.Store', {
    storeId:'fileManagerStore',
    fields:['xtype', 'path'],
    data:{'items': util.toJsArray(baseUIPaths)},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
});

Ext.define('App.baseui.FileManagerGrid', {
    extend: 'Ext.grid.Panel',
    alias : 'widget.fileManagerGrid',
	requires: [
        'Ext.grid.*'
    ],
    layout: "fit",
    initComponent: function() {
    	Ext.apply(this, {
    		columns: [{
    			header: "类型",
    			dataIndex: "xtype",
    			width: 200
    		}, {	
    			header: "路径",
    			dataIndex: "path",
    			flex: 1
    		}],
    		store: Ext.getStore('fileManagerStore'),
    		dockedItems : [{
				xtype : 'toolbar',
				items: [{
					text: "新增",
					iconCls : 'icon-add',
		            action : 'addBtn',
		            listeners: {
		            	'click': function() {
		            		alert("My test!");
		            	}
		            }
				}]
			}],
    		listeners: {
    			'itemdblclick': function(view, record, item, index, e, eOpts) {
    				util.reloadJs(record.data);
    				util.log("----reloadJs: {0}, {1}", record.get('xtype'), record.get('path'));
    			}
    		}
    	});
    	this.callParent(arguments);
    }
});
