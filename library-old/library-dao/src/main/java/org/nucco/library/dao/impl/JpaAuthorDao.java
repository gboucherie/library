package org.nucco.library.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.nucco.library.bean.Author;
import org.nucco.library.bean.Author_;
import org.nucco.library.dao.api.AuthorDao;

@Stateless
public class JpaAuthorDao implements AuthorDao {

	@Override
	public List<Author> list() {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Author> criteria = builder.createQuery(Author.class);
		criteria.select(criteria.from(Author.class));

		return this.em.createQuery(criteria).getResultList();
	}

	@Override
	public Author get(String firstname, String lastname) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Author> c = cb.createQuery(Author.class);
		Root<Author> a = c.from(Author.class);
		c.select(c.from(Author.class)).where(cb.and(cb.equal(a.get(Author_.firstname), firstname), cb.equal(a.get(Author_.lastname), lastname)));

		Author result = null;

		try {
			result = em.createQuery(c).getSingleResult();
		} catch(NoResultException e) {
			// do nothing, if an author does not exist we just want to return null
		}

		return result;
	}

	@Override
	public List<Author> search(String query) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Author> c = cb.createQuery(Author.class);
		Root<Author> a = c.from(Author.class);
		c.select(c.from(Author.class)).where(cb.or(cb.like(a.get(Author_.firstname), query + "%"), cb.like(a.get(Author_.lastname), query + "%")));

		return em.createQuery(c).getResultList();
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	private EntityManager em;

}
