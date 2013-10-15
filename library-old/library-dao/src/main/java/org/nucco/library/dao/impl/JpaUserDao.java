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

	@Override
	public void add(User user) {
		em.merge(user);
	}

	@PersistenceContext
	private EntityManager em;

}
