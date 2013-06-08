Ext.define('App.store.User', {
	extend : 'Ext.data.Store',

	autoLoad : true,
	model : 'App.model.User',
	proxy : {
        type : 'ajax',
        url : 'js/data/theme.json',
        reader : {
            type : 'json',
            root : 'data',
            successProperty : 'success',
            totalProperty: 'total'
        }
    }
	
});