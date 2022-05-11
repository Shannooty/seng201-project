package exceptions;

/**
 * 
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class NegativeValueException extends IllegalArgumentException {

	/**
	 * Attribute serialVersionUID, of type static final long. A serialVersion.
	 */
	private static final long serialVersionUID = -4596000100030514801L;
	
	/**
	 * Constructor for NegativeValueException. Accepts no parameters. Returns nothing.
	 */
	public NegativeValueException() {}
	
	/**
	 * Constructor for NegativeValueException. Calls the SuperClass constructor for IllegalArgumentException.
	 * @param message, of type String. The message to pass to the SuperClass constructor.
	 */
	public NegativeValueException(String message) {
		super(message);
	}
}
