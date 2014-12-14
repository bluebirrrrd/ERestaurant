package DAO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.ERestro.*;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	private EntityManager em1;

	public void register(String name, String email, String birthDate,
			String billingAddress, String password) {
		/*
		 * factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		 * EntityManager em = factory.createEntityManager();
		 */
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setBirthDate(java.sql.Date.valueOf(birthDate));
		customer.setBillingAddress(billingAddress);
		customer.setPassword(password);

		em1.persist(customer);

	}

	public void register(Customer customer) {
		em1.persist(customer);
	}

	/*
	 * needs some improvement. What happens if we persist only order without
	 * getting any content out of it to persist?
	 */
	public void submitOrder(Orders order) {
		Collection<Food_Order> content = order.getContent();
		Iterator<Food_Order> it = content.iterator();
		while (it.hasNext()) {
			Food_Order temp = it.next();
			em1.persist(temp);
		}
		em1.persist(order);
	}

	public List<Food> getFoodByCategory(int categoryId) {
		List<Food> listFood = null;
		TypedQuery<Food> query = em1
				.createQuery(
						"SELECT f FROM Food f, FoodCategory fc WHERE (fc.id=:categoryId)",
						Food.class);
		query.setParameter("categoryId", categoryId);
		listFood = query.getResultList();
		return listFood;
	}

	public List<Food> getAllFoodList() {
		List<Food> listFood = null;
		TypedQuery<Food> query = em1.createQuery("SELECT f FROM Food f",
				Food.class);
			listFood = query.getResultList();
		return listFood;
	}

	public List<FoodCategory> getFoodCategories() {
		List<FoodCategory> listCategories = null;
		TypedQuery<FoodCategory> query = em1.createQuery(
				"SELECT c FROM FoodCategory c", FoodCategory.class);
		listCategories = query.getResultList();

		return listCategories;
	}

	public Customer login(String email, String password) {
		Customer customer = null;
		TypedQuery<Customer> query = em1.createQuery(
				"SELECT c FROM Customer c WHERE (c.email=:mail)", Customer.class);

		query.setParameter("mail", email);
		customer = query.getSingleResult();
		if (customer == null) {
			return new Customer();
		} else {
			if (customer.getPassword().equals(password)) 
				return customer;
			else return new Customer();
		}
	}

	public List<Orders> getMyOrders(int customerId) {
		List<Orders> list = null;
		TypedQuery<Orders> query = em1.createQuery(
				"SELECT o FROM Orders o WHERE (o.userId = :id)", Orders.class);
		query.setParameter("id", customerId);
		list = query.getResultList();
		return list;
	}
}
