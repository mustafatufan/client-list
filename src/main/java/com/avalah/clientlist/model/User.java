package com.avalah.clientlist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -3584150858539695521L;

	@Id
	@Column(name = "username")
	@Size(max = 100)
	private String username;

	@Column(name = "password")
	@Size(max = 100)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
