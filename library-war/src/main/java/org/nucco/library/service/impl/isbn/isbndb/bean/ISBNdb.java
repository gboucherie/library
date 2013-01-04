package org.nucco.library.service.impl.isbn.isbndb.bean;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "ISBNdb")
@XmlSeeAlso(BookList.class)
public class ISBNdb {

	public Calendar getServerTime() {
		return serverTime;
	}

	@XmlAttribute(name = "server_time")
	public void setServerTime(Calendar serverTime) {
		this.serverTime = serverTime;
	}

	public BookList getBookList() {
		return bookList;
	}

	@XmlElement(name = "BookList")
	public void setBookList(BookList bookList) {
		this.bookList = bookList;
	}

	private Calendar serverTime;
	private BookList bookList;

}
