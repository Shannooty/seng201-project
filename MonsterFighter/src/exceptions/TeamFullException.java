package exceptions;

import gui.GameEnvironment;

/**
 * 
 * @author 
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
	public TeamFullException(String message, GameEnvironment gameEnvironment) {
//		super(message);
		gameEnvironment.getShopBuyScreen().insufficientGoldPopUp(message);
	}

}
