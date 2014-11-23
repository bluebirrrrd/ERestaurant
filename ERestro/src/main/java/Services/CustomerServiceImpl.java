package Services;

import java.io.Serializable;
import java.util.List;

import javax.inject.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.transaction.annotation.Transactional;

import DAO.CustomerDAO;
import DAO.SuperUserDAO;

import com.bionic.edu.ERestro.Customer;

@Named
public class CustomerServiceImpl implements CustomerService,Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	SuperUserDAO superUserDAO;
	
	@Inject
	CustomerDAO customerDAO;
	
	@Transactional
	public Customer findById(int id) {
		Customer customer = superUserDAO.getCustomerById(id);
		return customer;
	}

	@Transactional
	public void save(Customer c) {
		superUserDAO.saveCustomer(c);

	}

	public List<Customer> getAllCustomerList() {
		List<Customer> list = superUserDAO.getCustomersList();
		return list;
	}

	@Transactional
	public boolean logIn(String email, String password) {
		String pass = DigestUtils.md5Hex(password);
		boolean result = customerDAO.login(email, pass);
		return result;
	}

}
