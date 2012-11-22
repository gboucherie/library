package org.nucco.library.service.impl.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BookData")
public class BookData {

	@XmlElement(name = "Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "TitleLong")
	public String getTitleLong() {
		return titleLong;
	}

	public void setTitleLong(String titleLong) {
		this.titleLong = titleLong;
	}

	@XmlElement(name = "AuthorsText")
	public String getAuthorsText() {
		return authorsText;
	}

	public void setAuthorsText(String authorsText) {
		this.authorsText = authorsText;
	}

	public String title;
	public String titleLong;
	public String authorsText;

}
