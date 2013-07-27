Ext.define('App.model.sys.User', {
	extend : 'Ext.data.Model',
	fields : ["recid", "realName", "subCompany", "department", "mail",
			"mobile", "userType", "status", "createtime", "modifytime",
			"name", "pwd"]
});