Ext.define('Library.controller.Books', {
	extend: 'Ext.app.Controller',
	stores: ['Books'],
	views: ['book.Add'],
	refs: [{
		selector: 'booklist',
		ref: 'grid'
	}],

	init: function() {
		this.control({
			'booklist button[action=add]': {
				click: this.openAddBookWindow
			},
			'booklist button[action=delete]': {
				click: this.deleteBooks
			},
			'bookadd button[action=add]': {
				click: this.addBook
			},
			'bookadd button[action=cancel]': {
				click: this.cancelAddBook
			}
		});
	},

	openAddBookWindow: function() {
		Ext.widget('bookadd');
	},

	addBook: function(button) {
		var win = button.up('window');
		var form = win.down('form').getForm();
		if (form.isValid()) {
			var values = form.getValues();
			this.getBooksStore().add(values);
			win.close();
			this.getBooksStore().sync();
		}
	},

	deleteBooks: function() {
		var booksToDelete = this.getGrid().getSelectionModel().getSelection();
		this.getBooksStore().remove(booksToDelete);
		this.getBooksStore().sync();
	},

	cancelAddBook: function(button) {
		var win = button.up('window');
		win.close();
	}
});
