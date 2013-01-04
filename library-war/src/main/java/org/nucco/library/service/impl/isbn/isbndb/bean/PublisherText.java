package org.nucco.library.service.impl.isbn.isbndb.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "PublisherText")
public class PublisherText {

	public String getPublisherId() {
		return publisherId;
	}

	@XmlAttribute(name = "publisher_id")
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getDescription() {
		return description;
	}

	@XmlValue
	public void setDescription(String description) {
		this.description = description;
	}

	private String publisherId;
	private String description;

}
