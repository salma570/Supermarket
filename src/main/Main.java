package main;

import supermarket.cart.Cart;
import supermarket.people.Customer;

public class Main {

	public static void main(String[] args) {
		
		// valid carts
		
//		testcase1(); // valid cart with shippable items
//		testcase10();// no shippable items
//		testcase7(); // duplicate item combine quantities
//		testcase9(); // case sensitivity

		
		// testing Exceptions 
		
//		testcase2(); // balance less than total amount
//		testcase3(); // Product doesn't exist
//		testcase4(); // quantity less than expected
//		testcase5(); // Expired item added
//		testcase6(); // negative Quantity added
//		testcase8(); // empty cart checked Out

		
		
	}
	public static void testcase1() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 4000);
		Cart cart = new Cart();

		try {
			// Add products to cart
			cart.add("cheeder", 2);         
			cart.add("digestive", 1);       

			// Proceed to checkout
			Customer.checkout(fares, cart);
		} catch (Exception e) {
			System.out.println("Error during checkout: " + e.getMessage());
		}
	}
	public static void testcase2() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 100);
		Cart cart = new Cart();
		try {
			cart.add("cheeder", 2);
			cart.add("parmesan", 1);
			Customer.checkout(fares, cart);
		} catch (Exception e) {
			System.out.println("Error during checkout: (balance less than total amount)" + e.getMessage());
		}
	}
	public static void testcase7() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 4000);
		Cart cart = new Cart();
		try {
			cart.add("cheeder", 1); // duplicate item combine quantities
			cart.add("cheeder", 2); 
		    Customer.checkout(fares, cart);
		} catch (Exception e) {
		    System.out.println("Expected checkout error (none expected): " + e.getMessage());
		}
	}
	
	public static void testcase9() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 4000);
		Cart cart = new Cart();
		try {
			cart.add("chEEder", 1); // case sensitivity
		    Customer.checkout(fares, cart); 
		} catch (Exception e) {
		    System.out.println("Expected checkout error (quantity can't be less than 1): " + e.getMessage());
		}
	}
	public static void testcase10() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 4000);
		Cart cart = new Cart();
		try {
			cart.add("lenovo", 1); // no shippable items
		    Customer.checkout(fares, cart); 
		} catch (Exception e) {
		    System.out.println("Expected checkout error (none): " + e.getMessage());
		}
	}
	
	public static void testcase3() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 4000);
		Cart cart = new Cart();
		
		try {
			cart.add("notrealproduct", 1); // Product doesn't exist
		} catch (Exception e) {
		    System.out.println("Expected error: (Not Real Product)" + e.getMessage());
		}
	}

	public static void testcase4() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 4000);
		Cart cart = new Cart();
		try {
			cart.add("parmesan", 10); // Only 3 available
		} catch (Exception e) {
		    System.out.println("Expected error: (quantitty less than expected)" + e.getMessage());
		}
	}
	public static void testcase5() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 4000);
		Cart cart = new Cart();
		try {
			cart.add("oreo", 1); // Expired item
		    Customer.checkout(fares, cart);
		} catch (Exception e) {
		    System.out.println("Expected checkout error (expired): " + e.getMessage());
		}
	}
	public static void testcase6() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 4000);
		Cart cart = new Cart();
		try {
			cart.add("cheeder", -1); //negative Quantity
		    Customer.checkout(fares, cart);
		} catch (Exception e) {
		    System.out.println("Expected checkout error (Quantity must be greater than 0): " + e.getMessage());
		}
	}
	
	public static void testcase8() {
		Supermarket Fawry = new Supermarket();
		Customer fares = new Customer("Fares", 4000);
		Cart cart = new Cart();
		try {
		    Customer.checkout(fares, cart); // empty cart
		} catch (Exception e) {
		    System.out.println("Expected checkout error (Empty cart): " + e.getMessage());
		}
	}
	
}
