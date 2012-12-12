Ext.require('Library.utils');
Ext.require('Library.form.Book');
Ext.require('Library.form.Login');
Ext.application({
	name: 'Library',
	id: 'library',
	models: ['Book', 'User'],
	stores: ['Books'],
	controllers: ['Books', 'Users'],
	views: ['Viewport'],
	autoCreateViewport: true
});
