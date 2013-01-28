package org.nucco.library.service.impl.isbn.google;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Named;
import javax.inject.Singleton;

import org.nucco.library.rest.bean.BookDTO;
import org.nucco.library.service.api.ISBNService;
import org.nucco.library.service.impl.isbn.google.bean.SearchResult;
import org.nucco.library.service.impl.isbn.google.bean.VolumeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

@Named
@Singleton
public class GoogleBookService implements ISBNService {

	@Override
	public String getName() {
		return "google";
	}

	@Override
	public BookDTO getBook(String isbn) {
		BookDTO book = null;

		try {
			URL url = new URL(BOOKS_API_URL + ACCESS_KEY + BY_ISBN + isbn);
			Gson gson = new Gson();
			SearchResult result = gson.fromJson(new InputStreamReader(url.openStream()), SearchResult.class);
			if (result.getTotalItems() > 0) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				book = new BookDTO();
				VolumeInfo volumeInfo = result.getItems().get(0).getVolumeInfo();

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dateFormat.parse(volumeInfo.getPublishedDate()));

				book.setTitle(volumeInfo.getTitle());
				book.setYear(calendar.get(Calendar.YEAR));
				book.setAuthor(volumeInfo.getAuthors().get(0));
			}
		} catch (MalformedURLException e) {
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} catch (ParseException e) {
			LOG.error(e.getMessage(), e);
		}

		return book;
	}

	private static final String SERVICE_URL = "https://www.googleapis.com";
	private static final String BOOKS_API_URL = SERVICE_URL + "/books/v1/volumes";
	private static final String ACCESS_KEY = "?key=AIzaSyC3xWOGAG1-qss46-rAuQ1uyPIGvqvxzrg";
	private static final String BY_ISBN = "&q=isbn";

	private static final Logger LOG = LoggerFactory.getLogger(GoogleBookService.class);

}
