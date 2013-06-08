
var mainTabs = null;


/*Ext.require([
	'Ext.app.Application', 
	'Ext.app.Controller'
]);*/
	
/**
 * MVC 增强
 */
Ext.app.Controller.implement({
	/**
	 * @MVC 加载模型
	 */
	loadModel : function() {},

	/**
	 * @MVC 加载视图
	 */
	loadView : function() {},
	
	getApplication : function() {
		return this.application;
	}
});


Ext.app.Application.implement({
	/**
	 * @MVC 加载控制器
	 * @param {String/Array} controllers
	 */
	loadModule : function(controllers) {
		var me = this;
		var controllers = Ext.Array.from(controllers), ln = controllers.length, i, controller;
		for (i = 0; i < ln; i++) {
			var name = controllers[i];
			
			if (!this.controllers.containsKey(name)) {
				controller = Ext.create(
						this.getModuleClassName(name, 'controller'), {
							application : this,
							id : name
						});
				this.controllers.add(controller);
				
				/**
				 * 优先加载模型
				 */
				controller.loadModel();
				
				controller.init(this);
				controller.onLaunch(this);
				
				/**
				 * 动态构建视图 & 绑定模型数据
				 */
				controller.loadView();
			}
		}
	}
});

Ext.QuickTips.init();
Ext.form.Field.prototype.msgTarget = 'side';

Ext.application({
    name : 'App',
    appFolder : 'js/app',
    launch : function() {
        application = this;
        this.loadModule(['MainModule']);
    }
});
