package supermarket.exceptions;

@SuppressWarnings("serial")
public class NotEnoughProductException extends Exception {

	public NotEnoughProductException() {
		super();
	}

	public NotEnoughProductException(String message) {
		super(message);
	}


}
