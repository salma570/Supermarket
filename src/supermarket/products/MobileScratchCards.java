package supermarket.products;

public class MobileScratchCards extends Products {

	public MobileScratchCards() {
	}

	public MobileScratchCards(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	@Override
	public boolean expires() {
		return false;
	}

}
