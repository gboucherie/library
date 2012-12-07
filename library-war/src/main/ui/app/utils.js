Ext.define('Library.utils',{
	singleton: true,
	rest: {
		security: {
			login: 'rest/auth/login',
			current_user: 'rest/auth/current_user',
		}
	},
	security: {
		user: null,
	    hasRole: function(role) {
	    	return Ext.Array.contains(Library.utils.security.user.roles, role);
	    },
	    getCurrentUser: function() {
	    	Ext.Ajax.request({
				url: Library.utils.rest.security.current_user,
				method: 'GET',
				async: false,
				scope: this,
				success: function(response) {
					var data = Ext.decode(response.responseText);
					if (data.status) {
						Library.utils.security.user = data.user;
					}
				}
			});
	    }
	}
});