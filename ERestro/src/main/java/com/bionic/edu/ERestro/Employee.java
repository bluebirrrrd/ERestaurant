package com.bionic.edu.ERestro;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private java.sql.Date birthDate;
	private short valid;
	@ManyToOne
	@JoinColumn(name="accessId")
	private Rights access;
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee() {	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.sql.Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isValid() {
		return valid>0?true:false;
	}

	public void setValid(boolean valid) {
		if (valid == true) {
		this.valid = 1; }
		else {
			this.valid = 0;
		}
	}

	public Rights getAccess() {
		return access;
	}

	public void setAccess(Rights access) {
		this.access = access;
	}
	
	
	
	
}
