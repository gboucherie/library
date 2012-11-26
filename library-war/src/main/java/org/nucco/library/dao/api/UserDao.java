package org.nucco.library.dao.api;

import org.nucco.library.bean.User;

public interface UserDao {

	/**
	 * Find a user by email.
	 * 
	 * @param email user's email
	 * @return the user attach to the email
	 */
	User find(String email);

}
