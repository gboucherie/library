Ext.define('Library.view.book.Add', {
	extend: 'Ext.window.Window',
	alias: 'widget.bookadd',
	title: 'Ajouter un livre',
	autoShow: false,
	modal: true,
	items: [{
		xtype: 'form',
		items: [{
			xtype: 'textfield',
			name: 'title',
			fieldLabel: 'Titre',
			allowBlank: false
		},{
			xtype: 'textfield',
			name: 'author',
			fieldLabel: 'Auteur',
			allowBlank: false
		},{
			xtype: 'textfield',
			name: 'genre',
			fieldLabel: 'Genre',
			allowBlank: false
		},{
			xtype: 'numberfield',
			name: 'year',
			fieldLabel: 'Année',
			allowBlank: false,
			minValue: -3300,
			maxValue: 9999,
			hideTrigger: true,
			keyNavEnabled: false,
			mouseWheelEnabled: false
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
