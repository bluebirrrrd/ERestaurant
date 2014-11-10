package Beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;

/*@ManagedBean(name="food", eager = true)
@RequestScoped
*/
 @Named("foodBean")
	@Scope("request")
public class FoodBean {
	private Food dish;
	private static List<Food> dishes;
	private FoodCategory selectedFoodCategory;
	private static List<FoodCategory> categories;
	/*
	 * @Inject FoodBeanService foodService;
	 */
	public FoodBean() {
		dish = new Food();
		selectedFoodCategory = new FoodCategory();
	}
	
	static {
		FoodCategory foodcat1 = new FoodCategory();
		foodcat1.setId(1);
		foodcat1.setName("Starters");
		FoodCategory foodcat2 = new FoodCategory();
		foodcat2.setId(2);
		foodcat2.setName("Main Courses");
		FoodCategory foodcat3 = new FoodCategory();
		foodcat3.setId(3);
		foodcat3.setName("Salads");
		
		Food dish1 = new Food();
		dish1.setId(1);
		dish1.setName("Chicken Soup");
		dish1.setCategory(foodcat2);
		dish1.setDescription("Best soup ever!!!");
		dish1.setKitchenMade(true);
		dish1.setPrice(55.00);
		Food dish2 = new Food();
		dish2.setId(2);
		dish2.setName("Canape with Olives");
		dish2.setCategory(foodcat1);
		dish2.setDescription("Chief hates doing them");
		dish2.setKitchenMade(true);
		dish2.setPrice(23.95);
		Food dish3 = new Food();
		dish3.setId(3);
		dish3.setName("Caesar Salad");
		dish3.setCategory(foodcat3);
		dish3.setDescription("Ladies love it");
		dish3.setKitchenMade(true);
		dish3.setPrice(44.00);
		dishes = new ArrayList<Food>();
		dishes.add(dish1);
		dishes.add(dish2);
		dishes.add(dish3);
		
		
		categories = new ArrayList<FoodCategory>();

		categories.add(foodcat1);
		categories.add(foodcat2);
		categories.add(foodcat3);
	}
	
	public List<Food> getDishes() {
		return dishes;
	}
	/*public void setDishes(List<Food> dishes) {
		this.dishes = dishes;
	}*/
	public FoodCategory getSelectedFoodCategory() {
		return selectedFoodCategory;
	}
	public void setSelectedFoodCategory(FoodCategory selectedFoodCategory) {
		this.selectedFoodCategory = selectedFoodCategory;
	}
	
	public List<FoodCategory> getCategories() {
		return categories;
	}
/*	public void setCategories(Map<String, FoodCategory> categories) {
		this.categories = categories;
	}*/
	public FoodCategory getFoodCategory() {
		return selectedFoodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.selectedFoodCategory = foodCategory;
	}

	public Food getDish() {
		return dish;
	}

	public void setDish(Food dish) {
		this.dish = dish;
	}
	
	public String saveFood() {
		//foodService.save();
		return "editMenu";
	}
	
	public String editFood(String id) {
		//dish = foodService.findById();
		return "newDish";
	}
	
	
}
