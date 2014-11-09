package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.ERestro.Food;

@ManagedBean(name="food", eager = true)
@RequestScoped
/*
 * @Named
 *	@Scope("request")
 */
public class FoodBean {
	private Food dish;
	/*
	 * @Inject FoodBeanService foodService;
	 */

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
