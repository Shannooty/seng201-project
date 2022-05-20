package purchasable.items.armors;

/**
 * Extends Armor. A type of item that the player can buy in the shop.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class Chainmail extends Armor {

	/**
	 * Constructor for Chainmail. Calls the superclass constructor with the name of the Chainmail the health increase and the armor amount.
	 *  Sets the purchase price, sell-back price, image path and image for the Chainmail.
	 */
	public Chainmail() {
		super("Chainmail", 250, 300);
		setPurchasePrice(60);
		setSellPrice(50);
		setImgPath("/images/chainmail.png");
		setImg();
	}
}
