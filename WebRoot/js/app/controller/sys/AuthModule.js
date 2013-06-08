



Ext.define('App.controller.sys.AuthModule', {
	extend : 'Ext.app.Controller',
	views : ['sys.Auth'],
	//stores : ['Auth'],
	
	init: function(application) {
		this.control({
			"sysAuth": {
				'beforerender' : function(view) {
					view.loadView();
				}
			},
			"sysAuth button[action=search]": {
				'click' : function(btn) {
					var formCmp = Ext.ComponentQuery.query('sysAuth baseSearchForm')[0];
					var values = formCmp.getValues();
					util.log(values);
				}
			},
			"sysAuth button[action=reset]": {
				'click' : function(btn) {
					util.log("---------reset-----------")
					var formCmp = Ext.ComponentQuery.query('sysAuth baseSearchForm')[0];
					var basicForm = formCmp.getForm();
					basicForm.reset();
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
