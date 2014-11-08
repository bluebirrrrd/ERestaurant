package com.bionic.edu.ERestro;

import javax.persistence.*;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@ManyToOne
	@JoinColumn(name="categoryId")
	private FoodCategory category;
	private short kitchenMade;
	private double price;
	
	public Food() {  }

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FoodCategory getCategory() {
		return category;
	}

	public void setCategory(FoodCategory category) {
		this.category = category;
	}

	public boolean isKitchenMade() {
		return kitchenMade>0?true:false;
	}

	public void setKitchenMade(short kitchenMade) {
		this.kitchenMade = kitchenMade;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
