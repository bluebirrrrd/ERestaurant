package Services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.transaction.annotation.Transactional;

import DAO.EmployeeDAO;
import DAO.SuperUserDAO;

import com.bionic.edu.ERestro.Customer;
import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Rights;

@Named
public class EmployeeServiceImpl implements EmployeeService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject 
	SuperUserDAO superUserDAO;
	
	@Inject
	EmployeeDAO employeeDAO;
	
	public Employee findById(int id) {
		 Employee employee = superUserDAO.getEmployeeById(id);
		return employee;
	}

	@Transactional
	public void save(Employee e) {
		String pass = DigestUtils.md5Hex(e.getPassword());
		e.setPassword(pass);
		superUserDAO.saveEmployee(e);
	}
	


	public List<Employee> getAllEmployeesList() {
		List<Employee> list = superUserDAO.getEmployeesList();
		return list;
	}

	public List<Employee> getEmployeesByCategory(int categoryId) {
			List<Employee> list = superUserDAO.getEmployeesByCategory(categoryId);
		return list;
	}

	@Override
	public List<Rights> getAccessRights() {
		List<Rights> list = superUserDAO.getRightsList();
		return list;
	}
	
	@Override
	public Employee login(String email, String password) {
		String pass = DigestUtils.md5Hex(password); //this one should go into custService implementation
		Employee empl = employeeDAO.login(email, pass);
		return empl;
		
	}

	@Override
	public Rights findRightsById(int id) {
		Rights result = superUserDAO.findRightsById(id);
		return result;
	}

	@Override
	public void save(Customer customer) {
		String pass = DigestUtils.md5Hex(customer.getPassword());
		customer.setPassword(pass);
		superUserDAO.saveCustomer(customer);
		
	}
	

}
