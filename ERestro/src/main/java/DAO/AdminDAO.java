package DAO;

import java.util.List;

import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;
import com.bionic.edu.ERestro.Food_Order;
import com.bionic.edu.ERestro.Orders;

public interface AdminDAO {
	public List<FoodCategory>  getCategoriesList();
	public List<Food> getAllDishes();
	public List<Food> getDishesFromCategory(int categoryId);
	public List<Food_Order> getPendingDishes();
	public List<Orders> getOrdersList();
	public void saveDish(Food dish);
	public Food findById(int id);
	public FoodCategory findCategoryById(int id);
}
