package org.nucco.library.service.impl.isbn.isbndb.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "BookList")
@XmlSeeAlso(BookData.class)
public class BookList {

	public int getTotalResults() {
		return totalResults;
	}

	@XmlAttribute(name = "total_results")
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public int getPageSize() {
		return pageSize;
	}

	@XmlAttribute(name = "page_size")
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	@XmlAttribute(name = "page_number")
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getShownResults() {
		return shownResults;
	}

	@XmlAttribute(name = "shown_results")
	public void setShownResults(int shownResults) {
		this.shownResults = shownResults;
	}

	public List<BookData> getBooks() {
		return books;
	}

	@XmlAnyElement(lax = true)
	public void setBooks(List<BookData> books) {
		this.books = books;
	}

	private int totalResults;
	private int pageSize;
	private int pageNumber;
	private int shownResults;
	private List<BookData> books;

}
