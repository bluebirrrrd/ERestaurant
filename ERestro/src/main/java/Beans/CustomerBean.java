package Beans;

import java.io.Serializable;

import javax.faces.bean.*;

import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.*;

import org.springframework.context.annotation.Scope;

import Services.CustomerService;

import com.bionic.edu.ERestro.Customer;

@Named
@Scope("request")
public class CustomerBean implements Serializable{
	
	
	private Customer customer;
	@Inject
	private CustomerService custService;
	private boolean loggedIn;
	private java.util.Date birthday;
	
	public CustomerBean() {
		customer = new Customer();
	}
	
	public CustomerService getCustService() {
		return custService;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	public String editCustomer(String id) {
		customer = custService.findById(Integer.valueOf(id));
		return "newCustomer";
	}
	
	public boolean logIn(String email,String password) {
		loggedIn = custService.logIn(email, password); //String pass = DigestUtils.md5Hex(password); - //this one should go into custService implementation
		return loggedIn; //custService.logIn(email, pass);
	}
	
	public String save() {
		customer.setBirthDate(birthday);
		custService.save(customer);
		return "menu";
	}

}
