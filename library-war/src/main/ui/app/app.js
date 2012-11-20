Ext.application({
    models: ['Book'],
    stores: ['Books'],
    controllers: ['Books'],
    views: ['book.List', 'book.Add'],

    name: 'Library',

    autoCreateViewport: true
});
