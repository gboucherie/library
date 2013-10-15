Ext.define('Library.form.Book', {
	extend: 'Ext.form.Panel',
	xtype: 'bookform',
	layout: 'anchor',
	bodyPadding: 5,
	defaults: {
		anchor: '100%'
	},
	fieldDefaults: {
		labelAlign: 'top'
	},
	items: [{
		xtype: 'numberfield',
		name: 'id',
		hidden: true
	},{
		xtype: 'isbnfield',
		name: 'isbn',
		fieldLabel: 'ISBN'
	},{
		xtype: 'textfield',
		name: 'title',
		fieldLabel: 'Titre',
		allowBlank: false
	},{
		xtype: 'combobox',
		name: 'author',
		fieldLabel: 'Auteur',
		displayField: 'fullname',
		allowBlank: false,
		store: 'Authors'
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
});
