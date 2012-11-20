Ext.define('Library.view.book.Add', {
	extend: 'Ext.window.Window',
	alias: 'widget.bookadd',
	title: 'Ajouter une opération',
	autoShow: true,
	modal: true,
	items: [{
		xtype: 'form',
		items: [{
			xtype: 'textfield',
			name: 'title',
			fieldLabel: 'Titre',
			allowBlank: false
		}]
	}],
	buttons: [{
		text: 'Ajouter',
		action: 'add'
	}, {
		text: 'Annuler',
		action: 'cancel'
	}]
});
