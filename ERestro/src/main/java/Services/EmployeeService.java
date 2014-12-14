package Services;

import java.util.List;

import com.bionic.edu.ERestro.Customer;
import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Rights;

public interface EmployeeService {
	public Employee findById(int id);
	public void save(Employee e);
	public List<Employee> getAllEmployeesList();
	public List<Employee> getEmployeesByCategory(int categoryId);
	public List<Rights> getAccessRights();
	public Rights login(String email, String password);
	public Rights findRightsById(int id);
	public void save(Customer customer);
}

