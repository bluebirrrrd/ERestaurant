package Beans;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import Services.FoodService;

import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.FoodCategory;


@Named("foodBean")
@Scope("request")
public class FoodBean {
	private Food dish;
	private FoodCategory selectedFoodCategory;
	private List<FoodCategory> categories = null;

	@Inject
	FoodService foodService;

	public FoodBean() {
		dish = new Food();
		selectedFoodCategory = new FoodCategory();
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
		 foodService.save(dish);
		return "editMenu";
	}

	public String editFood(String id) {
		Integer intId = Integer.valueOf(id);
		dish = foodService.findById(intId);
		return "newDish";
	}
	
	public void refreshCategories() {
		categories = foodService.getCategoriesList();
	}
	/*public String addPhoto(String photoId) {
		String fileId = "../" + photoId + ".jpg";
		File inpt = new File(fileId);
		if (!inpt.exists()) {
			String fileMsg = "Не найден файл " + fileId;
			return "AddCover";
		}
		dish = foodService.findById();
		dish.setId(photoId);
		try {
			FileInputStream in = new FileInputStream(fileId);
			// Чтение изображения из файла
			byte[] img = new byte[(int) inpt.length()];
			in.read(img);
			in.close();
			dish.setPhoto(img);
			foodService.save(dish);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "editMenu";
	} */ //РАЗБЕРИСЬ!!!!!!!!!!!!!!!!!!!

}
