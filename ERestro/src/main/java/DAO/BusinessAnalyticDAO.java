package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Orders;
import com.bionic.edu.ERestro.Rights;

public class BusinessAnalyticDAO {

	@PersistenceUnit
	private EntityManager em1;

	public Rights login(String email, String password) {
		Employee employee = null;
		TypedQuery<Employee> query = em1.createQuery(
				"SELECT u FROM Users u WHERE (email=:mail)", Employee.class);
		// try {
		query.setParameter("mail", email);
		employee = query.getSingleResult();
		if (employee == null) {
			return null;
		} else if (employee.getPassword().equals(password)) {
			return employee.getAccess();
		} else {
			return null;
		}
		/*
		 * } finally { em1.close(); }
		 */
	}
	

	public List<Orders> getOrdersList() {
		List<Orders> ordersList = null;
		TypedQuery<Orders> query = em1.createQuery("SELECT o FROM Orders o WHERE (deliveryStatusId=3)", Orders.class);
		//try {
			ordersList = query.getResultList();
		/*} finally {
			em1.close();
		}*/
		return ordersList;
	}
}
