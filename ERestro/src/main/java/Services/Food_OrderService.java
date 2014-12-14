package Services;

import java.util.List;
import com.bionic.edu.ERestro.Food_Order;

public interface Food_OrderService {
	public void save(Food_Order food_order);
	public Food_Order findById(int id);
	public List<Food_Order> getAllFoodOrdersList();
	public List<Food_Order> getUndoneFoodOrdersList();
	public List<Food_Order> getDoneFoodOrdersList();
	public List<Food_Order> getFoodOrdersBetweenDates(String startDate, String endDate);
}
