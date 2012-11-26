Ext.define('Library.view.Viewport', {
    renderTo: Ext.getBody(),
    extend: 'Ext.container.Viewport',
    requires:[
        'Ext.layout.container.Border',
        'Library.view.book.List'
    ],

    layout: {
        type: 'border',
        padding: 10
    },

    items: [{
    	region: 'north',
    	xtype: 'container',
    	height: 50
    },{
    	region: 'center',
        xtype: 'booklist'
    },{
    	region: 'south',
    	xtype: 'container',
    	height: 30
    }]
});
