package Beans;

import java.io.Serializable;
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
@Scope("session")
public class EmployeeBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Employee employee;
	
	@Inject 
	private EmployeeService employeeService;
	private boolean loggedIn;
	private java.util.Date birthday;
	private Rights role= new Rights();
	private int valid;
	
	public EmployeeBean() {
		employee = new Employee();
		
	}
	
	
	public int getValid() {
		return valid;
	}


	public void setValid(int valid) {
		this.valid = valid;
	}


	public Rights getRole() {
		return role;
	}


	public void setRole(Rights role) {
		this.role = role;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String editEmployee(String id) {
		employee = employeeService.findById(Integer.valueOf(id));
		birthday = employee.getBirthDate();
		valid = employee.getValid();
		return "allEmployees";
	}

	public String saveEmployee() {
		Rights access = employeeService.findRightsById(role.getId());
		employee.setAccess(access);
		employee.setBirthDate(birthday);
		employeeService.save(employee);
		employee = new Employee();
		return "allEmployees";
	}

	public void changeStatusOfEmployee(String id) {
		employee = employeeService.findById(Integer.valueOf(id));
		employee.setValid(employee.isValid());
	}

}
