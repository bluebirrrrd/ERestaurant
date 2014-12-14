package DAO;

import java.util.List;

import com.bionic.edu.ERestro.Customer;
import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Rights;

public interface SuperUserDAO {
	public List<Customer> getCustomersList();
	public List<Rights> getRightsList();
	public List<Employee> getEmployeesList();
	public void saveCustomer(Customer customer);
	public void saveEmployee(Employee employee);
	public Customer getCustomerById(int id);
	public Employee getEmployeeById(int id);
	public List<Employee> getEmployeesByCategory(int categoryId);
	public Rights findRightsById(int id);
}
