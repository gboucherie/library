Ext.require('Library.form.Book');
Ext.application({
	name: 'Library',
    models: ['Book'],
    stores: ['Books'],
    controllers: ['Books'],
    views: ['Viewport'],
    roles: [],
    hasRole: function(role) {
    	return Ext.Array.contains(this.roles, role);
    },
    launch: function() {
    	// TODO: should work but version 4.1.1a have a bug on views getters creation
    	// (see comments on Ext.app.Application), should be fixed on next version
//    	this.getView('Viewport').create();
    	Ext.create('Library.view.Viewport');
    }
});
