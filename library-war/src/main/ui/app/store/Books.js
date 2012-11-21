Ext.define('Library.store.Books', {
    extend: 'Ext.data.Store',
    model: 'Library.model.Book',
    autoLoad: true,

    proxy: {
        type: 'rest',
        url: 'rest/books',
        reader: {
            type: 'json',
            root: 'book',
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
