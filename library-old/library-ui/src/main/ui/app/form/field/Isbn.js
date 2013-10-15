Ext.define('Library.form.field.Isbn', {
	extend: 'Ext.form.field.Trigger',
	alias: 'widget.isbnfield',
	triggerCls: 'x-form-search-trigger',
	maskRe: new RegExp('[0123456789]'),
	onTriggerClick: function() {
		var me = this;
		Ext.Ajax.request({
			url: Library.utils.rest.books.isbn + "/" + me.value,
			method: 'GET',
			scope: me,
			success: function(response) {
				var data = Ext.decode(response.responseText);
				if (data.status) {
					Ext.Msg.alert('Status', data);
				}
			}
		});
	}
});
