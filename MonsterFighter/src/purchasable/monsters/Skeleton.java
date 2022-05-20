package purchasable.monsters;

/**
 * Extends Monster. A type of monster that the player can own or buy in the shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class Skeleton extends Monster {
	
	/**
	 * Constructor for Skeleton. Calls the superclass constructor with the name of the Skeleton, its maximum health, attack amount, and speed.
	 *  Sets the image path, image, heal amount, type purchase price and sell back price for the Skeleton.
	 */
	public Skeleton() {
		super("Bare Bones", 600, 350, 35);
		setImgPath("/images/skeleton.png");
		setImg();
		setHealAmount(400);
		setPurchasePrice(70);
		setSellPrice(70);
		setMonsterType("skeleton");
	}
	
}
