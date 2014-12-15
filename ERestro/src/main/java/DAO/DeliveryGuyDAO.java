package DAO;

import java.util.List;

import com.bionic.edu.ERestro.*;
public interface DeliveryGuyDAO {
	public List<Orders> getOrdersList();
	public void saveOrder(Orders order);
	public Orders findById(int id);
	public List<Orders> getAllOrdersList();
}
