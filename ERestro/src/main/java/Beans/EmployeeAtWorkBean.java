package Beans;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import Services.EmployeeService;

import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Rights;

@Named
@Scope("session")
public class EmployeeAtWorkBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Employee employee;
	
	@Inject 
	private EmployeeService employeeService;
	private boolean loggedIn;
	private String email;
	private String password;
	
	public EmployeeAtWorkBean() {
		employee = new Employee();
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String login() {
		employee = employeeService.login(email, password);
		if (employee.getId() != 0) {
			loggedIn = true;
		}
		return "admin";
	}
	public String logOff() {
		employee = new Employee();
		loggedIn = false;
		return "index";
	}


}
