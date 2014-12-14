package Services;

import java.util.List;

import com.bionic.edu.ERestro.*;
public interface OrderService {
	public void save(Orders order);
	public List<Orders> getUnfinishedOrdersList();
	public List<Orders> getAllOrdersList();
	public List<Orders> getFinishedOrdersList();
	public List<DeliveryStatus> getStatusList();
	public Orders findById(int id);
}
