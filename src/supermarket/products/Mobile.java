package supermarket.products;

public class Mobile extends Products {

	public Mobile() {
	}

	public Mobile(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	@Override
	public boolean expires() {
		return false;
	}

}
