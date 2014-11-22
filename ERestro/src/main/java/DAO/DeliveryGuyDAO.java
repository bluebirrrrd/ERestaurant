package DAO;

import java.util.List;

import javax.persistence.*;

import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Orders;
import com.bionic.edu.ERestro.Rights;

public class DeliveryGuyDAO implements EmployeeDAO {
	
	@PersistenceUnit
	private EntityManager em1;
	
	public Rights login(String email, String password) {
		Employee employee = null;
		TypedQuery<Employee> query = em1.createQuery(
				"SELECT u FROM Users u WHERE (email=:mail)", Employee.class);
	//	try {
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
	
	public List<Orders> getOrdersList() {
		List<Orders> ordersList = null;
		TypedQuery<Orders> query = em1.createQuery("SELECT o FROM Orders o WHERE (deliveryStatusId=2)", Orders.class);
		//try {
			ordersList = query.getResultList();
		/*} finally {
			em1.close();
		}*/
		return ordersList;
	}
	
	public void saveOrder(Orders order) {
		int orderId = order.getId();
		//try{
		Orders orderUpdate = em1.find(Orders.class, orderId);
		em1.getTransaction().begin();
		orderUpdate.setDelStat(order.getDelStat());
		em1.getTransaction().commit();
	/*	} finally {
			em1.close();
		}*/
	}
	
}
