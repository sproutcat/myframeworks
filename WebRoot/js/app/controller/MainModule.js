
/**
 * 
 */
Ext.define('App.controller.MainModule', {
	extend : 'Ext.app.Controller',
	views : ['Main'],
	refs : [
        {
        	ref : 'viewport',
        	selector: 'viewport'
        },
        {
            ref: 'tab',
            selector: 'viewport tabpanel'
        }
    ],
	
	/**
	 * @Override
	 */
	init : function(application) {
		this.control({
			'viewport tool[action=refresh]' : {
				'click' : function() {
					var stores = ['config'];
					var treepanels = this.getViewport().query('treepanel');
					Ext.each(treepanels, function(treepanel, index) {
						treepanel.store.on('load', function(store, records, successful, operation, opts) {
							treepanel.doLayout();
						});
					});
				}
			},
			
			'viewport' : {
				'beforerender' : function() {
					var application = this.application;
					var treepanels = this.getViewport().query('treepanel');
					var tabpanel = this.getTab();
					
					Ext.each(treepanels, function(treepanel, index) {
						treepanel.on('itemclick', function(treepanel, record, item, index, e, opts) {
				            if (record.get('leaf')) {
				            	var moduleId = record.get('id') + "Module"; 
				            	application.loadModule(moduleId);
				            	var module = application.getController(moduleId);
				            	
				            	/**
				            	 * @tip
				            	 * 一个控制器第一个视图为模块主功能视图
				            	 */
				            	var viewName = module.views[0];
				            	var view = module.getView(viewName);
				            	
				            	/***
				            	 * 视图结构: 目录为模块包名, 目录内文件为模块名, 视图类型为小写的模块名.
				            	 * @example
				            	 * App.viw.theme.Theme
				            	 * alias : 'widget.themeTheme'
				            	 * 
				            	 * viewType: themeTheme
				            	 */
				            	var viewType = viewName.replace(".", "");
				            	
				            	/**
				            	 * 如果没有此视图, 创建视图.
				            	 */
				            	if (!tabpanel.down(viewType)) {
				                    var panel = view.create({
				                    	title: record.get('text'),
				                    	iconCls: "icon-tab",
				                    	closable : true,
				                    	margin: 3
				                    });
				                    tabpanel.add(panel);
				                    tabpanel.setActiveTab(panel);
				                    panel.doLayout();
				            	}
				            	/**
				            	 * 如果有此视图, 刷新视图.
				            	 */
				            	else {
				            		var panel = tabpanel.down(viewType);
				                    tabpanel.setActiveTab(panel);
				                    panel.doLayout();
				            	}
				            } else {
				            	treepanel.expand(record);
				            }
				            
						});
					});
				}
			}
		});
	},

	/**
	 * @Override
	 */
	loadModel : function() {
		/*Ext.create('Ext.data.TreeStore', {
			storeId : 'config',
			autoLoad : true,
			proxy : {
                type : 'ajax',
                url : 'js/data/menu.json',
                reader : {
                    type : 'json',
                    root : 'children',
                    successProperty : 'success'
                }
            }
		});*/
	},

	/**
	 * @Override
	 */
	loadView : function() {
		var menusItems = [];
		if(sysMenus) {
			for(var i = 0; i < sysMenus.length; i++) {
				menusItems.push({
					xtype : 'treepanel',
					iconCls : 'x-tree-icon x-tree-icon-parent',
					rootVisible : false,
					title : sysMenus[i]["text"],
					store : Ext.create('Ext.data.TreeStore', {
						root: sysMenus[i]
					})
				});
			}
		}
		/*menusItems.push({
			xtype : 'treepanel',
			iconCls : 'x-tree-icon x-tree-icon-parent',
			rootVisible : false,
			title : '系统配置',
			store : Ext.getStore('config')
		});*/
		
		Ext.create('Ext.container.Viewport', {
			layout : 'border',
			padding: 5,
			items : [{
				region : 'north',
                height : 80,
                bodyPadding: "0 0 3 0",
                bodyStyle: "background: #DFE8F6;",
                contentEl: "mainNorth",
				border : false
			}, {
				region : 'west',
				split : true,
				collapsible : true,
				collapseFirst : false,
				title : '功能导航',
				width : 200,
				layout : 'accordion',
				items : menusItems
			/*}, {
				region : 'south',
				autoHeight : true,
				border : false,
				margins: "3 0 0 0",
                dockedItems : [{
                    xtype : 'toolbar',
                    dock: 'bottom',
                    items : [{
                    	iconCls: 'icon-user',
                        cls: 'x-btn-text-icon'
                    }, {
                        text : 'admin 已登录! 2012-07-10 10:00 '
                    }, '-']
                }]*/
			}, {
				region : 'center',
				xtype : 'tabpanel',
				activeTab : 0,
				closeAction : 'destroy',
				plugins: Ext.create("Ext.ux.TabCloseMenu", {
					closeTabText : '关闭当前页',  
                    closeOthersTabsText : '关闭其他页',
                    closeAllTabsText : '关闭所有页'  
				}),
				items : [{
					title : '首页',
					iconCls: "icon-home",
					margin: 3,
					//contentEl: "mainFirstPage",
					layout: 'border',
					items: [{
						region: 'center',
						xtype: 'fileManagerGrid'
					}]
				}]
			}]
		});
	}
});