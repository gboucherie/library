package org.nucco.library.dao.api;

import java.util.List;

import javax.ejb.Remote;

import org.nucco.library.bean.Author;

@Remote
public interface AuthorDao {

	/**
	 * Return the list of authors. If no authors return
	 * an empty list.
	 * 
	 * @return a list of {@link Author}
	 */
	List<Author> list();

	/**
	 * Get unique author by its first name and last name.
	 * 
	 * @param firstname firstname's author
	 * @param lastname lastname's author
	 * @return an {@link Author} or null if no corresponding author found
	 */
	Author get(String firstname, String lastname);

	List<Author> search(String query);

}
