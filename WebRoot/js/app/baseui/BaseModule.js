







Ext.define('App.baseui.BaseModule', {
	extend : 'Ext.app.Controller',
	views : ['sys.User'],
	//stores : ['User'],
	
	init: function(application) {
		this.control({
			"sysUser": {
				'beforerender' : function(view) {
					
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
