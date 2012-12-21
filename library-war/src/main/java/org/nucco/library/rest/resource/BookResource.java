package org.nucco.library.rest.resource;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
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

import org.nucco.library.bean.Author;
import org.nucco.library.bean.Book;
import org.nucco.library.dao.api.AuthorDao;
import org.nucco.library.dao.api.BookDao;
import org.nucco.library.rest.bean.BookDTO;
import org.nucco.library.rest.bean.ResponseWrapper;
import org.nucco.library.service.api.DTOService;
import org.nucco.library.service.api.ISBNService;

@Path("/books")
@ManagedBean
public class BookResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseWrapper<BookDTO> list(@QueryParam("start") int start, @QueryParam("limit") int limit) {
		List<BookDTO> books = dtoService.map(BookDTO.class, bookDao.list(start, limit));
		ResponseWrapper<BookDTO> response = new ResponseWrapper<BookDTO>();

		response.setData(books);
		response.setCount(bookDao.count());
		response.setStatus(true);

		return response;
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseWrapper<BookDTO> add(BookDTO bookDto) {
		ResponseWrapper<BookDTO> response = new ResponseWrapper<BookDTO>();
		Book book = dtoService.map(Book.class, bookDto);
		Author author = authorDao.get(book.getAuthor().getFirstname(), book.getAuthor().getLastname());

		if (author != null) {
			book.setAuthor(author);
		}

		response.setCount(1);
		response.setData(dtoService.map(BookDTO.class, bookDao.add(book)));
		response.setStatus(true);

		return response;
	}

	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(BookDTO bookDto) {
		Book book = dtoService.map(Book.class, bookDto);
		Author author = authorDao.get(book.getAuthor().getFirstname(), book.getAuthor().getLastname());

		if (author != null) {
			book.setAuthor(author);
		}

		bookDao.update(book);
	}

	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public void delete(@PathParam("id") Long bookId) {
		bookDao.remove(bookDao.get(bookId));
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
	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	@Inject
	@Named("dozer")
	public void setDtoService(DTOService dtoService) {
		this.dtoService = dtoService;
	}

	@Inject
	public void setIsbnService(ISBNService isbnService) {
		this.isbnService = isbnService;
	}

	private BookDao bookDao;
	private AuthorDao authorDao;
	private DTOService dtoService;
	private ISBNService isbnService;

}
