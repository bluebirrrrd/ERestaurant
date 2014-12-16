package Beans;

import java.util.List;

import javax.inject.*;

import org.springframework.context.annotation.Scope;

import Services.OrderService;

import com.bionic.edu.ERestro.Orders;

@Named
@Scope("request")
public class OrderListBean {

	private List<Orders> orderList;
	@Inject
	private OrderService orderService;
	
	private double total;
	
	public  List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orders) {
		orderList = orders;
	}
	
	public void refreshUnfinishedList() {
		orderList = orderService.getUnfinishedOrdersList();
	}
	
	public void refreshAllList() {
		total=0.0;
		orderList = orderService.getAllOrdersList();
		for (Orders o: orderList) {
			total += o.getTotal();
		}
	}
	
	public void refreshFinishedList() {
		orderList = orderService.getFinishedOrdersList();
	}
	
	public void refreshCustList(String customerId) {
		orderList = orderService.getCustomersOrdersList(Integer.valueOf(customerId));
	}
	
}
