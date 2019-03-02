package com.avalah.clientlist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = -5855609794204464126L;

	@Id
	@Column(name = "client_username")
	@Size(max = 100)
	private String username;

	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@Column(name = "first_name")
	@Size(max = 100)
	private String firstName;

	@Column(name = "last_name")
	@Size(max = 100)
	private String lastName;

	@Column(name = "email")
	@Size(max = 255)
	private String email;

	@Column(name = "address")
	@Size(max = 1000)
	private String address;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
