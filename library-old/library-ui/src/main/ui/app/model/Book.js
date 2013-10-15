Ext.define('Library.model.Book', {
	extend: 'Ext.data.Model',
	fields: [
		{ name: 'id', type: 'int' },
		{ name: 'title', type: 'string' },
		{ name: 'genre', type: 'string' },
		{ name: 'year', type: 'int' },
		{ name: 'author', type: 'string' }
	]
});
