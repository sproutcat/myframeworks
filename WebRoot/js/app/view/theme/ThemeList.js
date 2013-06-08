

Ext.define('App.view.theme.ThemeList', {
	extend : 'Ext.container.Container',
	alias : 'widget.themeList',
	layout: "fit",
	initComponent : function() {
		var me = this;
		Ext.applyIf(me, {
			margin : '3 3 3 3'
		});
		me.callParent(arguments);
	},

	flushView : function() {
		this.doComponentLayout();
	},

	loadView : function() {
		var grid = Ext.create('App.baseui.BaseGrid', {
			getGridStore: function() {
				return  Ext.getStore('themeStore');
			},
			autoShow : true,
			selType : 'rowmodel',
			selModel : Ext.create('Ext.selection.CheckboxModel', {
				listeners : {
					selectionchange : function(sm, selections) {
						grid.down('#removeButton')
								.setDisabled(selections.length == 0);
					}
				}
			}),
			columns : [{
				header : '主题名称',
				dataIndex : 'theme',
				flex : 1
			}, {
				header : '样式文件',
				dataIndex : 'css',
				flex : 1
			}, {
				xtype : 'actioncolumn',
				draggable : false,
				header : '操作',
				width : 50,
				items : [{
					iconCls: 'icon-cog_edit', 
					tooltip : '应用',
					handler : function(grid, rowIndex, colIndex) {
						var rec = grid.getStore().getAt(rowIndex);
						var css = rec.get('css');
						Ext.util.CSS.swapStyleSheet('theme', 'js/extjs/resources/css/' + css);
						
						Ext.ComponentQuery.query('viewport')[0].doLayout();
					}
				}]
			}],
			dockedItems : [{
				xtype : 'toolbar',
				items : [{
					text : '添加',
					itemId : 'addButton',
					iconCls : 'icon-add',
                    action : 'add'
				}, '-', {
					itemId : 'removeButton',
					text : '删除',
					iconCls : 'icon-remove',
					disabled : true,
                    action : 'remove'
				}, '-']
			}]
		});

		this.add([grid]);
	}
});
