package Beans;

import javax.inject.*;

import org.springframework.context.annotation.Scope;

import Services.Food_OrderService;

import com.bionic.edu.ERestro.Food_Order;

@Named
@Scope("request")
public class Food_OrderBean {

	private Food_Order part;
	
	@Inject
	private Food_OrderService foodOrderService;

	public Food_Order getPart() {
		return part;
	}

	public void setPart(Food_Order part) {
		this.part = part;
	}
	
	public void setDone() {
		part.setDone(true);
		foodOrderService.save(part);
	}
}
