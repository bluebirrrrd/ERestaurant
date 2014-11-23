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
	private static final long serialVersionUID = 1L;
	
	private Customer customer;
	@Inject
	private CustomerService custService;
	
	public CustomerBean() {
		customer = new Customer();
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
		//String pass = DigestUtils.md5Hex(password); - //this one should go into custService implementation
		return true; //custService.logIn(email, pass);
	}
	
	public String save() {
		custService.save(customer);
		return "menu";
	}

}
