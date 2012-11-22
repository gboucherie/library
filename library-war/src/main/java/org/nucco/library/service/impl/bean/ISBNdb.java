package org.nucco.library.service.impl.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "ISBNdb")
@XmlSeeAlso({BookData.class})
public class ISBNdb {

	public List<BookData> getBooks() {
		return books;
	}

	public void setBooks(List<BookData> books) {
		this.books = books;
	}

	private List<BookData> books;

}
