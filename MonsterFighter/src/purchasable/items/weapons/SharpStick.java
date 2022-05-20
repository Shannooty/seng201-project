package purchasable.items.weapons;

/**
 * Extends Weapon. A type of item that the player can buy in the shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class SharpStick extends Weapon {
	
	/**
	 * Constructor for SharpStick. Calls the superclass constructor with the name of the SharpStick, and the attack amount.
	 *  Sets the purchase price, sell-back price, image path and image for the SharpStick.
	 */
	public SharpStick() {
		super("Sharp Stick", 50);
		setPurchasePrice(12);
		setSellPrice(8);
		setImgPath("/images/sharpStick.png");
		setImg();
	}

}
