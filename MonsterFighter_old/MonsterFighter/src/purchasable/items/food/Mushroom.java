package purchasable.items.food;

/**
 * Extends Food. A type of item that the player can buy in the shop.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class Mushroom extends Food {
	
	/**
	 * Constructor for Mushroom. Calls the superclass constructor with the name of the Mushroom.
	 *  Sets the purchase price, sell-back price, image path and image for the Mushroom.
	 */
	public Mushroom() {
		super("Mushroom");
		setHealAmount(70);
		setPurchasePrice(10);
		setSellPrice(10);
		setImgPath("/images/mushroom.png");
		setImg();
	}
}
