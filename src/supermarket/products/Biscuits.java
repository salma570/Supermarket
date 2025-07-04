package supermarket.products;

public class Biscuits extends Products {

	public Biscuits() {
	}

	public Biscuits(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	@Override
	public boolean expires() {
		return true;
	}

}
