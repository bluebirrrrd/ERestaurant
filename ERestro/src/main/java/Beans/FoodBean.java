package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;

@ManagedBean(name="food", eager = true)
@RequestScoped
/*
 * @Named
 *	@Scope("request")
 */
public class FoodBean {
	private Food dish;
	private List<Food> dishes;
	private FoodCategory selectedFoodCategory;
	private List<FoodCategory> categories;
	/*
	 * @Inject FoodBeanService foodService;
	 */
	public FoodBean() {
		dish = new Food();
		selectedFoodCategory = new FoodCategory();
		FoodCategory foodcat1 = new FoodCategory();
		foodcat1.setId(1);
		foodcat1.setName("Starters");
		FoodCategory foodcat2 = new FoodCategory();
		foodcat2.setId(2);
		foodcat2.setName("Main Courses");
		FoodCategory foodcat3 = new FoodCategory();
		foodcat3.setId(3);
		foodcat3.setName("Salads");
		categories = new ArrayList<FoodCategory>();

		categories.add(foodcat1);
		categories.add(foodcat2);
		categories.add(foodcat3);
	}
	public List<Food> getDishes() {
		return dishes;
	}
	public void setDishes(List<Food> dishes) {
		this.dishes = dishes;
	}
	public FoodCategory getSelectedFoodCategory() {
		return selectedFoodCategory;
	}
	public void setSelectedFoodCategory(FoodCategory selectedFoodCategory) {
		this.selectedFoodCategory = selectedFoodCategory;
	}
	public List<FoodCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<FoodCategory> categories) {
		this.categories = categories;
	}
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
