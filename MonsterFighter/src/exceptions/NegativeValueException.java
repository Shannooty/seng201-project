package exceptions;

public class NegativeValueException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4596000100030514801L;
	
	public NegativeValueException() {}
	
	public NegativeValueException(String message) {
		super(message);
	}
}
