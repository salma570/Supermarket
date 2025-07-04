package supermarket.cart;

import java.util.ArrayList;
import java.util.HashMap;

import supermarket.exceptions.NotEnoughProductException;
import supermarket.exceptions.ProductNotFoundException;
import supermarket.products.Products;
import supermarket.products.Shippable;

public class Cart {

	private HashMap<String, Integer> cart = new HashMap<>();
	private HashMap<String, Double> shippableItems = new HashMap<>();
	private double total;
	private double shippingWeight_inGramms;

	public double getTotal() {
		return total;
	}
	public boolean isEmpty() {
		return cart.size() ==0;
	}
	public boolean isShippable() {
		return shippableItems.size() != 0;
	}
	public double getShippingWeight() {
		return shippingWeight_inGramms/1000;
	}

	public HashMap<String, Double> getShippableItems() {
		return shippableItems;
	}
	public void add(String item, int quantity)throws NotEnoughProductException,ProductNotFoundException{
		// find the product itself

		item = item.toLowerCase();
		Products product = Products.availableProducts.get(item);

		if(product == null) {
			throw new ProductNotFoundException("this product is not not available");
		}
		if(quantity<= 0) {
			throw new IllegalArgumentException("Quantity must be greater than 0");
		}

		if(product.getQuantity()<quantity) {
			throw new NotEnoughProductException("Not enough product available");
		}

		// else actually add the product
		
		//handle duplicate products by combining quantities
		if(cart.containsKey(item.toLowerCase())) {
			cart.replace(item, cart.get(item)+quantity);
			if(product instanceof Shippable) {
				shippableItems.replace(item, shippableItems.get(item)+((Shippable)product).getWeight()*quantity);	
				shippingWeight_inGramms += ((Shippable)product).getWeight()*quantity;
			}
		}else {
			cart.put(item, quantity);
			if(product instanceof Shippable) {
				shippableItems.put(item, ((Shippable)product).getWeight()*quantity);	
				shippingWeight_inGramms += ((Shippable)product).getWeight()*quantity;
			}
		}
		
		this.total += quantity * product.getPrice();
		product.setQuantity(product.getQuantity()-quantity);
		
	}
	public ArrayList<String> getCartItemsList() {
		ArrayList<String> items = new ArrayList<>();

		for (String productName : cart.keySet()) {
			items.add(productName);
		}

		return items;
	}
	@Override
	public String toString() {
		String result = "";
		for (String i : cart.keySet()) {
			Products product = Products.availableProducts.get(i.toLowerCase());
			result += "x" + cart.get(i) + " " + i + " "+ (product.getPrice()*cart.get(i))+ "LE\n";
		}
		return result;
	}
	public String ShippingReceipt(){
		double total_item_Weight =0;
		String result = "";
		for (String i : cart.keySet()) {
			Products product = Products.availableProducts.get(i.toLowerCase());
			if(product instanceof Shippable) {
				total_item_Weight = (((Shippable) product).getWeight()*cart.get(i));
				result += "x" + cart.get(i) + " " + i + " "+ total_item_Weight+ "g\n";
			}
		}
		return result;
	}

}
