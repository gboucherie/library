package org.nucco.library.dao.api;

import java.util.List;

import org.nucco.library.bean.Book;

public interface BookDao {

	/**
	 * Return the list of books stock in database. If no
	 * books are stock return an empty list.
	 * 
	 * @return a list of books
	 */
	List<Book> list();

}
