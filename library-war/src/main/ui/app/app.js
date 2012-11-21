Ext.application({
    models: ['Book'],
    stores: ['Books'],
    controllers: ['Books'],
    views: ['book.List', 'book.Add', 'book.Update'],

    name: 'Library',

    autoCreateViewport: true
});
