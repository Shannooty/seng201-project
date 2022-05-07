package exceptions;

import gui.GameEnvironment;
import gui.ShopBuy;

/**
 * 
 * @author
 *
 */
public class InsufficientGoldException extends IllegalArgumentException {

	/**
	 * Attribute serialVersionUID, of type static final long. A serialVersion.
	 */
	private static final long serialVersionUID = 2105306552621012188L;

	/**
	 * Constructor for InsufficientGoldException. Accepts no parameters. Returns nothing.
	 */
	public InsufficientGoldException() {}
	
	/**
	 * Constructor for InsufficientGoldException. Calls the SuperClass constructor for IllegalArgumentException.
	 * @param message, of type String. The message to pass to the SuperClass constructor.
	 */
	public InsufficientGoldException(String message, GameEnvironment gameEnvironment) {
//		super(message);
		gameEnvironment.getShopBuyScreen().insufficientGoldPopUp(message);
	}
}
