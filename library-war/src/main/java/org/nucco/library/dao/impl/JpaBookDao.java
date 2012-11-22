package org.nucco.library.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.nucco.library.bean.Book;
import org.nucco.library.dao.api.BookDao;

@Stateless
public class JpaBookDao implements BookDao {

	@Override
	public List<Book> list(int start, int limit) {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
		criteria.select(criteria.from(Book.class));

		return this.em.createQuery(criteria).setFirstResult(start).setMaxResults(limit).getResultList();
	}

	@Override
	public long count() {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		criteria.select(builder.count(criteria.from(Book.class)));

		return this.em.createQuery(criteria).getSingleResult();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Book add(Book book) {
		return this.em.merge(book);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Book book) {
		this.em.merge(book);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(Book book) {
		this.em.remove(this.em.merge(book));
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	private EntityManager em;

}
