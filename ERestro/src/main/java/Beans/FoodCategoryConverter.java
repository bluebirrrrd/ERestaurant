package Beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bionic.edu.ERestro.FoodCategory;

import DAO.AdminDAO;
import DAO.AdminDAOImpl;

@FacesConverter("foodCategoryConverter")
public class FoodCategoryConverter implements Converter {
	
	private final AdminDAO adminDAO = new AdminDAOImpl();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		int id = Integer.valueOf(value);
		FoodCategory result = adminDAO.findCategoryById(id);
		return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		FoodCategory temp = (FoodCategory)value;
		int id = temp.getId();
		return Integer.toString(id);
	}

}
