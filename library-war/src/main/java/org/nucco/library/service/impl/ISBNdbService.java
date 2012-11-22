package org.nucco.library.service.impl;

import java.io.IOException;

import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.nucco.library.bean.Book;
import org.nucco.library.service.api.ISBNService;
import org.nucco.library.service.impl.bean.ISBNdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class ISBNdbService implements ISBNService {

	@Override
	public Book getBook(String isbn) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(BOOKS_API_URL + "?access_key=2EH2LR35&index1=isbn&value1=" + isbn);
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			JAXBContext context = JAXBContext.newInstance(ISBNdb.class);
			StreamSource xml = new StreamSource(entity.getContent());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ISBNdb value = unmarshaller.unmarshal(xml, ISBNdb.class).getValue();
			
		} catch (ClientProtocolException e) {
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} catch (JAXBException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			httpGet.releaseConnection();
		}

		return null;
	}

	private static final String SERVICE_URL = "http://isbndb.com";
	private static final String BOOKS_API_URL = SERVICE_URL + "/api/books";
	private static final Logger LOG = LoggerFactory.getLogger(ISBNdbService.class);

}
