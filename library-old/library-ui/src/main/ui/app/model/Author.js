Ext.define('Library.model.Author', {
	extend: 'Ext.data.Model',
	fields: [
		{ name: 'id', type: 'int' },
		{ name: 'firstname', type: 'string' },
		{ name: 'lastname', type: 'string' },
		{ name: 'fullname', type: 'string', persist: false, convert: function(v, rec) {return rec.data.firstname + ', ' + rec.data.lastname;} }
	]
});
