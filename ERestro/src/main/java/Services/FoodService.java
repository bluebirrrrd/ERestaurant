package Services;

import java.util.List;

import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;

public interface FoodService {
	public Food findById(int id);
	public void save(Food dish);
	public List<Food> getAllFoodList();
	public List<Food> getListByCategory(int categoryId);
	public List<FoodCategory> getCategoriesList();
	public FoodCategory findCategoryById(int id);
}
