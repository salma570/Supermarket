package supermarket.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {
	}

	public ProductNotFoundException(String message) {
		super(message);
	}


}
