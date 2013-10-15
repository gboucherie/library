Ext.define('Library.view.Main', {
	extend: 'Ext.container.Container',
	alias: 'widget.main',
	layout: 'card',
	items: [{
		xtype: 'login'
	}, {
		xtype: 'booklist'
	}]
});
