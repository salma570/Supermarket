package supermarket.products;

public class TV extends Products implements Shippable {
	private double weight;
	
	public TV() {
	}

	public TV(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public boolean expires() {
		return false;
	}

}
