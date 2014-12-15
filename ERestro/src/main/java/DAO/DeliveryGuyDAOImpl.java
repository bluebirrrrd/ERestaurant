package DAO;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.bionic.edu.ERestro.DeliveryStatus;
import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Orders;
import com.bionic.edu.ERestro.Rights;

@Repository
public class DeliveryGuyDAOImpl implements DeliveryGuyDAO {
	
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
		TypedQuery<Orders> query = em1.createQuery("SELECT o FROM Orders o WHERE (o.delStat.id=2)", Orders.class);
		//try {
			ordersList = query.getResultList();
		/*} finally {
			em1.close();
		}*/
		return ordersList;
	}
	
	public void saveOrder(Orders order) {
		em1.merge(order);
	}

	@Override
	public List<DeliveryStatus> getStatusList() {
		List<DeliveryStatus> result = null;
		TypedQuery<DeliveryStatus> query = em1.createQuery("SELECT s FROM DeliveryStatus s", DeliveryStatus.class);
		result = query.getResultList();
		return result;
	}

	@Override
	public Orders findById(int id) {
		Orders order = em1.find(Orders.class, id);
		return order;
	}

	@Override
	public DeliveryStatus findStatusById(int id) {
		DeliveryStatus result = em1.find(DeliveryStatus.class, id);
		return result;
	}
	
}
