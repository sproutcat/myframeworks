Ext.define('App.store.Theme', {
	extend : 'Ext.data.Store',

	autoLoad : true,
	model : 'App.model.Theme',
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