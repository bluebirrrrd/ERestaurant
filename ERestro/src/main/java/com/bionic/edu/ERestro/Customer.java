package com.bionic.edu.ERestro;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private java.sql.Date birthDate;
	private String billingAddress;
	private short valid;
	private String password;
	
	public Customer() {
		valid = (short)1;
	}
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
	
	public void setBirthDate(java.util.Date birthDate) {
		if (birthDate != null){
		Instant instant = Instant.ofEpochMilli(birthDate.getTime());
		LocalDate res = LocalDateTime.ofInstant(instant,ZoneId.systemDefault()).toLocalDate();
		this.birthDate = java.sql.Date.valueOf(res);
		} 
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public short getValid() {
		return valid;
	}
	public void setValid(short valid) {
		this.valid = valid;
	}
	public boolean isValid() {
		if (valid == 0) { return false; }
		else return true;
	}
	public void setValid(int valid) {
		this.valid = (short)valid;
	}
	public void setValid(String valid) {
		int res = Integer.valueOf(valid);
		this.valid = (short)res;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
