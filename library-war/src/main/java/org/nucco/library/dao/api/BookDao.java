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

	/**
	 * Add a new book in the database and return the instance
	 * of book that corresponding to this insert. The book id
	 * must be null as the database will generate one.
	 * 
	 * @param book the new book to add
	 * @return the corresponding object backed in database 
	 */
	Book add(Book book);

	/**
	 * Update the corresponding book in database with the new
	 * value. The book id must be a valid id of book in stock
	 * in database.
	 * 
	 * @param book the book to update
	 */
	void update(Book book);

	/**
	 * Remove the corresponding book from database.
	 * 
	 * @param book the book to remove
	 */
	void remove(Book book);

}
