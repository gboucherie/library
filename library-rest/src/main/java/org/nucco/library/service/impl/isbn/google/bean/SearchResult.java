package org.nucco.library.service.impl.isbn.google.bean;

import java.util.List;

public class SearchResult {

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	private int totalItems = 0;
	private List<Item> items;

}
