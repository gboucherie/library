package org.nucco.library.service.impl.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Person")
public class Person {

	public String getPersonId() {
		return personId;
	}

	@XmlAttribute(name = "person_id")
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getDescription() {
		return description;
	}

	@XmlValue
	public void setDescription(String description) {
		this.description = description;
	}

	private String personId;
	private String description;

}
