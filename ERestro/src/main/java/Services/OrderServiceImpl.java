package Services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import DAO.BusinessAnalyticDAO;
import DAO.CustomerDAO;
import DAO.DeliveryGuyDAO;

import com.bionic.edu.ERestro.DeliveryStatus;
import com.bionic.edu.ERestro.Orders;

@Named
public class OrderServiceImpl implements OrderService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	DeliveryGuyDAO deliveryDAO;
	@Inject 
	CustomerDAO customerDAO;
	
	@Inject
	BusinessAnalyticDAO baDAO;
	@Transactional
	public void save(Orders order) {
		if (order.getId()==0) {
			customerDAO.submitOrder(order);
		} else {
			deliveryDAO.saveOrder(order);
		}
	}

	public List<Orders> getUnfinishedOrdersList() {
		List<Orders> list = deliveryDAO.getOrdersList();
		return list;
	}

	@Override
	public List<Orders> getAllOrdersList() {
		List<Orders> list = deliveryDAO.getAllOrdersList();
		return null;
	}
	
	public List<Orders> getFinishedOrdersList() {
		List<Orders> list = baDAO.getOrdersList();
		return list;
	}

	@Override
	public Orders findById(int id) {
		Orders result = deliveryDAO.findById(id);
		return result;
	}

	@Override
	public List<Orders> getCustomersOrdersList(int customerId) {
		List<Orders> list = customerDAO.getMyOrders(customerId);
		return list;
	}


}
