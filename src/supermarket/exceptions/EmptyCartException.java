package supermarket.exceptions;

@SuppressWarnings("serial")
public class EmptyCartException extends Exception {

	public EmptyCartException() {
		super();
	}

	public EmptyCartException(String message) {
		super(message);
	}


}
