Ext.define('Library.store.Authors', {
	extend: 'Ext.data.Store',
	model: 'Library.model.Author',
	autoLoad: false,
	proxy: {
		type: 'rest',
		url: 'rest/authors',
		reader: {
			type: 'json',
			root: 'author',
			totalProperty: 'count',
			successProperty: 'success',
			messageProperty: 'message'
		},
		writer: {
			type: 'json'
		},
		listeners: {
			exception: function(proxy, response, operation, eOpts) {
				alert('toto');
			}
		}
	}
});
