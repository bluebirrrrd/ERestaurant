package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import javax.inject.Inject;

import Services.EmployeeService;

import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Rights;

@Named
@Scope("request")
public class EmployeeBean {
	private Employee employee;
	
	@Inject 
	private EmployeeService employeeService;

	public EmployeeBean() {
		employee = new Employee();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String editEmployee(String id) {
		employee = employeeService.findById(Integer.valueOf(id));
		return "editEmployee";
	}

	public String saveEmployee() {
		employeeService.save(employee);
		return "employeeList";
	}

	public void changeStatusOfEmployee(String id) {
		employee = employeeService.findById(Integer.valueOf(id));
		employee.setValid(employee.isValid());
	}

}
