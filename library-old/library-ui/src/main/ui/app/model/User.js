Ext.define('Library.model.User', {
	extend: 'Ext.data.Model',

	fields: [
		{ name: 'email', type: 'string' },
		{ name: 'firstName', type: 'string' },
		{ name: 'lastName', type: 'string' },
		{ name: 'roles', type: 'string' }
	]
});
