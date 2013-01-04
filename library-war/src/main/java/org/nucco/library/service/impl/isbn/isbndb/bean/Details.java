package org.nucco.library.service.impl.isbn.isbndb.bean;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAttribute;

public class Details {

	public Calendar getChangeTime() {
		return changeTime;
	}

	@XmlAttribute(name = "change_time")
	public void setChangeTime(Calendar changeTime) {
		this.changeTime = changeTime;
	}

	public Calendar getPriceTime() {
		return priceTime;
	}

	@XmlAttribute(name = "price_time")
	public void setPriceTime(Calendar priceTime) {
		this.priceTime = priceTime;
	}

	public String getEditionInfo() {
		return editionInfo;
	}

	@XmlAttribute(name = "edition_info")
	public void setEditionInfo(String editionInfo) {
		this.editionInfo = editionInfo;
	}

	public String getLanguage() {
		return language;
	}

	@XmlAttribute
	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPhysicalDescriptionText() {
		return physicalDescriptionText;
	}

	@XmlAttribute(name = "physical_description_text")
	public void setPhysicalDescriptionText(String physicalDescriptionText) {
		this.physicalDescriptionText = physicalDescriptionText;
	}

	public String getLccNumber() {
		return lccNumber;
	}

	@XmlAttribute(name = "lcc_number")
	public void setLccNumber(String lccNumber) {
		this.lccNumber = lccNumber;
	}

	public String getDeweyDecimalNormalized() {
		return deweyDecimalNormalized;
	}

	@XmlAttribute(name = "dewey_decimal_normalized")
	public void setDeweyDecimalNormalized(String deweyDecimalNormalized) {
		this.deweyDecimalNormalized = deweyDecimalNormalized;
	}

	public String getDeweyDecimal() {
		return deweyDecimal;
	}

	@XmlAttribute(name = "dewey_decimal")
	public void setDeweyDecimal(String deweyDecimal) {
		this.deweyDecimal = deweyDecimal;
	}

	private Calendar changeTime;
	private Calendar priceTime;
	private String editionInfo;
	private String language;
	private String physicalDescriptionText;
	private String lccNumber;
	private String deweyDecimalNormalized;
	private String deweyDecimal;

}
