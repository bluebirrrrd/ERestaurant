package com.bionic.edu.ERestro;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Basic(optional = false)
	@Column(name = "Time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private Customer customer;
	private double total;
	
	private int delivered;
/*	@JoinTable(name="OrderFood",
			   joinColumns=@JoinColumn(name="orderId"),
			   inverseJoinColumns=
					@JoinColumn(name="foodId"))
	private Collection<Food> content;
	*/
	@OneToMany(mappedBy="orderId", cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Collection<Food_Order> content;
	
	public Orders() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
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

	public int getDelivered() {
		return delivered;
	}

	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}

	public Collection<Food_Order> getContent() {
		return content;
	}

	public void setContent(Collection<Food_Order> content) {
		this.content = content;
	}
	
}
