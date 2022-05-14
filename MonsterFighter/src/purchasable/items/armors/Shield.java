package purchasable.items.armors;

/**
 * Extends Armor. A type of item that the player can buy in the shop.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class Shield extends Armor {

	/**
	 * Constructor for Shield. Calls the superclass constructor with the name of the Shield the health increase and the armor amount.
	 *  Sets the purchase price, sell-back price, image path and image for the Shield.
	 */
	public Shield() {
		super("Shield", 200, 100);
		setPurchasePrice(30);
		setSellPrice(30);
		setImgPath("/images/shield.png");
		setImg();
	}
}
