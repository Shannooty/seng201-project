package purchasable.items.food;

/**
 * Extends Food. A type of item that the player can buy in the shop.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class Bread extends Food {
	
	/**
	 * Constructor for Bread. Calls the superclass constructor with the name of the Bread.
	 *  Sets the purchase price, sell-back price, image path and image for the Bread.
	 */
	public Bread() {
		super("Bread");
		setHealAmount(120);
		setPurchasePrice(17);
		setSellPrice(0);
		setImgPath("/images/bread.png");
		setImg();
	}

}
