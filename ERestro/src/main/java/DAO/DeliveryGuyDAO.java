package DAO;

import java.util.List;

import com.bionic.edu.ERestro.*;
public interface DeliveryGuyDAO {
	public List<Orders> getOrdersList();
	public void saveOrder(Orders order);
	public List<DeliveryStatus> getStatusList();
	public Orders findById(int id);
	public DeliveryStatus findStatusById(int id);
}
