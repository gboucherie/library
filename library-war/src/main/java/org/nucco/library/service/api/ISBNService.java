package org.nucco.library.service.api;

import org.nucco.library.rest.bean.BookDTO;

public interface ISBNService {

	String getName();

	/**
	 * Retrieve the book informations' by its ISBN number.
	 * 
	 * @param isbn an isbn number
	 * @return a {@link BookDTO} instance corresponding to the isbn or null if not found
	 */
	BookDTO getBook(String isbn);

}
