package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;



import com.bionic.edu.ERestro.Food_Order;
import com.bionic.edu.ERestro.Orders;


@Repository
public class BusinessAnalyticDAOImpl implements BusinessAnalyticDAO{

	@PersistenceContext
	private EntityManager em1;

	/*public Rights login(String email, String password) {
		Employee employee = null;
		TypedQuery<Employee> query = em1.createQuery(
				"SELECT u FROM Users u WHERE (email=:mail)", Employee.class);
		query.setParameter("mail", email);
		employee = query.getSingleResult();
		if (employee == null) {
			return null;
		} else if (employee.getPassword().equals(password)) {
			return employee.getAccess();
		} else {
			return null;
		}
	}*/
	

	public List<Orders> getOrdersList() {
		List<Orders> ordersList = null;
		TypedQuery<Orders> query = em1.createQuery("SELECT o FROM Orders o WHERE (o.deliveryStatus.id=3)", Orders.class);
		//try {
			ordersList = query.getResultList();
		/*} finally {
			em1.close();
		}*/
		return ordersList;
	}
	public List<Food_Order> getPartsList() {
		List<Food_Order> parts = null;
		TypedQuery<Food_Order> query = em1.createQuery("SELECT fo FROM Food_Order fo WHERE fo.done=1", Food_Order.class);
		parts = query.getResultList();
		return parts;
	}
}
