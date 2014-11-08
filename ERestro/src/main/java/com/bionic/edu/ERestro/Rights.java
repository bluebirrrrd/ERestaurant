package com.bionic.edu.ERestro;

import javax.persistence.*;

@Entity
public class Rights {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String role;
	
	public Rights() {	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
