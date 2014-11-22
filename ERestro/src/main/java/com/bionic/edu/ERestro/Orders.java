package com.bionic.edu.ERestro;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private java.sql.Timestamp time;
	@ManyToOne
	@JoinColumn(name="userId")
	private Customer customer;
	private double total;
	@ManyToOne
	@JoinColumn(name="deliveryStatusId")
	private DeliveryStatus delStat;
/*	@JoinTable(name="OrderFood",
			   joinColumns=@JoinColumn(name="orderId"),
			   inverseJoinColumns=
					@JoinColumn(name="foodId"))
	private Collection<Food> content;
	*/
	@OneToMany(mappedBy="orderId")
	private Collection<Food_Order> content;
	
	public Orders() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer user) {
		this.customer = user;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public DeliveryStatus getDelStat() {
		return delStat;
	}

	public void setDelStat(DeliveryStatus delStat) {
		this.delStat = delStat;
	}

	public Collection<Food_Order> getContent() {
		return content;
	}

	public void setContent(Collection<Food_Order> content) {
		this.content = content;
	}
	
}
