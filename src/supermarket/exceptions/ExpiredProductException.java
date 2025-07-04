package supermarket.exceptions;

@SuppressWarnings("serial")
public class ExpiredProductException extends Exception {

	public ExpiredProductException() {
		super();
	}

	public ExpiredProductException(String message) {
		super(message);
	}

}
