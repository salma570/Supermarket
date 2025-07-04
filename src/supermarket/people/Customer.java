package supermarket.people;

import main.Supermarket;
import supermarket.cart.Cart;
import supermarket.exceptions.EmptyCartException;
import supermarket.exceptions.ExpiredProductException;
import supermarket.exceptions.InsouciantBalanceException;

public class Customer {
	String name;
	double balance;
	
	public Customer(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	
	public static void checkout(Customer customer, Cart cart) throws InsouciantBalanceException,EmptyCartException,ExpiredProductException {
		double shippingFees = 0;
		
		if(cart.isEmpty()) {
			throw new EmptyCartException("Empty Cart Exception");
		}
		
		if(!Supermarket.checkExpirydates(cart)) {
			throw new ExpiredProductException("Product Expired detected");
		}
		if(cart.isShippable()) {
			shippingFees = Supermarket.getShippingfeesperkilo()*cart.getShippingWeight();
		}
		if(customer.balance<(shippingFees+ cart.getTotal())) {
			throw new InsouciantBalanceException("Unsupported Balance needed amount:" + (shippingFees+ cart.getTotal()));
		}
		
		if(cart.isShippable()) {
			System.out.println("** Shipment notice ** ");
			System.out.println(cart.ShippingReceipt());
			System.out.println("Total package weight " + cart.getShippingWeight()+ "Kg\n");
		}
		System.out.println("**Checkout receipt **"); 
		System.out.println(cart);
		System.out.println("-------------------------");
		System.out.println("subtotal " + cart.getTotal());
		System.out.println("Shipping Fees " + shippingFees);
		System.out.println("Amount "+ (shippingFees+ cart.getTotal()));	
		
		customer.balance -= (shippingFees+ cart.getTotal());
		
		System.out.println("Thank you for choosing our service\n checkout completed \n");
		System.out.println("current balance: "+ customer.balance);
		
		Supermarket.defaultshippingService.ship(cart.getShippableItems());
	}
	
}
