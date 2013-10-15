package org.nucco.library.service.impl.isbn.isbndb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.nucco.library.rest.bean.BookDTO;
import org.nucco.library.service.api.ISBNService;
import org.nucco.library.service.impl.isbn.isbndb.bean.BookData;
import org.nucco.library.service.impl.isbn.isbndb.bean.BookList;
import org.nucco.library.service.impl.isbn.isbndb.bean.ISBNdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@Singleton
public class ISBNdbService implements ISBNService {

	@Override
	public String getName() {
		return "isbndb";
	}

	@Override
	public BookDTO getBook(String isbn) {
		BookDTO book = null;

		try {
			URL url = new URL(BOOKS_API_URL + ACCESS_KEY + ADD_TEXTS + ADD_DETAILS + ADD_AUTHORS + BY_ISBN + isbn);
			JAXBContext context = JAXBContext.newInstance(ISBNdb.class);
			StreamSource xml = new StreamSource(url.openStream());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ISBNdb value = unmarshaller.unmarshal(xml, ISBNdb.class).getValue();
			BookList bookList = value.getBookList();
			if (bookList.getTotalResults() > 0) {
				BookData bookData = bookList.getBooks().get(0);
				book = new BookDTO();
				book.setTitle(bookData.getTitle());
	//			book.setAuthor(bookData.getAuthorsText());
			}

		} catch (JAXBException e) {
			LOG.error(e.getMessage(), e);
		} catch (MalformedURLException e) {
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}

		return book;
	}

	private static final String SERVICE_URL = "https://isbndb.com";
	private static final String BOOKS_API_URL = SERVICE_URL + "/api/books.xml";
	private static final String ACCESS_KEY = "?access_key=2EH2LR35";
	private static final String ADD_TEXTS = "&results=texts";
	private static final String ADD_DETAILS = "&results=details";
	private static final String ADD_AUTHORS = "&results=authors";
	private static final String BY_ISBN = "&index1=isbn&value1=";

	private static final Logger LOG = LoggerFactory.getLogger(ISBNdbService.class);

}
