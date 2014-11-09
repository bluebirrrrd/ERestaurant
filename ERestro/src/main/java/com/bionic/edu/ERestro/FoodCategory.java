package com.bionic.edu.ERestro;

import javax.persistence.*;

@Entity
public class FoodCategory {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	public FoodCategory() { }
	public FoodCategory(String name) {
		this.name = name;
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
	
}
