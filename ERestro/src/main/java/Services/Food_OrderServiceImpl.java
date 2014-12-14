package Services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import DAO.BusinessAnalyticDAO;
import DAO.CookDAO;
import DAO.DeliveryGuyDAO;

import com.bionic.edu.ERestro.Food_Order;

@Named
public class Food_OrderServiceImpl implements Food_OrderService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	CookDAO cookDAO;
	
	@Inject
	BusinessAnalyticDAO businessAnalyticDAO;
	
	@Transactional
	public void save(Food_Order food_order) {
		cookDAO.saveDish(food_order);
	}

	public Food_Order findById(int id) {
		Food_Order part = cookDAO.findPartById(id);
		return part;
	}

	public List<Food_Order> getAllFoodOrdersList() {
		List<Food_Order> list = cookDAO.getAllDishes();
		return list;
	}

	public List<Food_Order> getUndoneFoodOrdersList() {
		List<Food_Order> list = cookDAO.getUndoneDishes();
		return list;
	}

	@Override
	public List<Food_Order> getDoneFoodOrdersList() {
		List<Food_Order> result = businessAnalyticDAO.getPartsList();
		return result;
	}

	@Override
	public List<Food_Order> getFoodOrdersBetweenDates(String startDate,
			String endDate) {
		List<Food_Order> result = businessAnalyticDAO.getPartsBetweenDates(startDate, endDate);
		return result;
	}
	
	

}
