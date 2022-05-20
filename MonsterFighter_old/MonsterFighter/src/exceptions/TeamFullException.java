package exceptions;

/**
 * TeamFullException is thrown when the players team if already full and a new Monster is attempted to be added
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class TeamFullException extends IllegalArgumentException {

	/**
	 * Attribute serialVersionUID, of type static final long. A serialVersion.
	 */
	private static final long serialVersionUID = 5315714111120614979L;
	
	/**
	 * Constructor for TeamFullException. Accepts no parameters. Returns nothing.
	 */
	public TeamFullException() {};
	
	/**
	 * Constructor for TeamFullException. Calls the SuperClass constructor for IllegalArgumentException.
	 * @param message, of type String. The message to pass to the SuperClass constructor.
	 */
	public TeamFullException(String message) {
		super(message);
	}

}
