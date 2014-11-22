package Beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.*;
import javax.inject.*;

import org.springframework.context.annotation.Scope;

import Services.Food_OrderService;
import Services.OrderService;

import com.bionic.edu.ERestro.Customer;
import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.Food_Order;
import com.bionic.edu.ERestro.Orders;

@Named
@Scope("session")
public class OrderBean {
	private Orders order;

	private List<Food_Order> content;

	@Inject
	private OrderService orderService;
	@Inject
	private Food_OrderService foodOrderService;

	private double total;
	private Customer customer;

	public OrderBean() {
		order = new Orders();
		content = null;
		total = 0.0;
		customer = new Customer();

		/*
		 * Orders order1 = new Orders();
		 * order1.setTime(java.sql.Timestamp.valueOf
		 * (java.time.LocalDateTime.now())); Food_Order part1 = new
		 * Food_Order(); part1.setFood((new FoodBean()).getDishes().get(1));
		 * part1.setOrder(order1); part1.setId(1); part1.setQuantity(2);
		 * part1.setDone(false); Food_Order part2 = new Food_Order();
		 * part2.setFood((new FoodBean()).getDishes().get(2));
		 * part2.setOrder(order1); part2.setId(2); part2.setQuantity(1);
		 * part2.setDone(false); List<Food_Order> content1 = new
		 * ArrayList<Food_Order>(); content1.add(part1); content1.add(part2);
		 * order1.setContent(content1);
		 * 
		 * orderList = new ArrayList<Orders>(); orderList.add(order1);
		 */
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void countTotal() {
		total = 0;
		Iterator<Food_Order> it = content.iterator();
		while (it.hasNext()) {
			Food_Order temp = it.next();
			total += temp.getFood().getPrice() * temp.getQuantity();
		}
	}

	public String addItem(Food food, String quantity) {
		Food_Order f = new Food_Order();
		f.setOrder(order);
		f.setFood(food);
		f.setQuantity(Integer.valueOf(quantity));
		content.add(f);
		order.setContent(content);
		countTotal();
		return "editOrder";
	}

	public String edit_quantity(Food food, String quantity) {
		Iterator<Food_Order> it = content.iterator();
		while (it.hasNext()) {
			Food_Order temp = it.next();
			if (temp.getFood().getName().equals(food.getName())) {
				temp.setQuantity(Integer.valueOf(quantity));
				it.remove();
				content.add(temp);
				order.setContent(content);
				break;
			}
		}
		countTotal();
		return "editOrder";
	}

	public String removeItem(Food food) {
		Iterator<Food_Order> it = content.iterator();
		while (it.hasNext()) {
			Food_Order temp = it.next();
			if (temp.getFood().getName().equals(food.getName())) {
				it.remove();
				order.setContent(content);
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
		return "confirmOrder";
	}

	public String confirmOrder(Customer customer) {
		this.customer = customer;
		order.setCustomer(customer);
		
		for (Food_Order f : content) {
			foodOrderService.save(f);
		}

		orderService.save(order);
		return "profile?id=" + customer.getId();
	}
}