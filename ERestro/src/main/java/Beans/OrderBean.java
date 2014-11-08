package Beans;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.*;

import com.bionic.edu.ERestro.Customer;
import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.Food_Order;
import com.bionic.edu.ERestro.Orders;

@ManagedBean(name = "order", eager = true)
@SessionScoped
public class OrderBean {
	private Orders order;
	private List<Food_Order> content;
	/*
	 * @Inject private OrderService orderService;
	 * @Inject private Food_OrderService foodOrderService;
	 */
	private double total;
	private Customer customer;

	public OrderBean() {
		order = new Orders();
		content = null;
		total = 0.0;
		customer = new Customer();
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
			total += temp.getFood().getPrice()*temp.getQuantity();
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
		order.setUser(customer);
		/*
		 * for (Food_Order f: order.content) {
		 * foodOrderService.save(f);
		 * }
		 */
		//orderService.save(order);
		return "profile?id="+customer.getId();
	}
}