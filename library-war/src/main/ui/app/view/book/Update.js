Ext.define('Library.view.book.Update', {
	extend: 'Ext.window.Window',
	alias: 'widget.bookupdate',
	title: 'Mettre à jour un livre',
	autoShow: false,
	modal: true,
	items: [{
		xtype: 'bookform'
	}],
	buttons: [{
		text: 'Mettre à jour',
		action: 'add'
	}, {
		text: 'Annuler',
		action: 'cancel'
	}]
});
