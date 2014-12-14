package Services;

import java.util.List;

import com.bionic.edu.ERestro.Customer;

public interface CustomerService {
	public Customer findById(int id);
	public void save(Customer c);
	public List<Customer> getAllCustomerList();
	public Customer logIn(String email, String password);
}
