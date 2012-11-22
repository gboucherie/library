Ext.define('Library.controller.Books', {
	extend: 'Ext.app.Controller',
	stores: ['Books'],
	views: ['book.Add', 'book.Update'],
	refs: [{
		selector: 'booklist',
		ref: 'grid'
	}],

	init: function() {
		this.control({
			'booklist': {
				itemdblclick: this.openUpdateBookWindow
			},
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
			},
			'bookupdate button[action=add]': {
				click: this.updateBook
			},
			'bookupdate button[action=cancel]': {
				click: this.cancelUpdateBook
			}
		});
	},

	openUpdateBookWindow: function(grid, record, item, index, e, eOpts) {
		var win = Ext.widget('bookupdate');
		win.down('form').loadRecord(record);
		win.show();
	},

	openAddBookWindow: function() {
		var win = Ext.widget('bookadd');
		win.show();
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

	updateBook: function(button) {
		var win = button.up('window');
		var form = win.down('form').getForm();
		if (form.isValid()) {
			var values = form.getFieldValues();
			var book = this.getBooksStore().getById(values.id);
			book.set('title', values.title);
			book.set('author', values.author);
			book.set('genre', values.genre);
			book.set('year', values.year);
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
	},

	cancelUpdateBook: function(button) {
		var win = button.up('window');
		win.close();
	}
});
