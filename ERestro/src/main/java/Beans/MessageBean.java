package Beans;

import javax.faces.bean.*;
import javax.inject.Named;

import org.springframework.context.annotation.*;

@Named("msgs")
@Scope("session")
public class MessageBean {
	private final String emailRequired = "Email address is required";
	private final String passwordRequired = "Password is required";
	private final String dishNameRequired = "Name is required";
	private final String priceRequired = "Please enter the price";
	private final String loginTrouble = "Whoops, looks like email or password is wrong. Try entering another combination";
	private final String categoryRequired = "Please pick the category";
	private final String birthdayFormat = "Please enter the date in right format. Example: 21.06.2014";
	
	
	public String getCategoryRequired() {
		return categoryRequired;
	}
	public String getEmailRequired() {
		return emailRequired;
	}
	public String getPasswordRequired() {
		return passwordRequired;
	}
	public String getDishNameRequired() {
		return dishNameRequired;
	}
	public String getPriceRequired() {
		return priceRequired;
	}
	public String getLoginTrouble() {
		return loginTrouble;
	}
	public String getBirthdayFormat() {
		return birthdayFormat;
	}
	
	
}
