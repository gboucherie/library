package org.nucco.library.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.nucco.library.bean.Book;
import org.nucco.library.dao.api.BookDao;

public class JpaBookDao implements BookDao {

	@Override
	public List<Book> list() {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
		Root<Book> books = criteria.from(Book.class);
		criteria.select(books);

		return this.em.createQuery(criteria).getResultList();
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	private EntityManager em;

}
