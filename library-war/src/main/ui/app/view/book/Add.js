Ext.define('Library.view.book.Add', {
	extend: 'Ext.window.Window',
	alias: 'widget.bookadd',
	title: 'Ajouter un livre',
	autoShow: false,
	modal: true,
	items: [{
		xtype: 'bookform'
	}],
	buttons: [{
		text: 'Ajouter',
		action: 'add'
	}, {
		text: 'Annuler',
		action: 'cancel'
	}]
});
