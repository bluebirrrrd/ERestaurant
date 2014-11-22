package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.Food_Order;
import com.bionic.edu.ERestro.Orders;
import com.bionic.edu.ERestro.Rights;

public class CookDAO {
	
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
		/*} finally {
			em1.close();
		}*/
	}
	public List<Food_Order> getDishes() {

		List<Orders> orders = null;
		List<Food_Order> parts = new ArrayList<Food_Order>();
		TypedQuery<Orders> query = em1.createQuery("SELECT o FROM Orders o WHERE (deliveryStatusId = 1)",Orders.class);
		orders = query.getResultList();
		Iterator<Orders> it = orders.iterator();
		while (it.hasNext()) {
			Orders temp = it.next();
			parts.addAll(temp.getContent());
		}
		return parts;
	}
	
	public void saveDish(Food_Order part) {
		int partId = part.getId();
		//try {
			Food_Order partUpdate = em1.find(Food_Order.class, partId);
		
		em1.getTransaction().begin();
		partUpdate.setDone(part.isDone());
		em1.getTransaction().commit();
		/*} finally {
			em1.close();
		}*/
	}

}
