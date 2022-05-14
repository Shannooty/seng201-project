package purchasable.monsters;

/**
 * Extends Monster. A type of monster that the player can own or buy in the shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class Slime extends Monster {
	
	/**
	 * Constructor for Slime. Calls the superclass constructor with the name of the Slime, its maximum health, attack amount, and speed.
	 *  Sets the image path, image, heal amount, type purchase price and sell back price for the Slime.
	 */
	public Slime() {
		super("Slimey Boy", 750, 300, 20);
		setImgPath("/images/slime.png");
		setImg();
		setHealAmount(750);
		setMonsterType("slime");
		setPurchasePrice(65);
		setSellPrice(65);
	}
}
