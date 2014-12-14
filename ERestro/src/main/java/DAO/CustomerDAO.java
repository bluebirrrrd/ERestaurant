package DAO;

import java.util.List;

import com.bionic.edu.ERestro.Customer;
import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;
import com.bionic.edu.ERestro.Orders;

public interface CustomerDAO {
	public void register(String name, String email, String birthDate,
			String billingAddress, String password);
	public void register(Customer customer);
	public void submitOrder(Orders order);
	public List<Food> getFoodByCategory(int categoryId);
	public List<Food> getAllFoodList();
	public List<FoodCategory> getFoodCategories();
	public boolean login(String email, String password);
	public List<Orders> getMyOrders(int customerId);
}
