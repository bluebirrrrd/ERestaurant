package DAO;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import com.bionic.edu.ERestro.*;

public class CustomerDAO {

	private static final String UNIT_NAME = "ER";
	private static EntityManagerFactory factory;

	@PersistenceUnit
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
		try {

			em1.getTransaction().begin();
			em1.persist(customer);
			em1.getTransaction().commit();

		} finally {
			em1.close();
		}

	}

	public void register(Customer customer) {
		em1.persist(customer);
	}

	public void submitOrder(Orders order) {
		em1.persist(order);
	}

	public List<Food> getFoodByCategory(FoodCategory foodCategory) {
		List<Food> listFood = null;
		TypedQuery<Food> query = em1
				.createQuery(
						"SELECT f FROM Food f, FoodCategory fc WHERE (f.categoryId=fc.id) AND (f.categoryId=:categoryId)",
						Food.class);
		try {
			query.setParameter("categoryId", foodCategory.getId());
			listFood = query.getResultList();
		} finally {
			em1.close();
		}
		return listFood;
	}

	public List<Food> getAllFoodList() {
		List<Food> listFood = null;
		TypedQuery<Food> query = em1.createQuery("SELECT f FROM Food f",
				Food.class);
		try {
			listFood = query.getResultList();
		} finally {
			em1.close();
		}
		return listFood;
	}

	public List<FoodCategory> getFoodCategories() {
		List<FoodCategory> listCategories = null;
		TypedQuery<FoodCategory> query = em1.createQuery(
				"SELECT c FROM FoodCategory c", FoodCategory.class);
		try {
			listCategories = query.getResultList();
		} finally {
			em1.close();
		}
		return listCategories;
	}

	public boolean login(String email, String password) {
		Customer customer = null;
		TypedQuery<Customer> query = em1.createQuery("SELECT c FROM Customer c WHERE (email=:mail)",Customer.class);
		try {
			query.setParameter("mail", email);
			customer = query.getSingleResult();
			if (customer == null) {
				return false;
			} else {
				return customer.getPassword().equals(password);
			}
		} finally {
			em1.close();
		}
	}
	
	public List<Orders> getMyOrders(int customerId) {
		List<Orders> list = null;
		TypedQuery<Orders> query = em1.createQuery("SELECT o FROM Orders o WHERE (userId = :id)",Orders.class);
		query.setParameter("id", customerId);
		list = query.getResultList();
		return list;
	}
}
