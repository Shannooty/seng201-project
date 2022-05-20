package purchasable.items.weapons;

/**
 * Extends Weapon. A type of item that the player can buy in the shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class SledgeHammer extends Weapon {
	
	/**
	 * Constructor for SledgeHammer. Calls the superclass constructor with the name of the SledgeHammer, and the attack amount.
	 *  Sets the purchase price, sell-back price, image path and image for the SledgeHammer.
	 */
	public SledgeHammer() {
		super("Sledgehammer", 100);
		setPurchasePrice(22);
		setSellPrice(15);
		setImgPath("/images/sledgehammer.png");
		setImg();
	}


}
