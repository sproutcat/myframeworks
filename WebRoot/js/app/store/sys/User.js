Ext.define('App.store.sys.User', {
	extend : 'Ext.data.Store',

	autoLoad : true,
	model : 'App.model.sys.User',
	proxy : {
        type : 'ajax',
        url : 'user/search',
        reader : {
            type : 'json',
            root : 'data',
            successProperty : 'success',
            totalProperty: 'total'
        }
    }
	
});