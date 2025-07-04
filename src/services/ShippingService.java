package services;

import java.util.HashMap;

public class ShippingService {
	String name;
	double price_perKilo;
	double Averagewaitingtime;
	
	public ShippingService(String name, double weight_perKilo, double averagewaitingtime) {
		super();
		this.name = name;
		this.price_perKilo = weight_perKilo;
		Averagewaitingtime = averagewaitingtime;
	}
	public ShippingService(String name, double weight_perKilo) {
		super();
		this.name = name;
		this.price_perKilo = weight_perKilo;
	}
	public double getPrice_perKilo() {
		return price_perKilo;
	}
	public void ship(HashMap<String, Double> shippableItems) {
		System.out.println("Shipping in progress !!");
		System.out.println("delivery Expected within"+ Averagewaitingtime + " Day");
	}
	
}
