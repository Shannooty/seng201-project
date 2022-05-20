package purchasable.items.weapons;

/**
 * Extends Weapon. A type of item that the player can buy in the shop.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class Knife extends Weapon{

	/**
	 * Constructor for Knife. Calls the superclass constructor with the name of the Knife, and the attack amount.
	 *  Sets the purchase price, sell-back price, image path and image for the Knife.
	 */
	public Knife() {
		super("Knife", 60);
		setPurchasePrice(17);
		setSellPrice(12);
		setImgPath("/images/knife.png");
		setImg();
	}
}
