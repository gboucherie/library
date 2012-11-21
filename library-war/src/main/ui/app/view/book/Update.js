Ext.define('Library.view.book.Update', {
	extend: 'Ext.window.Window',
	alias: 'widget.bookupdate',
	title: 'Mettre à jour un livre',
	autoShow: false,
	modal: true,
	items: [{
		xtype: 'form',
		items: [{
			xtype: 'hiddenfield',
			name: 'id'
		},{
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
		text: 'Mettre à jour',
		action: 'add'
	}, {
		text: 'Annuler',
		action: 'cancel'
	}]
});
