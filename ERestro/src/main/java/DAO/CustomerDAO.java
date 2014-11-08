package DAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bionic.edu.ERestro.*;

public class CustomerDAO {
	
	private static final String UNIT_NAME = "ER";
  	private static EntityManagerFactory factory;
  	
	public void register(String name, String email, String birthDate, String billingAddress, String password) {
		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Customer cust = new Customer();
		cust.setName(name);
		cust.setEmail(email);
		cust.setBirthDate(java.sql.Date.valueOf(birthDate));
		cust.setBillingAddress(billingAddress);
		cust.setPassword(password);
		try{
			
			em.getTransaction().begin();
			em.persist(cust);
			em.getTransaction().commit();
			
		}
		finally{ em.close(); }
		
		
	}

	public void submitOrder() {
		
	}
}
