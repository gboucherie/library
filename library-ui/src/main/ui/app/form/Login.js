Ext.define('Library.form.Login', {
	extend: 'Ext.form.Panel',
	xtype: 'loginform',
	border: false,
	buttonAlign: 'left',
	items: [{
		xtype: 'textfield',
		name: 'login',
		fieldLabel: 'Identifiant',
		inputType: 'email',
		allowBlank: false
	},{
		xtype: 'textfield',
		name: 'password',
		fieldLabel: 'Mot de passe',
		inputType: 'password',
		allowBlank: false
	}],
	buttons: [{
		text: 'S\'identifier',
		action: 'login'
	}]
});
