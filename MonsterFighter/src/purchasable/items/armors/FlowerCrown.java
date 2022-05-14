package purchasable.items.armors;

/**
 * Extends Armor. A type of item that the player can buy in the shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class FlowerCrown extends Armor {
	
	/**
	 * Constructor for FlowerCrown. Calls the superclass constructor with the name of the FlowerCrown the health increase and the armor amount.
	 *  Sets the purchase price, sell-back price, image path and image for the FlowerCrown.
	 */
	public FlowerCrown() {
		super("Flower Crown", 300, 0);
		setPurchasePrice(10);
		setSellPrice(10);
		setImgPath("/images/flowerCrown.png");
		setImg();
	}
}
