package org.nucco.library.service.impl.isbn.isbndb.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "Authors")
@XmlSeeAlso(Person.class)
public class Authors {

	public List<Person> getPersons() {
		return persons;
	}

	@XmlAnyElement(lax = true)
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	private List<Person> persons;

}
