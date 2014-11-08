package Beans;

import javax.faces.bean.*;
//import javax.inject.Inject;

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
	
	

}
