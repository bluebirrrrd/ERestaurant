package com.bionic.edu.ERestro;

import javax.persistence.*;

@Entity
public class Food_Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="orderId")
	private Orders orderId;
	@ManyToOne
	@JoinColumn(name="foodId")
	private Food food;
	private int quantity;
	private short done;
	
	public boolean isDone() {
		return (done>0?true:false);
	}

	public void setDone(boolean done) {
		if (done==true) {
			this.done = 1;
		} else {
			this.done = 0;
		}
	}
	public void setDone(int done) {
		this.done = (short)done;
	}

	public Food_Order() {	
		quantity = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrder() {
		return orderId;
	}

	public void setOrder(Orders order) {
		this.orderId = order;
	}
	
	

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
