package Services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import DAO.AdminDAO;
import DAO.CustomerDAO;

import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;

@Named
public class FoodServiceImpl implements FoodService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AdminDAO adminDAO;
	@Inject
	CustomerDAO customerDAO;
	
	public Food findById(int id) {
		Food dish = adminDAO.findById(id);
		return dish;
	}

	@Transactional
	public void save(Food dish) {
		adminDAO.saveDish(dish);
	}

	public List<Food> getAllFoodList() {
		List<Food> list = adminDAO.getAllDishes();
		return list;
	}
	
	public List<Food> getAvailableFoodList() {
		List<Food> list = customerDAO.getAllFoodList();
		return list;
	}

	public List<Food> getListByCategory(int categoryId) {
		List<Food> list = adminDAO.getDishesFromCategory(categoryId);
		return list;
	}

	public List<FoodCategory> getCategoriesList() {
		List<FoodCategory> list = adminDAO.getCategoriesList();
		return list;
	}

	@Override
	public FoodCategory findCategoryById(int id) {
		FoodCategory result = adminDAO.findCategoryById(id);
		return result;
	}

	@Override
	public List<Food> custGetListByCategory(int catId) {
		List<Food> list = customerDAO.getFoodByCategory(catId);
		return list;
	}

}
