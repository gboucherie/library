package org.nucco.library.rest.resource;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nucco.library.bean.Book;
import org.nucco.library.dao.api.BookDao;
import org.nucco.library.rest.bean.ExtJsWrapper;

@Path("/books")
@ManagedBean
public class BookResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ExtJsWrapper<Book> list() {
		return new ExtJsWrapper<Book>(bookDao.list(), null);
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Book add(Book book) {
		return bookDao.add(book);
	}

	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Book book) {
		bookDao.update(book);
	}

	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public void delete(Book book) {
		bookDao.remove(book);
	}

	@Inject
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	private BookDao bookDao;

}
