Ext.define("Library.view.book.List", {
	extend: 'Ext.grid.Panel',
	alias: 'widget.booklist',
	title: 'Livres',
	store: 'Books',
	selType: 'checkboxmodel',
	selModel: {
		mode: 'MULTI',
		checkOnly: true
	},
	columns: [{
		xtype: 'gridcolumn',
		draggable: false,
		hideable: false,
		dataIndex: 'title',
		text: 'Titre',
		align: 'left',
		filterable: true
	},{
		xtype: 'gridcolumn',
		draggable: false,
		hideable: false,
		dataIndex: 'author',
		text: 'Auteur',
		align: 'left',
		filterable: true
	},{
		xtype: 'gridcolumn',
		draggable: false,
		hideable: false,
		dataIndex: 'genre',
		text: 'Genre',
		align: 'left',
		filterable: true
	},{
		xtype: 'gridcolumn',
		draggable: false,
		hideable: false,
		dataIndex: 'year',
		text: 'Année',
		align: 'center',
		filterable: true
	}],
	dockedItems: [{
		xtype: 'toolbar',
		dock: 'top',
		items: [{
			text: 'Ajouter',
			tooltip: 'Ajouter un livre',
			action: 'add'
		}, '-', {
			text: 'Supprimer',
			tooltip: 'Supprimer les livres sélectionnés',
			action: 'delete'
		}]
	}]
});
