Ext.define('Library.view.Viewport', {
    renderTo: Ext.getBody(),
    extend: 'Ext.container.Viewport',
    requires:[
        'Ext.tab.Panel',
        'Ext.layout.container.Border',
        'Library.view.book.List'
    ],

    layout: {
        type: 'fit'
    },

    items: [{
        xtype: 'booklist'
    }]
});
