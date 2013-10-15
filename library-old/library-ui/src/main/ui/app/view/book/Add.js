Ext.define('Library.view.book.Add', {
	extend: 'Ext.window.Window',
	alias: 'widget.bookadd',
	title: 'Ajouter un livre',
	autoShow: false,
	autoScroll: true,
	modal: true,
	width: 300,
	height: 300,
	layout: {
		type: 'anchor'
	},
	items: [{
		xtype: 'bookform',
		anchor: '100% 100%'
	}],
	buttons: [{
		text: 'Ajouter',
		action: 'add'
	}, {
		text: 'Annuler',
		action: 'cancel'
	}]
});
