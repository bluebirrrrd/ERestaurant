package Beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import Services.FoodService;

import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;

@Named
@Scope("session")
public class FoodListBean {
	private  List<Food> dishes = null;
	private  List<FoodCategory> categories = null;
	
	@Inject
	FoodService foodService;
	
	
	public List<Food> getDishes() {
		return dishes;
	}

	public void setDishes(List<Food> dishes) {
		this.dishes = dishes;
	}

	public List<FoodCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<FoodCategory> categories) {
		this.categories = categories;
	}
	
	public void getCategoriesList() {
		categories = foodService.getCategoriesList();
	}
	
	public String refreshList() {
		dishes = foodService.getAvailableFoodList();
		return "index";
	}
	
	public String refreshAdminList() {
		dishes = foodService.getAllFoodList();
		return "admin";
	}
	
	public String refreshListByCategory(String categoryId) {
		int catId = Integer.valueOf(categoryId);
		dishes = foodService.custGetListByCategory(catId);
		return "index";
	}
	
	public String adminRefreshListByCategory(String categoryId) {
		int catId = Integer.valueOf(categoryId);
		dishes = foodService.getListByCategory(catId);
		return "admin";
	}
	
	
}
