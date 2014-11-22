package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import com.bionic.edu.ERestro.Customer;
import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.Food_Order;
import com.bionic.edu.ERestro.Orders;
import com.bionic.edu.ERestro.Rights;

public class AdminDAO implements EmployeeDAO {

	@PersistenceUnit
	private EntityManager em1;

	public Rights login(String email, String password) {
		Employee employee = null;
		TypedQuery<Employee> query = em1.createQuery(
				"SELECT u FROM Users u WHERE (email=:mail)", Employee.class);
		//try {
			query.setParameter("mail", email);
			employee = query.getSingleResult();
			if (employee == null) {
				return null;
			} else if (employee.getPassword().equals(password)) {
				return employee.getAccess();
			} else {
				return null;
			}
	/*	} finally {
			em1.close();
		}*/
	}

	public List<Food_Order> getDishes() {

		List<Orders> orders = null;
		List<Food_Order> parts = new ArrayList<Food_Order>();
		TypedQuery<Orders> query = em1.createQuery(
				"SELECT o FROM Orders o WHERE (deliveryStatusId = 1)",
				Orders.class);
		orders = query.getResultList();
		Iterator<Orders> it = orders.iterator();
		while (it.hasNext()) {
			Orders temp = it.next();
			parts.addAll(temp.getContent());
		}
		return parts;
	}

	public List<Orders> getOrdersList() {
		List<Orders> ordersList = null;
		TypedQuery<Orders> query = em1.createQuery(
				"SELECT o FROM Orders o WHERE (deliveryStatusId=2)",
				Orders.class);
		ordersList = query.getResultList();
		return ordersList;
	}

	public void saveDish(Food dish) {
		if (dish.getId() == 0) {
			em1.persist(dish);
		} else {
			Food dishUpdate = em1.find(Food.class, dish.getId());
			//	try {
				em1.getTransaction().begin();
				dishUpdate.setName(dish.getName());
				dishUpdate.setCategory(dish.getCategory());
				dishUpdate.setDescription(dish.getDescription());
				dishUpdate.setKitchenMade(dish.isKitchenMade());
				dishUpdate.setPrice(dish.getPrice());
				dishUpdate.setAvailable(dish.isAvailable());
				em1.getTransaction().commit();
			/*} finally {
				em1.close();
			}*/
		}
	}
	
	
}
