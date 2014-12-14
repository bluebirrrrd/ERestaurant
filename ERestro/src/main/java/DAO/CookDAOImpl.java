package DAO;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;


import com.bionic.edu.ERestro.Food;
import com.bionic.edu.ERestro.Food_Order;


@Repository
public class CookDAOImpl implements CookDAO {
	
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
	
	public List<Food_Order> getAllDishes() {
		List<Food_Order> list = null;
		TypedQuery<Food_Order> query = em1.createQuery("SELECT f FROM Food_Order f",Food_Order.class);
		list = query.getResultList();
		return list;
	}
	
	public List<Food_Order> getUndoneDishes() {

		List<Food_Order> parts = null;
		TypedQuery<Food_Order> query = em1.createQuery("SELECT f FROM Food_Order f WHERE (f.done=1)",Food_Order.class);
		parts = query.getResultList();
		return parts;
	}
	
	public void saveDish(Food_Order part) {
		int partId = part.getId();
		//try {
			Food_Order partUpdate = em1.find(Food_Order.class, partId);
		
		em1.merge(part);
		/*} finally {
			em1.close();
		}*/
	}
	
	public Food_Order findPartById(int id) {
		Food_Order dish = em1.find(Food_Order.class, id);
		return dish;
	}
}
