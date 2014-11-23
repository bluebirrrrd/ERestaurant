package Beans;

import java.util.List;

import javax.inject.Inject;

import Services.FoodService;

import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;

public class FoodListBean {
	private static List<Food> dishes;
	private static List<FoodCategory> categories;
	
	@Inject
	FoodService foodService;

	public static List<Food> getDishes() {
		return dishes;
	}

	public static void setDishes(List<Food> dishes) {
		FoodListBean.dishes = dishes;
	}

	public static List<FoodCategory> getCategories() {
		return categories;
	}

	public static void setCategories(List<FoodCategory> categories) {
		FoodListBean.categories = categories;
	}
	
	public void getCategoriesList() {
		categories = foodService.getCategoriesList();
	}
	
	public void refreshList() {
		dishes = foodService.getAllFoodList();
	}
	
	public void refreshListByCategory(FoodCategory category) {
		dishes = foodService.getListByCategory(category);
	}
}
