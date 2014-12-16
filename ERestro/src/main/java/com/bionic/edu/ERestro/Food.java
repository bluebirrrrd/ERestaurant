package com.bionic.edu.ERestro;

import javax.persistence.*;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private FoodCategory category;
	private short kitchenMade;
	private double price;
	private short available;
	@Lob
	private byte[] photo;

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Food() {
		available = 1;
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
		return kitchenMade > 0 ? true : false;
	}

	public void setKitchenMade(boolean kitchenMade) {
		if (kitchenMade == true) {
			this.kitchenMade = 1;
		} else {
			this.kitchenMade = 0;
		}

	}
	
	

	public short getKitchenMade() {
		return kitchenMade;
	}

	public void setKitchenMade(short kitchenMade) {
		this.kitchenMade = kitchenMade;
	}

	public short getAvailable() {
		return available;
	}

	public void setAvailable(short available) {
		this.available = available;
	}
	
	public void setAvailable(int available) {
		this.available = (short)available;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return (available > 0 ? true : false);
	}

	public void setAvailable(boolean available) {
		if (available == true) {
			this.available = 1;
		} else {
			this.available = 0;
		}
	}
}
