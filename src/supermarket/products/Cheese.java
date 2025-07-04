package supermarket.products;

public class Cheese extends Products implements Shippable {
	private double weight;
	
	public Cheese() {
	
	}

	private Cheese(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	public Cheese(String name, double price, int quantity, double weight) {
		this(name, price, quantity);
		this.weight = weight;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public boolean expires() {
		return true;
	}

}
