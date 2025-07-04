package supermarket.products;

import java.util.HashMap;

public abstract class Products {
	private String name;
	private double price;
	private int quantity;
	
	public static HashMap<String, Products> availableProducts = new HashMap<>();
	
	protected Products() {
		
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	protected Products(String name, double price, int quantity) {
		super();
		this.name = name.toLowerCase();
		this.price = price;
		this.quantity = quantity;
		availableProducts.put(name.toLowerCase(), this);
	}
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return  name + " " + price;
	}
	
	protected abstract boolean expires();

}
