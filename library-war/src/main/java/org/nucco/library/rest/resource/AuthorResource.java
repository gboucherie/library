package org.nucco.library.rest.resource;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nucco.library.bean.Author;
import org.nucco.library.dao.api.AuthorDao;
import org.nucco.library.rest.bean.ResponseWrapper;

@Path("/authors")
@ManagedBean
public class AuthorResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseWrapper<Author> list(@QueryParam("query") String query) {
		List<Author> authors = null;
		ResponseWrapper<Author> response = new ResponseWrapper<Author>();

		if (query != null) {
			authors = authorDao.search(query);
		} else {
			authors = authorDao.list();
		}

		response.setData(authors);
		response.setCount(authors.size());
		response.setStatus(true);

		return response;
	}

	@EJB
	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	private AuthorDao authorDao;

}
