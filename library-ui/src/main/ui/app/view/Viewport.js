Ext.define('Library.view.Viewport', {
	renderTo: Ext.getBody(),
	extend: 'Ext.container.Viewport',
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
		xtype: 'main'
	},{
		region: 'south',
		xtype: 'container',
		height: 30
	}]
});
