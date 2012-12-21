package org.nucco.library.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USERS")
@XmlRootElement
public class User {

	@Id
	@Column(nullable = false, unique = true, length = 128)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false, length = 128)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(nullable = false, length = 128)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
     * A sha512 is 512 bits long -- as its name indicates. If you are using an hexadecimal representation, 
     * each digit codes for 4 bits ; so you need 512 : 4 = 128 digits to represent 512 bits -- so, you need a varchar(128), 
     * or a char(128), as the length is always the same, not varying at all.
     */
	@Column(nullable = false, length = 128)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(Date registeredOn) {
		this.registeredOn = registeredOn;
	}

	@ElementCollection(targetClass = Group.class)
	@CollectionTable(name = "USERS_GROUPS",
					joinColumns = @JoinColumn(name = "email", nullable = false),
					uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "groupname"})})
	@Enumerated(EnumType.STRING)
	@Column(name = "groupname", nullable = false, length = 64)
	public List<Group> getGroups() {
		return groups;
	}

	@XmlElement(name = "roles")
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Column(nullable = false)
	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	private Date registeredOn;

	private List<Group> groups;

	private Boolean activated;

}
