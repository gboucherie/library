Ext.require('Library.form.Book');
Ext.application({
    models: ['Book'],
    stores: ['Books'],
    controllers: ['Books'],
    name: 'Library',
    roles: [],
    hasRole: function(role) {
    	return Ext.Array.contains(this.roles, role);
    },
    launch: function() {
    	App.app = this;
    }
});
