package purchasable.items.food;

/**
 * Extends Food. A type of item that the player can buy in the shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class Apple extends Food {

	/**
	 * Constructor for Apple. Calls the superclass constructor with the name of the Apple.
	 *  Sets the purchase price, sell-back price, image path and image for the Apple.
	 */
	public Apple() {
		super("Apple");
		setHealAmount(100);
		setPurchasePrice(15);
		setSellPrice(0);
		setImgPath("/images/apple.png");
		setImg();
	}
}
