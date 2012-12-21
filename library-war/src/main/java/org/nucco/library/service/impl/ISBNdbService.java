package org.nucco.library.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.nucco.library.bean.Book;
import org.nucco.library.service.api.ISBNService;
import org.nucco.library.service.impl.bean.BookData;
import org.nucco.library.service.impl.bean.ISBNdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Named("isbndb")
public class ISBNdbService implements ISBNService {

	@Override
	public Book getBook(String isbn) {
		Book book = null;

		try {
			URL url = new URL(BOOKS_API_URL + ACCESS_KEY + ADD_TEXTS + ADD_DETAILS + ADD_AUTHORS + BY_ISBN + isbn);
			JAXBContext context = JAXBContext.newInstance(ISBNdb.class);
			StreamSource xml = new StreamSource(url.openStream());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ISBNdb value = unmarshaller.unmarshal(xml, ISBNdb.class).getValue();
			BookData bookData = value.getBookList().getBooks().get(0);

			book = new Book();
			book.setTitle(bookData.getTitle());
//			book.setAuthor(bookData.getAuthorsText());

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
