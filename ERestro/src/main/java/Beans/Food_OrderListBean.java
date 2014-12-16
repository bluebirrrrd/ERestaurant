package Beans;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import javax.inject.*;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.ERestro.FoodCategory;
import com.bionic.edu.ERestro.Food_Order;

import Services.FoodService;
import Services.Food_OrderService;

@Named
@Scope("session")
public class Food_OrderListBean {
	
	private List<Food_Order> foodOrderList;
	private Map<FoodCategory, Double> summary = new LinkedHashMap<FoodCategory, Double>();
	private List<FoodCategory> categories;
	private Date startDate;
	private Date endDate;
	private int selectedCategoryId;
	@Inject
	Food_OrderService foodOrderService;
	@Inject
	FoodService foodService;
	public List<Food_Order> getFoodOrderList() {
		return foodOrderList;
	}

	public void setFoodOrderList(List<Food_Order> foodOrderList) {
		this.foodOrderList = foodOrderList;
	}
	
	public Map<FoodCategory, Double> getSummary() {
		return summary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getSelectedCategoryId() {
		return selectedCategoryId;
	}

	public void setSelectedCategoryId(int selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}

	public void setSummary(Map<FoodCategory, Double> summary) {
		this.summary = summary;
	}

	public List<FoodCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<FoodCategory> categories) {
		this.categories = categories;
	}

	public void refreshList() {
		foodOrderList = foodOrderService.getAllFoodOrdersList();
	}
	
	public void refreshUndoneList() {
		foodOrderList = foodOrderService.getUndoneFoodOrdersList();
	}
	
	public void refreshCategories() {
		categories = foodService.getCategoriesList();
	}
	
	public void refreshSummary() {
		refreshCategories();
		summary = new LinkedHashMap<FoodCategory, Double>();
		for (Food_Order f: foodOrderList) {
			for (FoodCategory c: categories) {
				double tempTotal = 0.0;
				if (f.getFood().getCategory().getId() == c.getId()) {
					tempTotal += f.getFood().getPrice()*f.getQuantity();
				}
				summary.put(c, tempTotal);
			}
		}
	}
	
	public String refreshListByDates() {
		List<Food_Order> tempList = new ArrayList<Food_Order>();
		/*Iterator<Food_Order> it = foodOrderList.iterator();
		while (it.hasNext()) {
			Food_Order item = it.next();
			Date tempDate = item.getOrder().getTime();
			if (tempDate.after(startDate) && tempDate.before(endDate)) {
				tempList.add(item);
			}
		}*/
		for (Food_Order item: foodOrderList) {
			Date tempDate = item.getOrder().getTime();
			if (tempDate.after(startDate) && tempDate.before(endDate)) {
				tempList.add(item);
			}
		}
		foodOrderList = tempList;
		refreshSummary();
		return "business";
		
	}
	
}
