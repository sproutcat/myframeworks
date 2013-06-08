

Ext.define('App.view.theme.ThemeQuery', {
	extend : 'Ext.container.Container',
	alias : 'widget.themeQuery',
	initComponent : function() {
		var me = this;
		Ext.applyIf(me, {
			items : [{
				xtype : 'fieldset',
				padding : '10 10 0 10',
				collapsible : true,
				title : '信息查询',
				items : [{
					xtype : 'tabpanel',
					border : false,
					plain : true,
					activeTab : 0,
					items : [{
						xtype : 'form',
						border : false,
						padding : '10 10 10 10',
						title : '主题风格',
						layout : 'hbox',
                        closable: false
					}],
                    listeners : {
                        'tabchange' : function(tabPanel, newCard, oldCard, pts) {
                            var grid = Ext.ComponentQuery.query('gridpanel')[0];
                            grid.setTitle(newCard.title);
                        }
                    }
				}]
			}]
		});
		me.callParent(arguments);
	},

	flushView : function() {
        this.doLayout();
	},

	loadView : function() {
        var tabpanelCmp = this.getComponent(0).getComponent(0);
		var formCmp = tabpanelCmp.getComponent(0);
		formCmp.add([{
			xtype : 'textfield',
			name : 'queryStr',
			fieldLabel : '主题名称',
			labelAlign : 'right'
		}, {
			xtype : 'button',
			text : '搜索',
			style : 'margin-left: 10px',
            action : 'submit'
		}]);
	}
});
