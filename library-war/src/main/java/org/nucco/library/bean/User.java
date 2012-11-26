package org.nucco.library.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 128)
	private String email;

	@Column(nullable = false, length = 128)
	private String firstName;

	@Column(nullable = false, length = 128)
	private String lastName;

	/**
     * A sha512 is 512 bits long -- as its name indicates. If you are using an hexadecimal representation, 
     * each digit codes for 4 bits ; so you need 512 : 4 = 128 digits to represent 512 bits -- so, you need a varchar(128), 
     * or a char(128), as the length is always the same, not varying at all.
     */
	@Column(nullable = false, length = 128)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date registeredOn;

	@ElementCollection
	@CollectionTable
	@Enumerated
	@Column(name = "groupname", nullable = false, length = 64)
	private List<Group> groups;

	@Column(nullable = false)
	private Boolean activated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(Date registeredOn) {
		this.registeredOn = registeredOn;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

}
