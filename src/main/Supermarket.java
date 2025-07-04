package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import services.ShippingService;
import supermarket.cart.Cart;
import supermarket.products.*;

public class Supermarket {
	public static ShippingService defaultshippingService;
	static HashMap<Products, Date> productExpirydates = new HashMap<Products, Date>();
	private static double shippingfeesperkilo;

	@SuppressWarnings("unused")
	public Supermarket() {
		// create the shipping service  

		defaultshippingService = new ShippingService("service1", 30, 1);
		shippingfeesperkilo = defaultshippingService.getPrice_perKilo();

		// add items with their corresponding the expiry dates 
		Biscuits oreo = new Biscuits("oreo", 10.5, 20);
		Biscuits digestive = new Biscuits("digestive", 10.5, 20);
		Cheese gouda = new Cheese("gouda", 20.5, 3, 200);
		Cheese cheddar = new Cheese("cheeder", 30, 3, 200);
		Cheese parmesan = new Cheese("parmesan", 70, 3, 200);
		TV sumsung_tv = new TV("sumsung", 20000, 100);
		Mobile lenovo_mobile = new Mobile("lenovo", 50000, 20);



		// Current date
		Calendar cal = Calendar.getInstance();

		// try an expired product 5 days ago
		cal.add(Calendar.DATE, -5);
		Date expiredDate = cal.getTime();

		// add an un-expired date to the rest of the products
		cal = Calendar.getInstance(); 
		cal.add(Calendar.DATE, 30);
		Date notExpiredDate = cal.getTime();

		// Add to HashMap
		productExpirydates.put(oreo, expiredDate); // expired
		productExpirydates.put(digestive, notExpiredDate);
		productExpirydates.put(gouda, notExpiredDate);
		productExpirydates.put(cheddar, notExpiredDate);
		productExpirydates.put(parmesan, notExpiredDate);

	}

	public static double getShippingfeesperkilo() {
		return shippingfeesperkilo;
	}
	public static boolean checkExpirydates(Cart cart) {
		// true if no problem found

		ArrayList<String> items = cart.getCartItemsList();
		Date today = new Date();
		for (int i = 0; i < items.size(); i++) {
			Products p = Products.availableProducts.get(items.get(i).toLowerCase());
			Date expiryDate = productExpirydates.get(Products.availableProducts.get(items.get(i).toLowerCase()));
			if (expiryDate != null && expiryDate.before(today)) {
				return false;
			}
		}
		return true;
	}


}
