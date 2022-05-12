package exceptions;

import gui.GameEnvironment;

/**
 * A custom exception for when the player tries to purchase a new monster, but they already have a team size of 4.
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
