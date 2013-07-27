




Ext.define('App.baseui.BaseController', {
	extend : 'Ext.app.Controller',
	init: function(application) {
		var allControl = {
			"baseGrid": {
				itemclick: function(grid, record, item, index, e, eOpts ) {
					console.log(record);
				}
			}
		};
		Ext.apply(allControl, this.getMyContral(application));
		this.control(allControl);
	},
	
	/**
	 * @Override
	 */
	loadModel : function() {},

	/**
	 * @Override
	 */
	loadView : function() {},
	
	/**
	 * 自定义控制
	 * @return {}
	 */
	getMyContral: function(application) {
		return {};
	}
});