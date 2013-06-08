



Ext.define('App.controller.test.TestModule', {
	extend : 'Ext.app.Controller',
	views : ['test.Test'],
	//stores : ['User'],
	
	init: function(application) {
		var gridPanel, searchPanel;
		this.control({
			"sysUser": {
				'beforerender' : function(view) {
					view.loadView();
				}
			},
			"sysUser button[action=searchBtn]": {
				'click' : function(btn) {
					var formCmp = Ext.ComponentQuery.query('sysUser baseSearchForm')[0];
					var basicForm = formCmp.getForm();
					var values = basicForm.getValues();
					util.log(values);
				}
			},
			"sysUser button[action=resetBtn]": {
				'click' : function(btn) {
					var formCmp = Ext.ComponentQuery.query('sysUser baseSearchForm')[0];
					var basicForm = formCmp.getForm();
					basicForm.reset();
				}
			},
			"sysUser button[action=addBtn]": {
				'click' : function(btn) {
					var addWin = Ext.create("App.baseui.BaseWindow", {
						items: [{
							xtype: "form",
							layout: {
								type: "table",
								columns: 3
							},
							columnWidth: 300,
							
							items: [{
								
							}]
						}]
					});
					addWin.show();
				}
			},
			"sysUser button[action=delBtn]": {
				'click' : function(btn) {
					alert("删除");
				}
			}
		});
	},
	
	/**
	 * @Override
	 */
	loadModel : function() {
		
	},

	/**
	 * @Override
	 */
	loadView : function() {}
});