package Beans;

import java.io.Serializable;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import Services.FoodService;
import Services.OrderService;

import com.bionic.edu.ERestro.DeliveryStatus;
import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.Food_Order;
import com.bionic.edu.ERestro.Orders;

@Named
@Scope("session")
public class OrderBeanNew implements Serializable {
	
	private Orders order;
	private List<Food_Order> content;
	private Timestamp time;
	private int quantity;
	
	@Inject
	private CustomerBean customerBean;
	
	@Inject
	private Food_OrderBean item;
	
	@Inject
	private OrderService orderService;
	
	@Inject 
	private FoodService foodService;
	
	public OrderBeanNew() {
		content = new ArrayList<Food_Order>();
		order = new Orders();
	}
	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public List<Food_Order> getContent() {
		return content;
	}
	public void setContent(List<Food_Order> content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void countTotal() {
		double total = 0.0;
		Iterator<Food_Order> it = content.iterator();
		while (it.hasNext()) {
			Food_Order temp = it.next();
			total += temp.getQuantity()*temp.getFood().getPrice();
		}
		order.setTotal(total);
	}
	
	public String addItem(String dishId) {
		quantity= 0;
		Food_Order temp = item.getPart();
		temp.setOrder(order);
		Food dish = foodService.findById(Integer.valueOf(dishId));
		temp.setFood(dish);
		content.add(temp);
		Iterator<Food_Order> it = content.iterator();
		while (it.hasNext()) {
			Food_Order tempItem = it.next();
			quantity += tempItem.getQuantity();
		}
		countTotal();
		return "index";
		
	}
	
	public String proceedOrder() {
		return "profile";
	}
	
	public String confirmOrder() {
		order.setContent(content);
		countTotal();
		order.setCustomer(customerBean.getCustomer());
		time = new Timestamp(System.currentTimeMillis());
		order.setTime(time);
		order.setDelivered(0);
		
		orderService.save(order);
		
		return "index";
	}
	
	

}
