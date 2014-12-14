package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.ERestro.Employee;
import com.bionic.edu.ERestro.Rights;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	private EntityManager em1;
	
	@Override
	public Employee login(String email, String password) {
		Employee employee = null;
		TypedQuery<Employee> query = em1.createQuery(
				"SELECT e FROM Employee e WHERE (e.email=:mail)", Employee.class);
			query.setParameter("mail", email);
			employee = query.getSingleResult();
			if (employee == null) {
				return new Employee();
			} else if (employee.getPassword().equals(password)) {
				return employee;
			} else {
				return new Employee();
			}
	}

}
