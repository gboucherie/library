Ext.define('Library.store.Books', {
    extend: 'Ext.data.Store',
    model: 'Library.model.Book',
    autoLoad: true,
    pageSize: 2,

    proxy: {
        type: 'rest',
        url: 'rest/books',
        reader: {
            type: 'json',
            root: 'book'
        },
        writer: {
            type: 'json'
        }
    }
});
