package exceptions;

public class InsufficientGoldException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2105306552621012188L;

	public InsufficientGoldException() {}
	
	public InsufficientGoldException(String message) {
		super(message);
	}
}
