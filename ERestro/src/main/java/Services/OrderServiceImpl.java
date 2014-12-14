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
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Orders> getFinishedOrdersList() {
		List<Orders> list = baDAO.getOrdersList();
		return list;
	}

	@Override
	public List<DeliveryStatus> getStatusList() {
		List<DeliveryStatus> result = deliveryDAO.getStatusList();
		return result;
	}

	@Override
	public Orders findById(int id) {
		Orders result = deliveryDAO.findById(id);
		return result;
	}

}
