package Beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import DAO.SuperUserDAO;
import DAO.SuperUserDAOImpl;

import com.bionic.edu.ERestro.Rights;

@FacesConverter("rightsConverter")
public class RightsConverter implements Converter {

	SuperUserDAO superUserDAO = new SuperUserDAOImpl();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
        {
            return null;
        }
        if(!value.matches("\\d+"))
        {
            throw new ConverterException("The value is not a valid email: " + value);
        }

        
		Rights result = superUserDAO.findRightsById(Integer.valueOf(value));
		return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null)
        {
            return null;
        }

        if(!(value instanceof Rights))
        {
            throw new ConverterException("The value is not a Right: " + value);            
        }

        int id = ((Rights) value).getId();
        return (id != 0) ? Integer.toString(id) : null;
	}
}
