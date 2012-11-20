Ext.define("Library.view.book.List", {
    extend: 'Ext.grid.Panel',
    alias: 'widget.booklist',
    title: 'Livres',
    store: 'Books',
    columns: [{
        xtype: 'gridcolumn',
        draggable: false,
        hideable: false,
        dataIndex: 'title',
        text: 'Titre',
        align: 'center',
        filterable: true
	}]
});
