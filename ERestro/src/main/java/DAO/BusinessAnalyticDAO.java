package DAO;

import java.util.List;

import com.bionic.edu.ERestro.Food_Order;
import com.bionic.edu.ERestro.Orders;

public interface BusinessAnalyticDAO {
	public List<Orders> getOrdersList();
	public List<Food_Order> getPartsList();
	public List<Food_Order> getPartsBetweenDates(String startDate, String endDate);
}
