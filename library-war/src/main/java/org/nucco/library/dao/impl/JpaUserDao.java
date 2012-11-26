package org.nucco.library.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.nucco.library.bean.User;
import org.nucco.library.dao.api.UserDao;

@Stateless
public class JpaUserDao implements UserDao {

	@Override
	public User find(String email) {
		return em.find(User.class, email);
	}

	@PersistenceContext
	private EntityManager em;

}
