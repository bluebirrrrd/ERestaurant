package Beans;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.*;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.ERestro.FoodCategory;
import com.bionic.edu.ERestro.Food_Order;

import Services.FoodService;
import Services.Food_OrderService;

@Named
@Scope("request")
public class Food_OrderListBean {
	
	private List<Food_Order> foodOrderList;
	private Map<FoodCategory, Double> summary = new LinkedHashMap<FoodCategory, Double>();
	private List<FoodCategory> categories;
	@Inject
	Food_OrderService foodOrderService;
	@Inject
	FoodService foodService;
	public List<Food_Order> getFoodOrderList() {
		return foodOrderList;
	}

	public void setFoodOrderList(List<Food_Order> foodOrderList) {
		this.foodOrderList = foodOrderList;
	}
	
	public Map<FoodCategory, Double> getSummary() {
		return summary;
	}

	public void setSummary(Map<FoodCategory, Double> summary) {
		this.summary = summary;
	}

	public List<FoodCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<FoodCategory> categories) {
		this.categories = categories;
	}

	public void refreshList() {
		foodOrderList = foodOrderService.getAllFoodOrdersList();
	}
	
	public void refreshUndoneList() {
		foodOrderList = foodOrderService.getUndoneFoodOrdersList();
	}
	
	public void refreshCategories() {
		categories = foodService.getCategoriesList();
	}
	
	public void refreshSummary() {
		for (Food_Order f: foodOrderList) {
			for (FoodCategory c: categories) {
				double tempTotal = 0.0;
				if (f.getFood().getCategory().getId() == c.getId()) {
					tempTotal += f.getFood().getPrice()*f.getQuantity();
				}
				summary.put(c, tempTotal);
			}
		}
	}
	
}
