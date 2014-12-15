package Beans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.ERestro.Customer;

import Services.CustomerService;

@Named
@Scope("view")
public class CustomerListBean {
	private List<Customer> customers = null;
	
	@Inject
	CustomerService customerService;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public void refreshCustomersList() {
		customers = customerService.getAllCustomerList();
	}
	
}
