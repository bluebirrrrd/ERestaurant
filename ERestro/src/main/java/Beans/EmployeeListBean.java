package Beans;

import java.util.List;

import javax.inject.*;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Rights;

import Services.EmployeeService;

@Named
@Scope("view")
public class EmployeeListBean {
	private List<Employee> employees = null;
	private List<Rights> categories = null;

	@Inject
	private EmployeeService employeeService;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Rights> getCategories() {
		return categories;
	}

	public void setCategories(List<Rights> categories) {
		this.categories = categories;
	}
	
	public void getCategoriesList() {
		categories = employeeService.getAccessRights();
	}
	
	public void refreshList() {
		employees = employeeService.getAllEmployeesList();
	}

	public void refreshListByCategory(String categoryId) {
		int catId = Integer.valueOf(categoryId);
		employees = employeeService.getEmployeesByCategory(catId);
	}
}
