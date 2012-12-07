Ext.define('Library.controller.Users', {
	extend: 'Ext.app.Controller',
	views: ['Main', 'Login'],
	refs: [{
		selector: 'main',
		ref: 'container'
	}],
	init: function() {
		this.control({
			'main': {
				beforerender: this.checkUserContext
			},
			'login button[action=login]': {
				click: this.login
			}
		});
	},

	checkUserContext: function(container) {
		// First check if a user is already logged in server side and if
		// so update the client side security context.
		Library.utils.security.getCurrentUser();

		// If no user are logged in request 
		if (Library.utils.security.user == null) {
			container.getLayout().setActiveItem(0);
		} else {
			container.getLayout().setActiveItem(1);
		}
	},

	login: function(button) {
		var form = button.up('form').getForm();
		if (form.isValid()) {
			var values = form.getFieldValues();
			var login = values.login;
			var password = values.password;
			Ext.Ajax.request({
				url: Library.utils.rest.security.login,
				method: 'POST',
				params: {
					login: login,
					password: password
				},
				scope: this,
				success: function(response) {
					var data = Ext.decode(response.responseText);
					if (data.status) {
						Library.utils.security.user = data.user;
						this.getContainer().getLayout().setActiveItem(1);
					} else {
						//TODO:
					}
				}
			});
		}
	}
});
