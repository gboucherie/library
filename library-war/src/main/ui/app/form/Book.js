Ext.define('Library.form.Book', {
	extend: 'Ext.form.Panel',
	xtype: 'bookform',
	items: [{
		xtype: 'numberfield',
		name: 'id',
		hidden: true
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
});
