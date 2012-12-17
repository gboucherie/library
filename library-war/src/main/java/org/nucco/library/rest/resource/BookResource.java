package org.nucco.library.rest.resource;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nucco.library.bean.Book;
import org.nucco.library.dao.api.BookDao;
import org.nucco.library.rest.bean.ResponseWrapper;
import org.nucco.library.service.api.ISBNService;

@Path("/books")
@ManagedBean
public class BookResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseWrapper<Book> list(@QueryParam("start") int start, @QueryParam("limit") int limit) {
		List<Book> books = bookDao.list(start, limit);
		long count = bookDao.count();
		ResponseWrapper<Book> response = new ResponseWrapper<Book>();

		response.setData(books);
		response.setCount(count);
		response.setStatus(true);

		return response;
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseWrapper<Book> add(Book book) {
		ResponseWrapper<Book> response = new ResponseWrapper<Book>();
		response.setCount(1);
		response.setData(bookDao.add(book));
		response.setStatus(true);

		return response;
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

	@GET
	@Path("/isbn/{isbn}")
	@Produces({MediaType.APPLICATION_JSON})
	public Book getFromIsbn(@PathParam("isbn") String isbn) {
		return isbnService.getBook(isbn);
	}

	@Inject
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Inject
	public void setIsbnService(ISBNService isbnService) {
		this.isbnService = isbnService;
	}

	private BookDao bookDao;
	private ISBNService isbnService;

}
