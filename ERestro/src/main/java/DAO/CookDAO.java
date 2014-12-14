package DAO;

import java.util.List;

import com.bionic.edu.ERestro.Food_Order;

public interface CookDAO {
	public List<Food_Order> getAllDishes();
	public List<Food_Order> getUndoneDishes();
	public void saveDish(Food_Order part);
	public Food_Order findPartById(int id);
}
