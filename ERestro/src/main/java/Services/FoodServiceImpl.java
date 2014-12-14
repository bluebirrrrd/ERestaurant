package Services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import DAO.AdminDAO;

import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;

@Named
public class FoodServiceImpl implements FoodService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AdminDAO adminDAO;

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

	public List<Food> getListByCategory(int categoryId) {
		List<Food> list = adminDAO.getDishesFromCategory(categoryId);
		return list;
	}

	public List<FoodCategory> getCategoriesList() {
		List<FoodCategory> list = adminDAO.getCategoriesList();
		return list;
	}

}
