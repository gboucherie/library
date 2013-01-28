package org.nucco.library.dao.api;

import javax.ejb.Remote;

import org.nucco.library.bean.User;

@Remote
public interface UserDao {

	/**
	 * Find a user by email.
	 * 
	 * @param email user's email
	 * @return the user attach to the email
	 */
	User find(String email);

	/**
	 * Add a new user.
	 * 
	 * @param user the new user to add
	 */
	void add(User user);

}
