package Services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import DAO.SuperUserDAO;

import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Rights;

@Named
public class EmployeeServiceImpl implements EmployeeService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject 
	SuperUserDAO superUserDAO;
	
	public Employee findById(int id) {
		 Employee employee = superUserDAO.getEmployeeById(id);
		return employee;
	}

	@Transactional
	public void save(Employee e) {
		superUserDAO.saveEmployee(e);
	}


	public List<Employee> getAllEmployeesList() {
		List<Employee> list = superUserDAO.getEmployeesList();
		return list;
	}

	public List<Employee> getEmployeesByCategory(Rights category) {
			List<Employee> list = superUserDAO.getEmployeesByCategory(category.getId());
		return list;
	}

	@Override
	public List<Rights> getAccessRights() {
		List<Rights> list = superUserDAO.getRightsList();
		return list;
	}

}
