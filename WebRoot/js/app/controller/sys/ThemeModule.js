

/**
 * 
 */
Ext.define('App.controller.sys.ThemeModule', {
	extend : 'Ext.app.Controller',
	views : ['theme.Theme'],
	stores : ['Theme'],
	
	/**
	 * @Override
	 */
	init : function(application) {
		this.control({
			'themeQuery' : {
				'beforerender' : function(view) {
                    view.loadView(); 
				}
			},
			
			'themeQuery button[action=submit]' : {
				'click' : function() {  
                    var formCmp = Ext.ComponentQuery.query('themeQuery form')[0];  
                    var basicForm = formCmp.getForm();  
                    if (basicForm.isValid()) {  
                         Ext.Msg.alert("信息", "模糊查询所有文本字段.");  
                    }  
                } 
			},
			
			'themeQuery textfield' : {
				'focus' : function() {  
                    var formCmp = Ext.ComponentQuery.query('themeQuery form')[0];  
                    var basicForm = formCmp.getForm();  
                    basicForm.reset();  
                } 
			},
			
			'themeList' : {
				'beforerender' : function(view) {
                    view.loadView(); 
				}
			},
			
			'themeList > grid' : {  
				'itemdblclick' : function(table, record, html, row, event, opt) {  
                    var view = Ext.widget('themeEdit');  
                    view.loadView();
                    view.show();  
                    view.down('form').loadRecord(record);  
                }
			},
			
			'themeList > grid button[action=add]' : {
				'click' : function() {  
                    var view = Ext.widget('themeAdd');  
                    view.loadView();  
                    view.show();
                }  
			},
			
			'themeList > grid button[action=remove]' : {
				'click' : function() {  
                    var grid = Ext.ComponentQuery.query('themeList > grid')[0];  
                    var sm = grid.getSelectionModel();  
                    grid.store.remove(sm.getSelection());  
                      
                    // 提交后台  
                } 
			},
			
			'themeEdit button[action=save]' : {
				'click' : function(button, event, opt) {  
                    var win = button.up('window'), form = win.down('form'), record = form.getRecord(), values = form.getValues();  
                    record.set(values);  
                    win.close();  
                    this.getThemeStore().sync();  
                      
                    // 提交后台  
                } 
			},
			
			'themeEdit button[action=close]' : {
				'click' : function(button, event, opt) {  
                    var win = button.up('window');  
                    win.close();  
                } 
			},
			
			'themeAdd button[action=save]' : {
				'click' : function(button, event, opt) {  
                    var win = button.up('window'), form = win.down('form'), values = form.getValues();  
                    win.close();  
                    var grid = Ext.ComponentQuery.query('themeList > grid')[0];  
                    var store = grid.store;  
                    var record = Ext.create('App.model.Theme', values);  
                    store.add([record]);  
                      
                    // 提交后台.  
                } 
			},
			
			'themeAdd button[action=close]' : {
				'click' : function(button, event, opt) {  
                    var win = button.up('window');  
                    win.close();  
                }
			}
		});
	},
	
	/**
	 * @Override
	 */
	loadModel : function() {
		Ext.create('App.store.Theme', {
			storeId : 'themeStore'
		});
	},

	/**
	 * @Override
	 */
	loadView : function() {}

});