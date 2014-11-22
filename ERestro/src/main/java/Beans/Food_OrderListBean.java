package Beans;

import java.util.List;

import javax.inject.*;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.ERestro.Food_Order;

import Services.Food_OrderService;

@Named
@Scope("request")
public class Food_OrderListBean {
	
	private List<Food_Order> foodOrderList;
	
	@Inject
	Food_OrderService foodOrderService;

	public List<Food_Order> getFoodOrderList() {
		return foodOrderList;
	}

	public void setFoodOrderList(List<Food_Order> foodOrderList) {
		this.foodOrderList = foodOrderList;
	}
	
	public void refreshList() {
		foodOrderList = foodOrderService.getAllFoodOrdersList();
	}
	
	public void refreshUndoneList() {
		foodOrderList = foodOrderService.getUndoneFoodOrdersList();
	}
	
	
	
}
