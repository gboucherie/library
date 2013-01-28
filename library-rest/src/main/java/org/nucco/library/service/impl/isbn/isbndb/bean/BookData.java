package org.nucco.library.service.impl.isbn.isbndb.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BookData")
public class BookData {

	public String getBookId() {
		return bookId;
	}

	@XmlAttribute(name = "book_id")
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	@XmlAttribute
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn13() {
		return isbn13;
	}

	@XmlAttribute
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement(name = "Title")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleLong() {
		return titleLong;
	}

	@XmlElement(name = "TitleLong")
	public void setTitleLong(String titleLong) {
		this.titleLong = titleLong;
	}

	public String getAuthorsText() {
		return authorsText;
	}

	@XmlElement(name = "AuthorsText")
	public void setAuthorsText(String authorsText) {
		this.authorsText = authorsText;
	}

	public PublisherText getPublisherText() {
		return publisherText;
	}

	@XmlElement(name = "PublisherText")
	public void setPublisherText(PublisherText publisherText) {
		this.publisherText = publisherText;
	}

	public Details getDetails() {
		return details;
	}

	@XmlElement(name = "Details")
	public void setDetails(Details details) {
		this.details = details;
	}

	public String getSummary() {
		return summary;
	}

	@XmlElement(name = "Summary")
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getNotes() {
		return notes;
	}

	@XmlElement(name = "Notes")
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getUrlsText() {
		return urlsText;
	}

	@XmlElement(name = "UrlsText")
	public void setUrlsText(String urlsText) {
		this.urlsText = urlsText;
	}

	public String getAwardsText() {
		return awardsText;
	}

	@XmlElement(name = "AwardsText")
	public void setAwardsText(String awardsText) {
		this.awardsText = awardsText;
	}

	public Authors getAuthors() {
		return authors;
	}

	@XmlElement(name = "Authors")
	public void setAuthors(Authors authors) {
		this.authors = authors;
	}

	private String bookId;
	private String isbn;
	private String isbn13;
	private String title;
	private String titleLong;
	private String authorsText;
	private PublisherText publisherText;
	private Details details;
	private String summary;
	private String notes;
	private String urlsText;
	private String awardsText;
	private Authors authors;

}
