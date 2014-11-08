package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bionic.edu.ERestro.Food;

@ManagedBean(name="food", eager = true)
@RequestScoped
public class FoodBean {
	private Food dish;
	
	
}
