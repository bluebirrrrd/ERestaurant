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
		orderList = orderService.getAllOrdersList();
	}
	
}
