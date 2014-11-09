package Beans;

import javax.faces.bean.*;

import org.apache.commons.codec.digest.DigestUtils;

//import javax.inject.Inject;
//import org.apache.commons.codec.digest.DigestUtils;
import com.bionic.edu.ERestro.Customer;

/*@Named
@Scope("request")*/
@ManagedBean(name = "customer", eager = true)
@RequestScoped
public class CustomerBean {
	private Customer customer;
/*  @Inject
	private CustomerService custService;*/
	
	public CustomerBean() {
		customer = new Customer();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String setCustomer() {
		//custService.save(customer);
		return "menu";
	}
	
	public String editCustomer(String id) {
		//customer = custService.findById(Integer.valueOf(id));
		return "newCustomer";
	}
	
	public boolean logIn(String email,String password) {
		//String pass = DigestUtils.md5Hex(password); - //this one should go into custService implementation
		return true; //custService.logIn(email, pass);
	}
	

}
