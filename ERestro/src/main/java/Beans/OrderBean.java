package Beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.*;
import javax.inject.*;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.Scope;

import Services.FoodService;
import Services.Food_OrderService;
import Services.OrderService;

import com.bionic.edu.ERestro.Customer;
import com.bionic.edu.ERestro.DeliveryStatus;
import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.Food_Order;
import com.bionic.edu.ERestro.Orders;

import javax.faces.event.AjaxBehaviorEvent;

@Named
@Scope("session")
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Orders order;

	private List<Food_Order> content = new LinkedList<Food_Order>();
	private Food_Order item;
	@Inject
	private OrderService orderService;
	@Inject
	private Food_OrderService foodOrderService;
	@Inject
	private FoodService foodService;

	private double total;
	@Inject
	private CustomerBean customer;

	private int quantity;
	private Food dish;
	private int itemQuantity;

	public OrderBean() {
		order = new Orders();
		total = 0.0;
		item = new Food_Order();
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Food_Order getItem() {
		return item;
	}

	public void setItem(Food_Order item) {
		this.item = item;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Food getDish() {
		return dish;
	}

	public void setDish(Food dish) {
		this.dish = dish;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public void countTotal() {
		total = 0;
		Iterator<Food_Order> it = content.iterator();
		while (it.hasNext()) {
			Food_Order temp = it.next();
			total += temp.getFood().getPrice() * temp.getQuantity();
		}
		total = Math.round(total * 100) / 100;
		order.setTotal(total);
	}

	public String addItem(String dishId) {
		item.setOrder(order);
		Food dish = foodService.findById(Integer.valueOf(dishId));
		item.setFood(dish);
		content.add(item);
		order.setContent(content);
		countTotal();
		this.quantity = content.size();
		item = new Food_Order();
		return "index";
	}

	public String edit_quantity(String foodId, String quantity) {
		Iterator<Food_Order> it = content.iterator();
		while (it.hasNext()) {
			Food_Order temp = it.next();
			if (temp.getFood().getId() == Integer.valueOf(foodId)) {
				if (Integer.valueOf(quantity) != 0) {
					temp.setQuantity(Integer.valueOf(quantity));
					it.remove();
					content.add(temp);
					order.setContent(content);
					break;
				} else {
					it.remove();
					order.setContent(content);
					break;
				}
			}
		}
		countTotal();
		return "profile";
	}

	public String removeItem(Food food) {
		Iterator<Food_Order> it = content.iterator();
		while (it.hasNext()) {
			Food_Order temp = it.next();
			if (temp.getFood().getName().equals(food.getName())) {
				it.remove();
				order.setContent(content);
				quantity = content.size();
				break;
			}
		}
		countTotal();
		return "editOrder";
	}

	public String proceedOrder() {
		order.setContent(content);
		countTotal();
		order.setTotal(total);
		order.setCustomer(customer.getCustomer());
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		order.setTime(currentTimestamp);
		return "profile";
	}

	public String confirmOrder() {

		order.setCustomer(customer.getCustomer());

		for (Food_Order f : content) {
			foodOrderService.save(f);
		}
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		order.setTime(currentTimestamp);

		orderService.save(order);
		return "profile";
	}

	public String setDone(String orderId) {

		order = orderService.findById(Integer.valueOf(orderId));
		order.setDelivered(1);
		orderService.save(order);
		
		return "delivery";
	}

	public void changeQuantity(AjaxBehaviorEvent event) {
		this.item.setQuantity(itemQuantity);
	}
}